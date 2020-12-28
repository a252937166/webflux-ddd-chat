package com.ouyanglol.chat.user.convertor;

import com.ouyanglol.chat.common.ConvertorI;
import com.ouyanglol.chat.dto.UserCO;
import com.ouyanglol.chat.tunnel.dataobject.UserDO;
import com.ouyanglol.chat.user.entity.UserE;
import com.ouyanglol.chat.user.valueobject.UserStatusType;
import org.springframework.stereotype.Component;

/**
 * @author ouyangduning
 * @date 2020/12/15 22:00
 */
@Component
public class UserConvertor implements ConvertorI {

    public UserE clientToEntity(UserCO co) {
        return UserE.builder()
                .id(co.getId())
                .name(co.getName())
                .status(UserStatusType.getByCode(co.getStatus()))
                .build();
    }

    public UserDO entityToData(UserE userE) {
        return UserDO.builder()
                .status(userE.getStatus() == null ? null : userE.getStatus().getCode())
                .id(userE.getId())
                .name(userE.getName())
                .build();
    }

    public UserE dataToEntity(UserDO userDO) {
        return UserE.builder()
                .id(userDO.getId())
                .name(userDO.getName())
                .status(UserStatusType.getByCode(userDO.getStatus()))
                .build();
    }

    public UserCO entityToClient(UserE userE) {
        return UserCO.builder()
                .status(userE.getStatus() == null ? null : userE.getStatus().getCode())
                .id(userE.getId())
                .name(userE.getName())
                .build();
    }
}
