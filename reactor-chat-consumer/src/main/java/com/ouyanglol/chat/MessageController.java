package com.ouyanglol.chat;

import com.ouyanglol.chat.api.UserServiceI;
import com.ouyanglol.chat.dto.MessageCO;
import com.ouyanglol.chat.request.MessageSaveCmd;
import com.ouyanglol.chat.request.UserChangeStatusCmd;
import com.ouyanglol.chat.util.WebFluxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * @author ouyangduning
 * @date 2020/12/24 09:37
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private WebFluxUtil<MessageCO> webFluxUtil;
    @Autowired
    private UserServiceI userService;

    @PostMapping("send")
    Mono<MessageCO> send(@RequestBody MessageCO message) {
        return webFluxUtil.mono(POST, "/message/save", MessageCO.class, MessageSaveCmd.builder().message(message).build());
//        return messageService.save(MessageSaveCmd.builder().message(message).build());
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    Flux<MessageCO> queryUnreadMessage(String userId) {
        //TODO userId 从 ThreadLocal 获取

        //模拟历史消息
        Flux<MessageCO> history = Flux.just(MessageCO.builder().content("历史消息").build());

        return webFluxUtil
                .flux(GET, "/message/queryUnreadMessage?userId=" + userId, MessageCO.class, null)
                //历史消息
                .mergeWith(history)
                //用户状态为在线
                .doFirst(() -> {
                    try {
                        userService.updateStatus(UserChangeStatusCmd.builder().userId(userId).status(1).build());
                    } catch (Exception ignore) {
                    }
                })
                //用户状态为离线
                .doFinally(o -> {
                    try {
                        userService.updateStatus(UserChangeStatusCmd.builder().userId(userId).status(2).build());
                    } catch (Exception ignore) {
                    }
                });

    }
}
