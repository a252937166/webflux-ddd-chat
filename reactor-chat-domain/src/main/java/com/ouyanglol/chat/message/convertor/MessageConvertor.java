package com.ouyanglol.chat.message.convertor;

import com.alibaba.fastjson.JSON;
import com.ouyanglol.chat.common.ConvertorI;
import com.ouyanglol.chat.dto.ImgContent;
import com.ouyanglol.chat.dto.MessageCO;
import com.ouyanglol.chat.dto.TextContent;
import com.ouyanglol.chat.message.entity.MessageE;
import com.ouyanglol.chat.message.factory.MessageDomainFactory;
import com.ouyanglol.chat.message.valueobject.MessageStatusType;
import com.ouyanglol.chat.message.valueobject.MessageType;
import com.ouyanglol.chat.message.valueobject.UserV;
import com.ouyanglol.chat.tunnel.dataobject.MessageDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:43
 */
@Component
public class MessageConvertor implements ConvertorI {

    @Autowired
    private MessageDomainFactory factory;

    public MessageE dataToEntity(MessageDO dataObject){
        MessageE messageE = factory.create();
        BeanUtils.copyProperties(dataObject,messageE);
        messageE.setFormUser(UserV.builder()
                .id(dataObject.getFromId())
                .name(dataObject.getFromUserName())
                .build());
        messageE.setToUser(UserV.builder()
                .id(dataObject.getToId())
                .name(dataObject.getToUserName())
                .build());
        messageE.setType(MessageType.getByCode(dataObject.getType()));
        messageE.setStatus(MessageStatusType.getByCode(dataObject.getStatus()));
        return messageE;
    }

    public MessageDO entityToData(MessageE messageE) {
        return MessageDO.builder()
                .id(messageE.getId())
                .ackTime(messageE.getAckTime())
                .content(messageE.getContent())
                .status(messageE.getStatus() == null ? null : messageE.getStatus().getCode())
                .fromId(messageE.getFormUser().getId())
                .fromUserName(messageE.getFormUser().getName())
                .toId(messageE.getToUser().getId())
                .toUserName(messageE.getToUser().getName())
                .sendTime(messageE.getSendTime())
                .build();
    }

    public MessageCO entityToClient(MessageE messageE) {
        String content = messageE.getContent();
        MessageCO co = MessageCO.builder()
                .id(messageE.getId())
                .ackTime(messageE.getAckTime())
                .status(messageE.getStatus() == null ? null : messageE.getStatus().getCode())
                .fromId(messageE.getFormUser().getId())
                .fromUserName(messageE.getFormUser().getName())
                .toId(messageE.getToUser().getId())
                .toUserName(messageE.getToUser().getName())
                .sendTime(messageE.getSendTime())
                .build();
        MessageType type = messageE.getType();
        if (type == null) {
            co.setContent(new TextContent(content).get());
        }else if (type.equals(MessageType.IMG)) {
            co.setContent(JSON.parseObject(content, ImgContent.class).get());
        } else {
            co.setContent(new TextContent(content).get());
        }
        return co;
    }

    public MessageE clientToEntity(MessageCO co) {
        return MessageE.builder()
                .id(co.getId())
                .ackTime(co.getAckTime())
                .content(co.getContent())
                .sendTime(co.getSendTime())
                .formUser(UserV.builder()
                        .name(co.getFromUserName())
                        .id(co.getFromId())
                        .build())
                .toUser(UserV.builder()
                        .id(co.getToId())
                        .name(co.getToUserName())
                        .build())
                .status(MessageStatusType.getByCode(co.getStatus()))
                .type(MessageType.getByCode(co.getType().getType()))
                .build();
    }

}
