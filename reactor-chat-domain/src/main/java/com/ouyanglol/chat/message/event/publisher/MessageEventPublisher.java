package com.ouyanglol.chat.message.event.publisher;

import com.ouyanglol.chat.message.event.domainevent.MessageSaveEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/27 01:45
 */
@Component
@Slf4j
public class MessageEventPublisher implements ApplicationEventPublisherAware {
    //todo 使用Spring Integration或者MQ代替

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    public void publish(MessageSaveEvent event) {
        publisher.publishEvent(event);
    }
}
