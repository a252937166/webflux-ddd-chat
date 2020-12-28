package com.ouyanglol.chat.request;

import com.ouyanglol.chat.dto.MessageCO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 保存消息
 * @author ouyangduning
 * @date 2020/11/1 01:29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageSaveCmd {
    private MessageCO message;
}
