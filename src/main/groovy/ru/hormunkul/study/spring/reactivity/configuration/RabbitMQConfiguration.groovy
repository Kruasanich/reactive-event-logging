package ru.hormunkul.study.spring.reactivity.configuration

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.backoff.ExponentialBackOffPolicy
import org.springframework.retry.support.RetryTemplate
import ru.hormunkul.study.spring.reactivity.configuration.prop.MessagingRabbitMQProperties

@Configuration
class RabbitMQConfiguration {
    MessagingRabbitMQProperties messagingRabbitMQProperties

    RabbitMQConfiguration(MessagingRabbitMQProperties messagingRabbitMQProperties) {
        this.messagingRabbitMQProperties = messagingRabbitMQProperties
    }

    @Bean
    DirectExchange directExchange() {
        new DirectExchange(messagingRabbitMQProperties.exchange)
    }

    @Bean
    Queue incomeQueue() {
        new Queue(messagingRabbitMQProperties.incomeQueue)
    }

    @Bean
    Binding bindingRequest(DirectExchange directExchange, Queue incomeQueue) {
        BindingBuilder
                .bind(incomeQueue)
                .to(directExchange)
                .with(messagingRabbitMQProperties.incomeQueue)
    }

    @Bean
    AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory)
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)  {
        def rabbitTemplate = new RabbitTemplate(connectionFactory)
        def backOffPolicy = new ExponentialBackOffPolicy()
        def retryTemplate = new RetryTemplate()
        backOffPolicy.initialInterval = 500
        backOffPolicy.multiplier = 10.0
        backOffPolicy.maxInterval = 10000
        retryTemplate.setBackOffPolicy(backOffPolicy)
        rabbitTemplate.setRetryTemplate(retryTemplate)
        return rabbitTemplate
    }
}
