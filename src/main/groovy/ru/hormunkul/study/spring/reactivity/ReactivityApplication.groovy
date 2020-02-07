package ru.hormunkul.study.spring.reactivity

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import ru.hormunkul.study.spring.reactivity.configuration.prop.MessagingRabbitMQProperties

@EnableRabbit
@SpringBootApplication
@EnableConfigurationProperties(value = [MessagingRabbitMQProperties.class])
class ReactivityApplication {

	static void main(String[] args) {
		SpringApplication.run(ReactivityApplication, args)
	}

}
