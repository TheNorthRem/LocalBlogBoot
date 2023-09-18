项目必须配置

main/resources/application.yml

```yaml
spring:
    datasource: #mysql ??
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/blog?useSSL=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
        username: root
        password: 137100
    servlet:
        multipart:
            max-file-size: 100MB
            max-request-size: 100MB
server: # ????
    port: 8081
imagePath: "/home/liyehui/Public/MyBlogImages/" # 上传图片保存路径 
BaseUrl: http://localhost:8081 # 后端Url
```



