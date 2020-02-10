package ru.hormunkul.study.spring.reactivity.model

import ru.hormunkul.study.spring.reactivity.model.common.EventType

import java.time.LocalDateTime

class UserEvent implements Serializable {
    String userId
    LocalDateTime created = LocalDateTime.now()
    EventType type = EventType.LOGIN
}
