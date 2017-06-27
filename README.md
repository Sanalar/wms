# wms

软件工程课程设计，仓库管理系统

## 项目部署方法

创建一个 `MySQL` 数据库，名为 `wms`，并创建一个数据库用户名为 `wms`，密码为
`liugehetao`。导入 SQL 文件即可。

## 数据库设计

### 数据库的表结构

| 表名            | 说明                                         |
|----------------|----------------------------------------------|
| wms_application_state | 表示出入库申请的所有可能的状态           |
| wms_category  | 原料或产品的分类，一共有两级分类              |
| wms_check | 仓库盘存表，保存仓库盘存的申请表  |
| wms_check_product_shelf | 某张仓库盘存表中的盘存产品以及存储位置数量信息 |
| wms_check_state | 表示盘存表的所有可能的状态 | 
| wms_condition | 列举所有可能的存储要求条件，比如干燥，遮光等 | 
| wms_dispatch | 仓库调度表，保存仓库调度申请表 |
| wms_dispatch_product_shelf | 表示某个仓库调度申请表中的所有调度产品和所处位置 |
| wms_dispatch_state | 表示所有调度表可能的状态 |
| wms_in_application | 存储所有的入库申请表 |
| wms_in_application_product | 表示某一个入库申请表中的所有入库产品信息 |
| wms_order | 存储所有的采购表 |
| wms_order_line | 表示某一个采购表的所有需要采购的产品信息 |
| wms_order_state | 表示所有的采购表可能所处的状态 |
| wms_out_application | 存储所有的出库申请表 |
| wms_out_applicaiton_product | 表示某一个出库申请表中的所有出库产品信息 |
| wms_product | 所有的产品信息 |
| wms_product_condition | 每个产品所要求的存储条件信息 |
| wms_product_shelf | 每个产品所存放在哪些个货架的信息 |
| wms_product_supplier | 每个产品可以由哪些供应商提供货源 |
| wms_shelf | 所有的货架信息 |
| wms_storage | 所有的库位信息 |
| wms_storage_condition | 某个库位拥有哪些存储条件信息 |
| wms_supplier | 所有的供应商信息 |
| wms_user | 所有的用户信息 |
| wms_user_type | 用户类型信息 |
| wms_warehouse | 所有的仓库信息 |

这个数据库的实体有以下几个：

1. 仓库（wms_warehouse）
2. 库位（wms_storage），和仓库是多对一的关系
3. 货架（wms_shelf），和库位是多对一的关系
4. 用户（wms_user），这个系统不过多地考虑用户的逻辑结构
5. 存储条件（wms_condition），和库位是多对多的关系（wms_storage_condition），和产品是多对多的关系（wms_product_condition）
6. 分类（wms_category），和产品是多对一的关系
7. 供应商（wms_supplier），和产品是多对多的关系（wms_product_supplier）
8. 产品（wms_product），和货架是多对多的关系（wms_product_shelf）
9. 采购表（wms_order），和采购详情（wms_orderline）是一对多的关系
10. 调度表（wms_dispatch），和调度详情（wms_dispatch_product_shelf）是一对多的关系
11. 盘存表（wms_check），和盘存详情（wms_check_product_shelf）是一对多的关系
12. 入库表（wms_in_application），和入库详情（wms_in_applicaiton_product）是一对多的关系
13. 出库表（wms_out_applicaiton），和出库详情（wms_out_application_product）是一对多的关系
14. 剩下的状态表（wms_**_state），表示的表单的处理状态

各个表的详细结构如下：

#### wms_application_state

| 列名 | 说明 |
|-----|------|
| state_id | 主键 |
| state_name | 入库或者出库的状态名称，比如等待审核 |

#### wms_category

| 列名 | 说明 |
|-----|------|
| category_id | 主键 |
| category_name | 类别的名称 |
| category_parent | 类别的父类别，如果为 null 表示这是顶级类别 |

#### wms_check

| 列名 | 说明 |
|-----|------|
| check_id | 主键 |
| check_warehouse | 外键，表示当前正在盘存哪个仓库的信息 |
| check_creator | 外键，表示当前盘存是哪个用户创建的 |
| check_acceptor | 外键，表示当前盘存是被哪个用户接受的，为 null 表示还未被接受 |
| check_create_time | 表示盘存创建的时间 |
| check_accept_time | 表示盘存被审核通过的时间 |
| check_description | 表示盘存的描述信息 |
| check_state | 外键，表示当前盘存的状态 |

#### wms_check_product_shelf

| 列名 | 说明 |
|-----|------|
| cps_id | 主键 |
| product_id | 外键，表示这个盘存盘点了哪个货品 |
| shelf_id | 外键，表示这个盘存盘点的这个货品在哪个货架上 |
| check_id | 外键，表示这个盘存详情属于哪个盘存表 |
| cps_number | 表示盘存的这个货架的这个货品的实际数量是多少 |

#### wms_check_state

| 列名 | 说明 |
|-----|------|
| state_id | 主键 |
| state_name | 盘存的状态名称 |

#### wms_condition

| 列名 | 说明 |
|-----|------|
| condition_id | 主键 |
| condition_name | 这个存储条件的名称 |

#### wms_dispatch

| 列名 | 说明 |
|-----|------|
| dispatch_id | 主键 |
| dispatch_from | 外键，表示从哪个仓库开始调度 |
| dispatch_to | 外键，表示调度到哪个仓库去 |
| dispatch_create_time | 表示调度的创建日期 |
| dispatch_accept_time | 表示调度的审核通过的日期 |
| dispatch_finish_time | 表示调度的确认入库的日期 |
| dispatch_creator | 外键，表示调度的申请人 |
| dispatch_acceptor | 外键，表示外键的审核人|
| dispatch_finisher | 外键，表示调度的确认人 |
| dispatch_descriptor | 调度的描述 |
| dispatch_state | 外键，表示调度的状态 |

#### wms_dispatch_product_shelf

| 列名 | 说明 |
|-----|------|
| dps_id | 主键 |
| dispatch_id | 外键，表示这个条目属于哪个调度任务 |
| product_id | 外键，表示这一条记录了要调度哪个货品 |
| shelf_id | 外键，表示这一条记录要调度的货品在哪个货架上 |
| dps_number | 表示需要调度多少个这个货品 |
| dps_cost | 表示调度这么多个这类货品需要花费多少钱 |

#### wms_dispatch_state

| 列名 | 说明 |
|-----|------|
| state_id | 主键 |
| state_name | 调度状态的名称 |

#### wms_in_application

| 列名 | 说明 |
|-----|------|
| application_id | 主键 |
| application_warehouse | 外键，表示要入库到哪个仓库 |
| application_time | 入库单创建的时间 |
| application_creator | 外键，表示入库单是谁创建的 |
| applicaiton_accept_time | 入库单的确认时间 |
| applicaiton_acceptor | 外键，表示入库单是谁确认的 |
| application_descrition | 入库单的描述信息 |
| application_state | 外键，表示入库单的状态 |

#### wms_in_application_product

| 列名 | 说明 |
|-----|------|
| ap_id | 主键 |
| product_id | 外键，表示要入库的货品的名称 |
| shelf_id | 外键，表示货品要入库放到哪个货架上 |
| app_id | 外键，表示这个入库条目是属于哪个入库单的 |
| ap_number | 表示入库的数量 |

#### wms_order

| 列名 | 说明 |
|-----|------|
| order_id | 主键 |
| order_date | 采购单的创建日期 |
| order_dead_line | 采购单的预期交付日期 |
| order_warehouse | 外键，这个采购单是那个仓库的采购单 |
| order_charger | 外键，这个采购单是哪个用户负责的 |
| order_description | 采购单描述信息 |
| order_state | 采购单的状态信息 |

#### wms_order_line

| 列名 | 说明 |
|-----|------|
| line_id | 主键 |
| product_id | 这条采购详情记录的是要采购什么产品 |
| supplier_id | 要采购的产品是从谁那里采购的 |
| line_count | 需要采购多少数量的该类货品 |
| order_id | 这条采购记录是属于哪个采购单的 |

#### wms_order_state

| 列名 | 说明 |
|-----|------|
| state_id | 主键 |
| state_name | 采购单的状态 |

#### wms_out_application

| 列名 | 说明 |
|-----|------|
| application_id | 主键 |
| application_warehouse | 外键，表示要从哪个仓库出库 |
| application_time | 出库单创建的时间 |
| application_creator | 外键，表示出库单是谁创建的 |
| applicaiton_accept_time | 出库单的确认时间 |
| applicaiton_acceptor | 外键，表示出库单是谁确认的 |
| application_descrition | 出库单的描述信息 |
| application_state | 外键，表示出库单的状态 |

#### wms_out_application_product

| 列名 | 说明 |
|-----|------|
| ap_id | 主键 |
| product_id | 外键，表示要出库的货品的名称 |
| shelf_id | 外键，表示货品要从哪个货架上出库 |
| app_id | 外键，表示这个出库条目是属于哪个出库单的 |
| ap_number | 表示出库的数量 |

#### wms_product

| 列名 | 说明 |
|-----|------|
| product_id | 主键 |
| product_name | 货品的名称 |
| product_code | 货品的条形编码 |
| product_category | 外键，货品属于哪个分类 |
| product_description | 货品的描述 |
| product_image | 货品图片文件路径 |
| product_standard | 这个货品的供应规格 |
| product_unit | 这个货品的单位 |

#### wms_product_condition

| 列名 | 说明 |
|-----|------|
| pc_id | 主键 |
| product_id | 外键，货品的名称 |
| condition_id | 外键，这个货品需要什么样的存放条件 |

#### wms_product_shelf

| 列名 | 说明 |
|-----|------|
| ps_id | 主键 |
| product_id | 外键，货品的名称 |
| shelf_id | 外键，这个货品放在什么货架上 |
| ps_number | 外键，这个货品在这个货架上放了多少件 |

#### wms_product_supplier

| 列名 | 说明 |
|-----|------|
| ps_id | 主键 |
| product_id | 外键，货品的名称 |
| supplier_id | 外键，提供这个货品的供应商 |
| ps_in_price | 这个货品的进货价 |

#### wms_product_shelf

| 列名 | 说明 |
|-----|------|
| shelf_id | 主键 |
| shelf_name | 货架的名称 |
| shelf_capacity | 这个货架的容量 |
| storage_id | 外键，这个货架属于哪个库位 |

#### wms_storage

| 列名 | 说明 |
|-----|------|
| storage_id | 主键 |
| storage_name | 库位的名称 |
| storage_charger | 外键，这个库位的负责人 |
| warehouse_id | 这个库位属于哪个仓库 |

#### wms_storage_condition

| 列名 | 说明 |
|-----|------|
| sc_id | 主键 |
| storage_id | 外键，库位的名称 |
| condition_id | 外键，这个库位拥有哪个条件 |
| ps_in_price | 这个货品的进货价 |

#### wms_supplier

| 列名 | 说明 |
|-----|------|
| supplier_id | 主键 |
| supplier_name | 供应商名字 |
| supplier_contact_person | 供应商联系人 |
| supplier_address | 供应商的联系地址 |
| supplier_phone | 供应商的联系电话 |

#### wms_user

| 列名 | 说明 |
|-----|------|
| user_id | 主键 |
| user_name | 用户的登录名 |
| user_pswd | 用户的登录密码 |
| user_type | 外键，用户的类型 |
| user_email | 用户的邮箱 |
| user_cellphone | 用户的手机号 |
| user_address | 用户的地址 |
| user_real_name | 用户实际的显示名字 |

#### wms_user_type

| 列名 | 说明 |
|-----|------|
| user_type_id | 主键 |
| user_type_name | 用户类型名称 |

#### wms_warehouse

| 列名 | 说明 |
|-----|------|
| warehouse_id | 主键 |
| warehouse_name | 仓库名称 |
| warehouse_address | 仓库的地址 |
| warehouse_location | 仓库位于哪个省份 |
| warehouse_charger | 外键，表明这个仓库的负责人是谁 |


## 更新日志

1. 2017-06-12 完成第一部分的界面设计初稿。
2. 2017-06-16 完成项目的 SSH 构架搭建，并成功实现登录操作。
3. 2017-06-21 完成了产品列表页面的显示，分页，按类别筛选和按名称查询。
4. 2017-06-25 完成产品详情中的显示和图片修改功能。、
5. 2017-06-26 完善数据库设计。

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

### 报错 `Spring Hibernate - Could not obtain transaction-synchronized Session for current thread`

在每一个 `dao` 类的前面加上一行：

```java
@Transactional
```