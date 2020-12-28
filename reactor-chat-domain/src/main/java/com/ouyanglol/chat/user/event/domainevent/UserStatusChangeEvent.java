package com.ouyanglol.chat.user.event.domainevent;

import com.ouyanglol.chat.user.entity.UserE;
import com.ouyanglol.chat.user.valueobject.UserStatusType;
import org.springframework.context.ApplicationEvent;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:07
 */
public class UserStatusChangeEvent extends ApplicationEvent {

    public UserStatusChangeEvent(String userId, UserStatusType type) {
        super(UserE.builder().id(userId).status(type).build());
    }

    @Override
    public UserE getSource() {
        return (UserE) super.getSource();
    }
}
