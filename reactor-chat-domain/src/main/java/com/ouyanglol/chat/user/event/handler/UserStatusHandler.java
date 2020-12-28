package com.ouyanglol.chat.user.event.handler;

import com.ouyanglol.chat.user.event.domainevent.UserStatusChangeEvent;
import com.ouyanglol.chat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:07
 */
@Component
public class UserStatusHandler implements ApplicationListener<UserStatusChangeEvent> {

    @Autowired
    private UserRepository repository;

    @Override
    public void onApplicationEvent(UserStatusChangeEvent event) {
        repository.update(event.getSource()).subscribe();
    }
}
