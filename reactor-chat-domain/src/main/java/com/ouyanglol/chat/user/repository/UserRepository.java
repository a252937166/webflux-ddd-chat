package com.ouyanglol.chat.user.repository;

import com.ouyanglol.chat.common.RepositoryI;
import com.ouyanglol.chat.tunnel.dataobject.UserDO;
import com.ouyanglol.chat.tunnel.datatunnel.UserTunnelI;
import com.ouyanglol.chat.user.convertor.UserConvertor;
import com.ouyanglol.chat.user.entity.UserE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ouyangduning
 * @date 2020/12/15 21:09
 */
@Repository
public class UserRepository implements RepositoryI {
    @Autowired
    private UserTunnelI userTunnel;
    @Autowired
    private UserConvertor userConvertor;

    public Mono<UserE> save(UserE user) {
        return userTunnel.save(userConvertor.entityToData(user)).map(userDO -> userConvertor.dataToEntity(userDO));
    }

    public Mono<UserE> get(String id) {
        return userTunnel.get(id).map(userDO -> userConvertor.dataToEntity(userDO));
    }

    public Mono<UserDO> update(UserE user) {
        //FIXME 应该使用mongo语法进行update操作
//        Optional<UserE> userOptional = get(user.getId()).blockOptional(Duration.ofSeconds(5));
//        if (!userOptional.isPresent()) {
//            throw new RuntimeException("user不存在");
//        }
//        UserE userE = userOptional.get();
//        BeanUtils.copyProperties(user, userE, getNullPropertyNames(user));
//        return userTunnel.save(userConvertor.entityToData(userE));
        return get(user.getId()).flatMap(userE -> {
            BeanUtils.copyProperties(user, userE, getNullPropertyNames(user));
            return userTunnel.save(userConvertor.entityToData(userE));
        });
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
