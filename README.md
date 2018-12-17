# MyBlogSite
:book:自己搭建的[博客网站](http://www.lipan.xyz)，细节功能待完善
## 开发工具
1. IDE：IDEA
2. java -version：1.8
2. 项目管理：Maven
3. 技术点：SpringBoot 2.1.1 + JPA + MySQL + Thymeleaf
## 前台展示
![image](https://fantasticpan.oss-cn-beijing.aliyuncs.com/TIM%E6%88%AA%E5%9B%BE20181214133829.png)
## 写博客
![image](https://fantasticpan.oss-cn-beijing.aliyuncs.com/TIM%E6%88%AA%E5%9B%BE20181214133751.png)
## 文章阅读
![image](http://fantasticpan.oss-cn-beijing.aliyuncs.com/readArticle.png)
## 后台管理
![image](https://fantasticpan.oss-cn-beijing.aliyuncs.com/TIM%E6%88%AA%E5%9B%BE20181214132021.png)
![image](https://fantasticpan.oss-cn-beijing.aliyuncs.com/TIM%E6%88%AA%E5%9B%BE20181214132036.png)
## 项目相关
### 1. 项目运行
使用Maven将项目打成jar包，上传至服务器<br/>
运行命令：`nohup java -jar blog.jar &`
### 2. 服务器代理
1. 使用nginx反向代理服务器，禁用ip访问（重定向），同时关闭服务器外网访问端口，实现网站只能域名访问
2. 通过配置nginx缓存静态资源文件，从而加快网站访问速度
## 待完善
- [ ] redis 缓存
- [x] druid 连接池
- [ ] 后台功能完善
- [ ] 前台界面美化
- [ ] 多用户
- [ ] 移除冗杂的前端文件<br/>
...
## 说明
1. 本博客后台Java代码为自主开发完成，前台博客页面参考[yadong.zhang](https://gitee.com/yadong.zhang)的源博客项目[OneBlog](https://gitee.com/yadong.zhang/DBlog)，管理页面使用[Colorlib](https://colorlib.com/)提供的[管理模板](https://colorlib.com/wp/free-admin-templates/)[gentelella](https://colorlib.com/polygon/gentelella/index.html)
2. 感谢[翼灵物联工作室](www.swpuiot.com)成员的帮助
