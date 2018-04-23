这个项目是做给卢伟明管理园林工程公司材料采购。算是一个物料和供应商管理系统。web app是不言自明的，还要支持手机浏览器。选择java是因为平时工作用得多，计划用最简单的架构实现原型，以便以后增加新架构。
	
# 里程碑1

列表页面，打开表单浏览和编辑。支持手机屏幕自适应。

用angular做前端，后台用最基本的Servlet架构，以便增加新架构。jdk用1.8。eclipse做ide。jee容器用eclipse自带的jetty，使用junit做单元测试。用maven工程，便于管理依赖包。因为从无到有，数据层用hibernate，而不是mybatis。可适当使用spring context。

# 里程碑2

支持查询、登录。

# 里程碑3

权限机制。

# 里程碑4

移动app

# 2018-3-10

嗯，发现eclipse支持markdown。也不奇怪，markdown已经很流行，最新版的eclipse自然会支持它。
	
# 2018-3-11

学习angularJS，感觉语法很漂亮。

# 2018-3-13

对angularJS中ajax这一块的例子看得很晕。另外发现angular和angularJS是两个项目。前端这块先放一放，动手实现后台。只用angularJS做前端交互也可以，实现ajax有很多方式。后台先把Servlet的测试用例做起来。

导入logback试用了一下，感觉还是太复杂。还是先直接System.out吧。抽象出一个自己的logger工具类。

eclipse的workspace突然傻了，pom提示找不到依赖包错误，junit无法运行。新建一个workspace后，至少junit恢复正常了。第一个servlet类也成功运行单元测试。时间已过去将近2个半小时。

将车停在花都广场，继续开工。

配置RESTful服务或者jsf都挺麻烦的，我还是老老实实先写最基本的servlet吧。

servlet很快就写完了。发现angularJS的tutorial很有用，基本上可以改一下就适应里程碑1的需求。开始动手下载安装。

# 2018-3-15

现在实际上已经是16日零点半了。用git安装了angluarJS的教程。运行起了npm。又开始接触node和npm了。现在玩javascript绝对是离不开他们，就像java离不开maven，Linux离不开apt、yum……

brew把Mac系统玩坏了。还是应该用Linux虚拟机做开发。或者用docker。

# 2018-3-24

一晃9天过去了。只把angularJS的教程过了一遍。不过要做起来也快了。直接把这边的Servlet做成RESTful。

# 2018-3-25

把Google phone gallery导入工程直接文字替换成plant gallery，结构一大堆报错。