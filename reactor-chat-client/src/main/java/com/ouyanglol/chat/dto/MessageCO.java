package com.ouyanglol.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ouyangduning
 * @date 2020/11/1 01:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageCO {
    private String id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发送者id
     */
    private String fromId;
    /**
     * 发送者名称
     */
    private String fromUserName;
    /**
     * 接收者id
     */
    private String toId;
    /**
     * 接收者名称
     */
    private String toUserName;
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
    private Integer status;
    /**
     * 消息类型
     */
    private ContentType type;
}
