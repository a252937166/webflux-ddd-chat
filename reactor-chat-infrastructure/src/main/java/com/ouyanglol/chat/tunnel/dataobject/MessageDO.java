package com.ouyanglol.chat.tunnel.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author ouyangduning
 * @date 2020/10/31 16:55
 */
@Data
@Document(collection = "message", collation = "zh")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDO {
    @Id
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
    private Integer type;
}
