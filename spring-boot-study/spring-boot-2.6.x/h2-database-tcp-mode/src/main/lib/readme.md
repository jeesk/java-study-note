

启动h2 数据库
```commandline
java -cp h2-1.4.200.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpPort 19200 -tcpPassword tcpPassword -tcpAllowOthers -ifNotExists  -webAdminPassword h21995   &
```
浏览器打开
``localhost:19200`

Saved Settings: 选择Generic H2 (Server)

JDBC URL:  输入``jdbc:h2:tcp://127.0.0.1:19200/~/test;DB_CLOSE_DELAY=-1;`


运行sql, 创建用户
```sql
create user sa password 'sa' admin;
```