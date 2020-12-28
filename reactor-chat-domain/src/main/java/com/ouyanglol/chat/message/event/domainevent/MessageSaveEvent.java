package com.ouyanglol.chat.message.event.domainevent;

import com.ouyanglol.chat.dto.MessageCO;
import org.springframework.context.ApplicationEvent;

/**
 * @author ouyangduning
 * @date 2020/12/27 01:37
 */
public class MessageSaveEvent extends ApplicationEvent {
    public MessageSaveEvent(MessageCO source) {
        super(source);
    }

    @Override
    public MessageCO getSource() {
        return (MessageCO) super.getSource();
    }
}
