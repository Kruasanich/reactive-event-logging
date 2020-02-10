package ru.hormunkul.study.spring.reactivity.messaging.listener


import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import ru.hormunkul.study.spring.reactivity.action.LoggingMessageEvent
import ru.hormunkul.study.spring.reactivity.model.UserEvent

@Service
class UserEventListener {
    private ApplicationEventPublisher publisher

    UserEventListener(ApplicationEventPublisher publisher) {
        this.publisher = publisher
    }

    /**
     * Listener of user actions.
     * @param userEvent - Event witch user had made.
     */
    @RabbitListener(queues = ["\${messaging.rabbitmq.incomeQueue}"], concurrency = "2")
    void userActionHandler(UserEvent userEvent) {
        if(userEvent != null) {
            publisher.publishEvent(
                    new LoggingMessageEvent(
                            this,
                            "Receive user event from rabbitmq with id = ${userEvent.userId} and time = " +
                                    "${userEvent.created}"
                    )
            )
        }
    }
}
