package com.ouyanglol.chat;

import com.ouyanglol.chat.dto.UserCO;
import com.ouyanglol.chat.request.UserSaveCmd;
import com.ouyanglol.chat.util.WebFluxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * @author ouyangduning
 * @date 2020/12/24 09:37
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private WebFluxUtil<UserCO> webFluxUtil;

    @PostMapping("online")
    Mono<UserCO> online(@RequestBody UserCO user) {
        return webFluxUtil
                .mono(POST, "/user/save", UserCO.class, UserSaveCmd.builder().user(user).build());
        //todo 状态变更
//        return messageService.save(MessageSaveCmd.builder().message(message).build());
    }

    @GetMapping("")
    Mono<UserCO> queryStatus(String userId) {
        return webFluxUtil
                .mono(GET, "/user/get?userId="+userId, UserCO.class, null);
        //todo 状态变更
//        return messageService.save(MessageSaveCmd.builder().message(message).build());
    }

}
