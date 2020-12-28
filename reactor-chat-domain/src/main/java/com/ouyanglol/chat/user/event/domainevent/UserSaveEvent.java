package com.ouyanglol.chat.user.event.domainevent;

import com.ouyanglol.chat.dto.UserCO;
import org.springframework.context.ApplicationEvent;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:07
 */
public class UserSaveEvent extends ApplicationEvent {

    public UserSaveEvent(UserCO co) {
        super(co);
    }

    @Override
    public UserCO getSource() {
        return (UserCO) super.getSource();
    }
}
