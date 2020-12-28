package com.ouyanglol.chat.api;

import com.ouyanglol.chat.dto.UserCO;
import com.ouyanglol.chat.request.UserChangeStatusCmd;
import com.ouyanglol.chat.request.UserQuery;
import com.ouyanglol.chat.request.UserSaveCmd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:02
 */
@FeignClient("CHAT-START")
@RequestMapping("/user")
public interface UserServiceI {

    /**
     * 改变用户状态
     *
     * @param cmd
     * @return
     */
    @PostMapping(value = "/updateStatus")
    Mono<UserCO> updateStatus(@RequestBody UserChangeStatusCmd cmd);

    /**
     * 保存用户
     *
     * @param cmd
     * @return
     */
    @PostMapping(value = "/save")
    Mono<UserCO> save(@RequestBody UserSaveCmd cmd);

    /**
     * 获取用户信息
     * @param query q
     * @return
     */
    @GetMapping(value = "/get")
    Mono<UserCO> get(UserQuery query);
}
