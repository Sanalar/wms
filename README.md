# wms

软件工程课程设计，仓库管理系统

## 项目部署方法

创建一个 `MySQL` 数据库，名为 `wms`，并创建一个数据库用户名为 `wms`，密码为
`liugehetao`。导入 SQL 文件即可。

## 更新日志

1. 2017-06-12 完成第一部分的界面设计初稿。
2. 2017-06-16 完成项目的 SSH 构架搭建，并成功实现登录操作。
3. 2017-06-21 完成了产品列表页面的显示，分页，按类别筛选和按名称查询。
4. 2017-06-25 完成产品详情中的显示和图片修改功能。

## 遇到的问题

### URL 提交中文乱码的问题

解决方法：

1. `js` 中使用 `encodeURI` 方法，必须嵌套两层：

		str = encodeURI(encodeURI(str)); 
		
2. `action` 中使用 `URLDecoder` 解码：

		str = java.net.URLDecoder.decode(str, "UTF-8");

### `struts` 中怎样直接指定返回状态码 `404` 或者 `403` ？

在 `struts.xml` 文件中指定 `<result>` 标签对如下：

```xml
<result type="httpheader">
   <param name="status">403</param>
</result>
```
   
### 怎样实现小图片上传？

不通过文件上传的形式，可以先把要上传的图片转码成 `base64` 编码，然后再在
`action` 中使用 `BASE64Decoder` 进行解码保存在本地文件就可以了。
   
### `Hibernate` 执行 `update()` 或者 `save()` 操作没有写回数据库怎么解决？

配置 `hibernate.hbm.xml` 中，添加 `Connection.autocommit` 为 `true`，
然后在执行 `update()` 或者 `save()` 的地方后面加一句 `session.flush()`。
   
### `action` 怎样返回 `json` 格式数据？

在 `struts.xml` 文件中添加如下配置：

```xml
<result-types>
   <result-type name="json" class="org.apache.struts2.json.JSONResult"/>
</result-types>
...
   <interceptor name="json" class="org.apache.struts2.json.JSONInterceptor"/>
...
<result name="success" type="json">
   <param name="root">success</param>
</result>
```