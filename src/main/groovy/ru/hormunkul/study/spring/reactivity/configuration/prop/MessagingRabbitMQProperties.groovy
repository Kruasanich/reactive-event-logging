package ru.hormunkul.study.spring.reactivity.configuration.prop

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "messaging.rabbitmq")
class MessagingRabbitMQProperties {
    String exchange
    String incomeQueue
}