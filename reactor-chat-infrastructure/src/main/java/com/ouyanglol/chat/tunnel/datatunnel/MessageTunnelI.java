package com.ouyanglol.chat.tunnel.datatunnel;

import com.ouyanglol.chat.tunnel.dataobject.MessageDO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/10/31 16:50
 */
public interface MessageTunnelI {
    /**
     * 根据接收者Id和消息状态查找
     * @param toId 接收者
     * @param status 状态 0 未回执 1已回执
     * @return flux
     */
    Flux<MessageDO> getByToIdAndStatus(String toId, Integer status);

    /**
     * 保存
     * @param messageDO 实体
     * @return DO
     */
    Mono<MessageDO> save(MessageDO messageDO);

    /**
     * 通过id获取
     * @param id id
     * @return
     */
    Mono<MessageDO> get(String id);
}
