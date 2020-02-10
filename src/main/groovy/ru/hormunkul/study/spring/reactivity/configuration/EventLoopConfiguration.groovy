package ru.hormunkul.study.spring.reactivity.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.context.event.SimpleApplicationEventMulticaster
import org.springframework.core.task.SimpleAsyncTaskExecutor

/**
 * The configuration for asynchronous event listener.
 */
@Configuration
class EventLoopConfiguration {
    @Bean
    ApplicationEventMulticaster applicationEventMulticaster()  {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster()
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor()
        eventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor)
        return eventMulticaster
    }
}