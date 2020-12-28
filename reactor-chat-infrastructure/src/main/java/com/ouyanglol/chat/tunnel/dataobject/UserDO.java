package com.ouyanglol.chat.tunnel.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ouyangduning
 * @date 2020/12/15 21:41
 */
@Data
@Document(collection = "user", collation = "zh")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDO {
    /**
     * id
     */
    @Id
    private String id;
    private String name;
    private Integer status;
}
