# wms

软件工程课程设计，仓库管理系统

## 项目部署方法

创建一个 `MySQL` 数据库，名为 `wms`，并创建一个数据库用户名为 `wms`，密码为
`liugehetao`。导入 SQL 文件即可。

## 更新日志

1. 2017-06-12 完成第一部分的界面设计初稿。
2. 2017-06-16 完成项目的 SSH 构架搭建，并成功实现登录操作。
3. 2017-06-21 完成了产品列表页面的显示，分页，按类别筛选和按名称查询。

## 遇到的问题

### URL 提交中文乱码的问题

解决方法：

1. js 中使用 encodeURI 方法，必须嵌套两层：

		str = encodeURI(encodeURI(str)); 
		
2. action 中使用 URLDecoder 解码：

		str = java.net.URLDecoder.decode(str, "UTF-8");