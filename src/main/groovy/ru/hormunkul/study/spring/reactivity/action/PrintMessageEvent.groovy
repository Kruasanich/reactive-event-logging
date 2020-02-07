package ru.hormunkul.study.spring.reactivity.action

import org.springframework.context.ApplicationEvent

class PrintMessageEvent extends ApplicationEvent {
    String message

    PrintMessageEvent(Object source, String message) {
        super(source)
        this.message = message
    }
}
