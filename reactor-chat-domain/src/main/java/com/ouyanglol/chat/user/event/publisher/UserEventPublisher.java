package com.ouyanglol.chat.user.event.publisher;

import com.ouyanglol.chat.user.event.domainevent.UserSaveEvent;
import com.ouyanglol.chat.user.event.domainevent.UserStatusChangeEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:06
 */
@Component
public class UserEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    public void publishStatusChange(UserStatusChangeEvent event) {
        publisher.publishEvent(event);
    }

    public void publishSave(UserSaveEvent event) {
        publisher.publishEvent(event);
    }
}
