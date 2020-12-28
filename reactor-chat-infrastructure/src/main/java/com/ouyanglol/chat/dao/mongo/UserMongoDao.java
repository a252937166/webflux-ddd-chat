package com.ouyanglol.chat.dao.mongo;

import com.ouyanglol.chat.tunnel.dataobject.UserDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author ouyangduning
 * @date 2020/12/15 21:43
 */
public interface UserMongoDao extends ReactiveCrudRepository<UserDO, String> {
}
