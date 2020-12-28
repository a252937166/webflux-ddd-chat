package com.ouyanglol.chat.user.entity;

import com.ouyanglol.chat.user.valueobject.UserStatusType;
import lombok.Builder;
import lombok.Data;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:32
 */
@Data
@Builder
public class UserE {
    private String id;
    private String name;
    private UserStatusType status;
}
