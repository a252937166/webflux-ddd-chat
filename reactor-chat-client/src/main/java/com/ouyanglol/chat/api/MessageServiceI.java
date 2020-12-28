package com.ouyanglol.chat.api;

import com.ouyanglol.chat.dto.MessageCO;
import com.ouyanglol.chat.request.MessageSaveCmd;
import com.ouyanglol.chat.request.UnReadMessageQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/10/31 22:36
 */
@FeignClient("CHAT-START")
@RequestMapping("/message")
public interface MessageServiceI {
    /**
     * 保存消息
     *
     * @param cmd req
     * @return
     */
    @PostMapping(value = "/save")
    Mono<MessageCO> save(@RequestBody MessageSaveCmd cmd);

    /**
     * 查询未读消息
     *
     * @param userId userId
     * @return
     */
    @GetMapping(value = "/queryUnreadMessage", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    Flux<MessageCO> queryUnreadMessage(UnReadMessageQuery query);
}
