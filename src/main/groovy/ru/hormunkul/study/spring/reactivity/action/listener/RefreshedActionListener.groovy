package ru.hormunkul.study.spring.reactivity.action.listener

import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Slf4j
@Component
class RefreshedActionListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Context refreshed! Application ready for work!")
    }
}