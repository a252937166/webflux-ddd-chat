package com.ouyanglol.chat.dao.mongo;

import com.ouyanglol.chat.tunnel.dataobject.MessageDO;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author ouyangduning
 * @date 2020/10/31 17:19
 */
public interface MessageMongoDao extends ReactiveCrudRepository<MessageDO, String> {
    /**
     * 根据接收者Id和消息状态查找
     * @param toId 接收者
     * @param status 状态 0 未回执 1已回执
     * @return flux
     */
    @Tailable
    Flux<MessageDO> findByToIdAndStatus(String toId, Integer status);
}
