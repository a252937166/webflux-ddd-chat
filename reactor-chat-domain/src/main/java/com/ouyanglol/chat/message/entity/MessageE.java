package com.ouyanglol.chat.message.entity;

import com.ouyanglol.chat.message.valueobject.MessageType;
import com.ouyanglol.chat.message.valueobject.MessageStatusType;
import com.ouyanglol.chat.message.valueobject.UserV;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:40
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageE {
    /**
     * id
     */
    private String id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发送者
     */
    private UserV formUser;
    /**
     * 接收者id
     */
    private UserV toUser;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 回执时间
     */
    private Date ackTime;
    /**
     * 状态
     */
    private MessageStatusType status;
    /**
     * 消息类型
     */
    private MessageType type;
}
