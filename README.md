这个项目是做给卢伟明管理园林工程公司材料采购。算是一个物料和供应商管理
系统。web app是不言自明的，还要支持手机浏览器。选择java是因为平时工作
用得多，计划用最简单的架构实现原型，以便以后增加新架构。
	
# 里程碑1

	列表页面。支持查询，排序。

	用angularjs做前端，后台用最基本的Servlet架构，以便增加新架构。jdk
    用1.8。eclipse做ide。jee容器，开发用eclipse自带的jetty，生产环境用
    centos yum安装tomcat，使用junit做单元测试。用maven工程，便于管理依
    赖包。因为从无到有，数据层用mybatis。开发环境数据库用h2，生产环境
    用yum安装mariadb。

	生产环境IP：103.210.238.169
	
# 里程碑2

	生产服务器内存升级到2G。支持登录，打开表单浏览和编辑。支持手机屏幕自适应。

# 里程碑3

	权限机制。

# 里程碑4

	移动app

# 2018-3-10

	嗯，发现eclipse支持markdown。也不奇怪，markdown已经很流行，最新版
    的eclipse自然会支持它。
	
# 2018-3-11

	学习angularJS，感觉语法很漂亮。

# 2018-3-13

	对angularJS中ajax这一块的例子看得很晕。另外发现angular和angularJS
    是两个项目。前端这块先放一放，动手实现后台。只用angularJS做前端交
    互也可以，实现ajax有很多方式。后台先把Servlet的测试用例做起来。

	导入logback试用了一下，感觉还是太复杂。还是先直接System.out吧。抽
    象出一个自己的logger工具类。

	eclipse的workspace突然傻了，pom提示找不到依赖包错误，junit无法运行。
    新建一个workspace后，至少junit恢复正常了。第一个servlet类也成功运
    行单元测试。时间已过去将近2个半小时。

	将车停在花都广场，继续开工。

	配置RESTful服务或者jsf都挺麻烦的，我还是老老实实先写最基本的servlet吧。

	servlet很快就写完了。发现angularJS的tutorial很有用，基本上可以改一
    下就适应里程碑1的需求。开始动手下载安装。

# 2018-3-15

	现在实际上已经是16日零点半了。用git安装了angluarJS的教程。运行起了
    npm。又开始接触node和npm了。现在玩javascript绝对是离不开他们，就像
    java离不开maven，Linux离不开apt、yum……

	brew把Mac系统玩坏了。还是应该用Linux虚拟机做开发。或者用docker。

# 2018-3-24

	一晃9天过去了。只把angularJS的教程过了一遍。不过要做起来也快了。直
    接把这边的Servlet做成RESTful。

# 2018-3-25

	把Google phone gallery导入工程直接文字替换成plant gallery，结构一
    大堆报错。
	
# 2018-4-24

	大概是20号左右把guncannon工程发布到生产环境。打开列表页面要10几秒，
    看看内存只剩下80M不到，估计是因为内存太少了。这个问题交给卢伟明去
    增加内存。
	
	昨晚按卢伟明的试用要求，增加了做列表页面增加供应商信息。并建立了
    git库。做考虑是否把工程放上github。代码没问题，关键是生产数据，不
    放在git管理似乎不好。也许应该独立于代码另外管理。
	
	今天根据实际情况修改了里程碑内容。待假期将上述改进完成测试并发布到
    生产环境。这个项目就暂时放一下。待人面识别和藏经校勘两个项目阶段性
    完成再继续完成里程碑2的功能。
