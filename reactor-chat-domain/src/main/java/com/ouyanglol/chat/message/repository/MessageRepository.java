package com.ouyanglol.chat.message.repository;

import com.ouyanglol.chat.common.RepositoryI;
import com.ouyanglol.chat.message.convertor.MessageConvertor;
import com.ouyanglol.chat.message.entity.MessageE;
import com.ouyanglol.chat.message.valueobject.MessageStatusType;
import com.ouyanglol.chat.tunnel.datatunnel.MessageTunnelI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:39
 */
@Repository
public class MessageRepository implements RepositoryI {

    @Autowired
    private MessageTunnelI messageTunnel;
    @Autowired
    private MessageConvertor convertor;

    /**
     * 根据id获取
     *
     * @param id id
     * @return 领域聚合
     */
    public Mono<MessageE> get(String id) {
        return messageTunnel.get(id).map(messageDO -> convertor.dataToEntity(messageDO));
    }

    /**
     * 根据接收者id和消息状态获取
     *
     * @param id     接收者id
     * @param status 消息状态
     * @return
     */
    public Flux<MessageE> getByToIdAndStatus(String id, MessageStatusType status) {
        return messageTunnel.getByToIdAndStatus(id, status.getCode()).map(messageDO -> convertor.dataToEntity(messageDO));
    }

    public Mono<MessageE> save(MessageE messageE) {
        return messageTunnel.save(convertor.entityToData(messageE)).map(messageDO -> convertor.dataToEntity(messageDO));
    }

    public Mono<MessageE> update(MessageE message) {
        //FIXME 应该使用mongo语法进行update操作
        Optional<MessageE> messageOptional = get(message.getId()).blockOptional(Duration.ofSeconds(5));
        if (!messageOptional.isPresent()) {
            throw new RuntimeException("user不存在");
        }
        MessageE messageE = messageOptional.get();
        BeanUtils.copyProperties(message, messageE, getNullPropertyNames(message));
        return messageTunnel.save(convertor.entityToData(messageE)).map(messageDO -> convertor.dataToEntity(messageDO));
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
