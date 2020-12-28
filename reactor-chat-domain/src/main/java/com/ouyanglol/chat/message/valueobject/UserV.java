package com.ouyanglol.chat.message.valueobject;

import lombok.Builder;
import lombok.Data;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:56
 */
@Data
@Builder
public class UserV {
    private String name;
    private String id;
}
