package com.ouyanglol.chat.service;

import com.ouyanglol.chat.api.UserServiceI;
import com.ouyanglol.chat.dto.UserCO;
import com.ouyanglol.chat.request.UserChangeStatusCmd;
import com.ouyanglol.chat.request.UserQuery;
import com.ouyanglol.chat.request.UserSaveCmd;
import com.ouyanglol.chat.user.convertor.UserConvertor;
import com.ouyanglol.chat.user.event.domainevent.UserSaveEvent;
import com.ouyanglol.chat.user.event.domainevent.UserStatusChangeEvent;
import com.ouyanglol.chat.user.event.publisher.UserEventPublisher;
import com.ouyanglol.chat.user.repository.UserRepository;
import com.ouyanglol.chat.user.valueobject.UserStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:30
 */
@RestController
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserConvertor convertor;
    @Autowired
    private UserEventPublisher publisher;
    @Autowired
    private UserRepository repository;

    @Override
    public Mono<UserCO> updateStatus(UserChangeStatusCmd cmd) {
        return Mono.just(UserCO.builder().build()).map(co -> {
            co.setStatus(cmd.getStatus());
            co.setId(cmd.getUserId());
            publisher.publishStatusChange(new UserStatusChangeEvent(co.getId(), UserStatusType.getByCode(co.getStatus())));
            return co;
        });
    }

    @Override
    public Mono<UserCO> save(UserSaveCmd cmd) {
        return Mono.just(cmd.getUser()).map(co -> {
            publisher.publishSave(new UserSaveEvent(co));
            return co;
        });
    }

    @Override
    public Mono<UserCO> get(UserQuery query) {
        return repository.get(query.getUserId()).map(e -> convertor.entityToClient(e));
    }
}
