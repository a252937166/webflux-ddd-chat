package com.ouyanglol.chat.user.event.handler;

import com.ouyanglol.chat.user.convertor.UserConvertor;
import com.ouyanglol.chat.user.event.domainevent.UserSaveEvent;
import com.ouyanglol.chat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:07
 */
@Component
public class UserSaveHandler implements ApplicationListener<UserSaveEvent> {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserConvertor convertor;

    @Override
    public void onApplicationEvent(UserSaveEvent event) {
        repository.save(convertor.clientToEntity(event.getSource())).subscribe();
    }
}
