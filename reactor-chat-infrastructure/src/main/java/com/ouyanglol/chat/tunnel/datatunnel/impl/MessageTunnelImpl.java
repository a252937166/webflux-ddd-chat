package com.ouyanglol.chat.tunnel.datatunnel.impl;

import com.ouyanglol.chat.dao.mongo.MessageMongoDao;
import com.ouyanglol.chat.tunnel.dataobject.MessageDO;
import com.ouyanglol.chat.tunnel.datatunnel.MessageTunnelI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/10/31 16:54
 */
@Component
public class MessageTunnelImpl implements MessageTunnelI {
    @Autowired
    private MessageMongoDao messageMongoDao;

    @Override
    public Flux<MessageDO> getByToIdAndStatus(String toId, Integer status) {
        return messageMongoDao.findByToIdAndStatus(toId, status).doOnNext(System.out::println);
    }

    @Override
    public Mono<MessageDO> save(MessageDO messageDO) {
        return messageMongoDao.save(messageDO);
    }

    @Override
    public Mono<MessageDO> get(String id) {
        return messageMongoDao.findById(id);
    }

}
