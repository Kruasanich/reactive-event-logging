package ru.hormunkul.study.spring.reactivity.action

import org.springframework.context.ApplicationEvent

/**
 * The message event for logging some information.
 */
class LoggingMessageEvent extends ApplicationEvent {
    String message

    LoggingMessageEvent(Object source, String message) {
        super(source)
        this.message = message
    }
}
