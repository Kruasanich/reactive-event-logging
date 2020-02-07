package ru.hormunkul.study.spring.reactivity.action.listener

import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import ru.hormunkul.study.spring.reactivity.action.PrintMessageEvent

@Slf4j
@Component
class PrintEventListener implements ApplicationListener<PrintMessageEvent> {
    @Override
    void onApplicationEvent(PrintMessageEvent event) {
        log.info("Recive message: ${event.message}")
    }
}
