[![Build Status](https://travis-ci.org/a252937166/webflux-ddd-chat.svg?branch=main)](https://travis-ci.org/a252937166/webflux-ddd-chat)
[![codecov](https://codecov.io/gh/a252937166/webflux-ddd-chat/branch/main/graph/badge.svg?token=RWNX3MEII9)](https://codecov.io/gh/a252937166/webflux-ddd-chat)
[![GitHub license](https://img.shields.io/github/license/a252937166/webflux-ddd-chat)](https://github.com/a252937166/webflux-ddd-chat/blob/main/LICENSE)
# webflux-ddd-chat
基于webflux和领域模型的聊天项目

# 目录结构

```
.
├── HELP.md
├── LICENSE
├── README.md
├── chat.html 前端发送消息页面
├── mvnw
├── mvnw.cmd
├── pom.xml
├── reactor-chat-app 应用层
├── reactor-chat-client 二方包
├── reactor-chat-consumer 服务消费者
├── reactor-chat-domain 领域层
├── reactor-chat-eureka spring-cloud注册中心
├── reactor-chat-infrastructure 基础实施层
└── reactor-chat-start 用户
```

# 自测使用

## 接收消息

打开页面：http://${HOST}:8010/message/get?userId=${user}
可以看到user接收的消息列表，页面打开过程中代表user在线

# 发送消息

打开chat.html，填入userId和消息内容，点击发送按钮即可向user发送消息，对方页面打开和关闭时，可以看到对方用户状态切换。

