package com.ouyanglol.chat.message.factory;

import com.ouyanglol.chat.message.entity.MessageE;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:39
 */
@Component
public class MessageDomainFactory {

    public MessageE create() {
        return new MessageE();
    }


}
