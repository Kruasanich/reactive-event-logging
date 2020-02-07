package ru.hormunkul.study.spring.reactivity.init

import groovy.util.logging.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import ru.hormunkul.study.spring.reactivity.action.PrintMessageEvent

@Slf4j
@Component
class Initializer implements CommandLineRunner {

    private ApplicationEventPublisher publisher

    Initializer(ApplicationEventPublisher publisher) {
        this.publisher = publisher
    }

    @Override
    void run(String... args) throws Exception {
        log.info("Application initialized! Ready for work and do all what we need!")

        publisher.publishEvent(new PrintMessageEvent(this, "Event from Initializer!"))

        Flux.just("First", "Second", "Third")
            .subscribe {
                publisher.publishEvent(new PrintMessageEvent(this, it))
            }
    }
}