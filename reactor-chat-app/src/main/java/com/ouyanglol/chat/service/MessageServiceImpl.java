package com.ouyanglol.chat.service;

import com.ouyanglol.chat.api.MessageServiceI;
import com.ouyanglol.chat.dto.MessageCO;
import com.ouyanglol.chat.message.convertor.MessageConvertor;
import com.ouyanglol.chat.message.event.domainevent.MessageSaveEvent;
import com.ouyanglol.chat.message.event.publisher.MessageEventPublisher;
import com.ouyanglol.chat.message.repository.MessageRepository;
import com.ouyanglol.chat.message.valueobject.MessageStatusType;
import com.ouyanglol.chat.request.MessageSaveCmd;
import com.ouyanglol.chat.request.UnReadMessageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author ouyangduning
 * @date 2020/12/24 21:12
 */
@RestController
public class MessageServiceImpl implements MessageServiceI {

    @Autowired
    private MessageRepository repository;
    @Autowired
    private MessageConvertor convertor;
    @Autowired
    private MessageEventPublisher publisher;

    @Override
    public Mono<MessageCO> save(MessageSaveCmd cmd) {
        return Mono.just(cmd.getMessage()).map(co -> {
            co.setStatus(MessageStatusType.UNREAD.getCode());
            co.setSendTime(new Date());
            publisher.publish(new MessageSaveEvent(co));
            return co;
        });
//        return repository.save(convertor.clientToEntity(cmd.getMessage()))
//                .map(messageE -> convertor.entityToClient(messageE));
    }

    @Override
    public Flux<MessageCO> queryUnreadMessage(UnReadMessageQuery query) {
        return repository.getByToIdAndStatus(query.getUserId(), MessageStatusType.UNREAD)
                .map(messageE -> convertor.entityToClient(messageE));
    }
}
