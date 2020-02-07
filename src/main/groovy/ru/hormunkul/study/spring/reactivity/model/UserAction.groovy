package ru.hormunkul.study.spring.reactivity.model

import ru.hormunkul.study.spring.reactivity.model.common.ActionType

import java.time.LocalDateTime

class UserAction {
    String userId
    LocalDateTime created = LocalDateTime.now()
    ActionType type = ActionType.LOGIN
}