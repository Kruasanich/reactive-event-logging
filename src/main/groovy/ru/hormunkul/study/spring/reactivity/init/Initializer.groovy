package ru.hormunkul.study.spring.reactivity.init

import groovy.util.logging.Slf4j
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import ru.hormunkul.study.spring.reactivity.action.PrintMessageEvent
import ru.hormunkul.study.spring.reactivity.model.UserEvent

@Slf4j
@Component
class Initializer implements CommandLineRunner {

    private ApplicationEventPublisher publisher
    private RabbitTemplate rabbitTemplate
    private Queue incomeQueue


    Initializer(ApplicationEventPublisher publisher, RabbitTemplate rabbitTemplate, Queue incomeQueue) {
        this.publisher = publisher
        this.rabbitTemplate = rabbitTemplate
        this.incomeQueue = incomeQueue
    }

    @Override
    void run(String... args) throws Exception {
        log.info("Application initialized! Ready for work and do all what we need!")

        publisher.publishEvent(new PrintMessageEvent(this, "Event from Initializer!"))

        Flux.just("First", "Second", "Third")
            .subscribe {
                publisher.publishEvent(new PrintMessageEvent(this, it))
            }
        rabbitTemplate.convertAndSend(incomeQueue.name, new UserEvent(userId: 1))
    }
}