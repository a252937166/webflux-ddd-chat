package com.ouyanglol.chat.message.event.handler;

import com.ouyanglol.chat.message.convertor.MessageConvertor;
import com.ouyanglol.chat.message.event.domainevent.MessageSaveEvent;
import com.ouyanglol.chat.message.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/27 01:37
 */
@Slf4j
@Component
public class MessageSaveHandler implements ApplicationListener<MessageSaveEvent> {

    @Autowired
    private MessageRepository repository;
    @Autowired
    private MessageConvertor convertor;

    @Override
    public void onApplicationEvent(MessageSaveEvent event) {
        repository.save(convertor.clientToEntity(event.getSource())).subscribe();
    }
}

