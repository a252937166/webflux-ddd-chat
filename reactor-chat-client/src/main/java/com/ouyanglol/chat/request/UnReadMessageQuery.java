package com.ouyanglol.chat.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 未读消息查询
 * @author ouyangduning
 * @date 2020/11/1 01:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnReadMessageQuery {
    /**
     * 用户id
     */
    private String userId;
}
