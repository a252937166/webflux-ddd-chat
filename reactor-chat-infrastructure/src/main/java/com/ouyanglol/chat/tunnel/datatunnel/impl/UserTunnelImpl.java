package com.ouyanglol.chat.tunnel.datatunnel.impl;

import com.ouyanglol.chat.dao.mongo.UserMongoDao;
import com.ouyanglol.chat.tunnel.dataobject.UserDO;
import com.ouyanglol.chat.tunnel.datatunnel.UserTunnelI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/12/15 21:53
 */
@Component
public class UserTunnelImpl implements UserTunnelI {

    @Autowired
    private UserMongoDao userMongoDao;

    @Override
    public Mono<UserDO> get(String id) {
        return userMongoDao.findById(id);
    }

    @Override
    public Mono<UserDO> save(UserDO userDO) {
        return userMongoDao.save(userDO);
    }

    @Override
    public Mono<UserDO> update(UserDO userDO) {
        return userMongoDao.save(userDO);
    }
}
