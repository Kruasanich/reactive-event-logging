package ru.hormunkul.study.spring.reactivity.action.listener

import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import ru.hormunkul.study.spring.reactivity.action.LoggingMessageEvent

/**
 * Logging all message witch generate system.
 */
@Slf4j
@Component
class LoggingEventListener implements ApplicationListener<LoggingMessageEvent> {
    @Override
    void onApplicationEvent(LoggingMessageEvent event) {
        log.info("Recive message: ${event.message}")
    }
}
