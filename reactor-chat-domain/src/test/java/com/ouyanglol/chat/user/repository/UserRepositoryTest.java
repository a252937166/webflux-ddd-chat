package com.ouyanglol.chat.user.repository;

import com.ouyanglol.chat.ReactorChatDomainApplicationTests;
import com.ouyanglol.chat.user.entity.UserE;
import com.ouyanglol.chat.user.valueobject.UserStatusType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ouyangduning
 * @date 2020/12/16 14:31
 */
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest extends ReactorChatDomainApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    void save() {
        userRepository.save(UserE.builder()
                .id("t2")
                .status(UserStatusType.OFFLINE)
                .name("测试2")
                .build()).subscribe();
    }

    @Test
    @Order(2)
    void get() {
        Mono<UserE> t1 = userRepository.get("t2");
        log.info("{}", t1.block());
    }

    @Test
    @Order(3)
    void update() {
        userRepository.update(UserE.builder()
                .id("t2")
                .name("测试2改")
                .build()).subscribe();
        get();
    }
}