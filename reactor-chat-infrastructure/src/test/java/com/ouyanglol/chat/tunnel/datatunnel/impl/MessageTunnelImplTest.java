package com.ouyanglol.chat.tunnel.datatunnel.impl;

import com.ouyanglol.chat.ReactorChatInfrastructureApplicationTests;
import com.ouyanglol.chat.tunnel.datatunnel.MessageTunnelI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ouyangduning
 * @date 2020/10/31 17:34
 */
class MessageTunnelImplTest extends ReactorChatInfrastructureApplicationTests {

    @Autowired
    private MessageTunnelI messageTunnel;

    @Test
    void getByToIdAndStatus() {
        messageTunnel.getByToIdAndStatus("1",1).log().subscribe();
        while (true){

        }
    }
}