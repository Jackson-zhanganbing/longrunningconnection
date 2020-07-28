# 项目是什么？
> 平时只是前端调后台接口获取数据，那么后台有没有什么方式可以主动给前端发数据呢？
# 1 websocket

- 配置MyJob类中的cron表达式，现在是每5秒跑一个消息给前端 

- 启动项目

- 浏览器访问localhost:8080，可以看到每秒都有刷时间戳

- 如果想要单独给某id的页面发数据，可以参考websocket/MyJob类，sendMessageToUser 方法以及配合页面user.html