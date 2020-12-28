package com.ouyanglol.chat.tunnel.datatunnel;

import com.ouyanglol.chat.tunnel.dataobject.UserDO;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/12/15 21:42
 */
public interface UserTunnelI {

    /**
     * 根据id获取
     * @param id id
     * @return Mono
     */
    Mono<UserDO> get(String id);

    /**
     * 保存
     * @param userDO user实体
     */
    Mono<UserDO> save(UserDO userDO);

    Mono<UserDO> update(UserDO userDO);
}
