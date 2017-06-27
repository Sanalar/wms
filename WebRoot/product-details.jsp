<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<meta charset="utf-8">
	<meta name="description" content="仓库管理系统">
	<meta name="author" content="詹娜娜">
	<meta name="keyword" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>仓库管理系统 - WMS - 詹娜娜</title>
 
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">

      <!-- plugins -->
    <link rel="stylesheet" href="asset/css/plugins/amazeui.min.css">
    <link rel="stylesheet" href="asset/css/plugins/amazeui.cropper.css">
    <link rel="stylesheet" href="asset/css/plugins/custom_up_img.css">
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/select2.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/datatables.bootstrap.min.css"/>
    <link href="asset/css/style.css" rel="stylesheet">
    <style type="text/css">
        .up-img-cover {width: 250px;height: 250px;}
        .up-img-cover img{width: 100%;}
    </style>

    <!-- end: Css -->

	<link rel="shortcut icon" href="asset/img/logomi.png">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="asset/js/plugins/html5shiv.js"></script>
      <script src="asset/js/plugins/respond.min.js"></script>
    <![endif]-->
  </head>

 <body id="mimin" class="dashboard">
      <!-- start: Header -->
        <nav class="navbar navbar-default header navbar-fixed-top">
          <div class="col-md-12 nav-wrapper">
            <div class="navbar-header" style="width:100%;">
              <div class="opener-left-menu is-open">
                <span class="top"></span>
                <span class="middle"></span>
                <span class="bottom"></span>
              </div>
                <a href="index.html" class="navbar-brand"> 
                 <b>仓库管理系统</b>
                </a>

              <ul class="nav navbar-nav search-nav">
                <li>
                   <div class="search">
                    <span class="fa fa-search icon-search" style="font-size:23px;"></span>
                    <div class="form-group form-animate-text">
                      <input name="goodsname" id="goodsname" type="text" class="form-text" required>
                      <span class="bar"></span>
                      <label for="goodsname" class="label-search">查询仓库 <b>货物</b> </label>
                    </div>
                  </div>
                </li>
              </ul>

              <ul class="nav navbar-nav navbar-right user-nav">
                <li class="user-name"><span>詹娜娜</span></li>
                  <li class="dropdown avatar-dropdown">
                   <img src="asset/img/avatar.png" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                   <ul class="dropdown-menu user-dropdown">
                     <li><a href="#"><span class="fa fa-user"></span> 用户设置</a></li>
                     <li><a href="#"><span class="fa fa-calendar"></span> 我的日程安排</a></li>
                     <li role="separator" class="divider"></li>
                     <li class="more">
                      <ul>
                        <li><a href=""><span class="fa fa-cogs"></span></a></li>
                        <li><a href=""><span class="fa fa-lock"></span></a></li>
                        <li><a href=""><span class="fa fa-power-off "></span></a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li ><a href="#" class="opener-right-menu"><span class="fa fa-coffee"></span></a></li>
              </ul>
            </div>
          </div>
        </nav>
      <!-- end: Header -->

      <div class="container-fluid mimin-wrapper">
  
          <!-- start:Left Menu -->
            <div id="left-menu">
              <div class="sub-left-menu scroll">
                <ul class="nav nav-list">
                    <li><div class="left-bg"></div></li>
                    <li class="time">
                      <h1 class="animated fadeInLeft">21:00</h1>
                      <p class="animated fadeInRight">Sat,October 1st 2029</p>
                    </li>
                    <li class="ripple">
                        <a href="index.html"><span class="fa-home fa"></span> 主页
                        </a>
                    </li>

                    <li class="ripple">
                        <a class="tree-toggle nav-header">
                            <span class=" icon-list"></span> 采购
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="materialreq.html">物料需求信息管理</a></li>
                            <li><a href="factory.html">厂商信息管理</a></li>
                            <li><a href="selectfa.html">筛选厂商</a></li>
                            <li><a href="fasupply.html">供货信息管理</a></li>
                        </ul>
                    </li>

                    <li class="ripple">
                        <a class="tree-toggle nav-header">
                            <span class="fa fa-balance-scale"></span> 质量检验
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="qualityre.html">质检结果管理</a></li>
                            <li><a href="conformity.html">合格证明</a></li>
                        </ul>
                    </li>


                    <li class="ripple">
                        <a class="tree-toggle nav-header">
                            <span class="fa-sign-in fa"></span> 入库管理
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="new-in.html">新建入库申请</a></li>
                            <li><a href="ins.html">入库单</a></li>
                            <li><a href="suppliers.html">供应商管理</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header">
                            <span class="fa-sign-out fa"></span> 出库管理
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="new-out.html">新建出库申请</a></li>
                            <li><a href="outs.html">出库单</a></li>
                            <li><a href="customers.html">客户管理</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header">
                            <span class="fa-area-chart fa"></span> 仓库盘点
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="new-check.html">新建库存盘点</a></li>
                            <li><a href="checks.html">库存盘点列表</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header">
                            <span class="fa-truck fa"></span> 仓库调度
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="new-transport.html">新建调度任务</a></li>
                            <li><a href="transports.html">仓库调度列表</a></li>
                        </ul>
                    </li>
                    <li class="ripple active">
                        <a class="tree-toggle nav-header">
                            <span class="fa-search fa"></span> 产品库存
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="product.html">产品管理</a></li>
                            <li><a href="storage.html">库存查询</a></li>
                            <li><a href="stream.html">仓库流水</a></li>
                        </ul>
                    </li>
                    <li class="ripple"><a href="calendar.html"><span class="fa fa-calendar-o"></span> 日程表 </a></li>
                    <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-envelope-o"></span> 邮件 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                        <ul class="nav nav-list tree">
                            <li><a href="mail-box.html">收件箱</a></li>
                            <li><a href="compose-mail.html">Compose Mail</a></li>
                            <li><a href="view-mail.html">View Mail</a></li>
                        </ul>
                    </li>
                  </ul>
                </div>
            </div>
          <!-- end: Left Menu -->

  		
          <!-- start: content -->
          <div id="content">
              <div class="tabs-wrapper text-center">
                  <div class="panel box-shadow-none text-left content-header">
                      <div class="panel-body" style="padding-bottom:0px;">
                          <div class="col-md-12">
                              <h3 class="animated fadeInLeft"><b class="text-primary"><s:property value="product.productName"/></b> 产品详情</h3>
                              <p class="animated fadeInDown">
                                  仓库管理系统 <span class="fa-angle-right fa"></span> 产品库存 <span class="fa-angle-right fa"></span> 产品管理
                                  <span class="fa-angle-right fa"></span> 产品详情
                              </p>
                          </div>
                          <ul id="tabs-demo" class="nav nav-tabs content-header-tab" role="tablist" style="padding-top:10px;">
                              <li role="presentation" class="active">
                                  <a href="#product-info" id="tabs1" data-toggle="tab">产品属性</a>
                              </li>
                              <li role="presentation" class="">
                                  <a href="#storage-stream" id="tabs2" data-toggle="tab">库存与流水</a>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <div class="col-md-12 tab-content">
                      <div role="tabpanel" class="tab-pane fade active in" id="product-info" aria-labelledby="tabs1">
                        <div class="col-md-12">
                          <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="row">
                                    <!-- 产品表单 -->
                                    <div class="col-md-8">
                                        <form action="editProduct.action" method="post">
                                        	<input type="hidden" name="productId" value='<s:property value="id"/>' />
                                            <div class="col-md-6">
                                                <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <input type="text" class="form-text" name="productName" required value='<s:property value="product.productName"/>'>
                                                    <span class="bar"></span>
                                                    <label>产品名称 <span class="text-danger">*</span></label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <input type="text" class="form-text" name="productCode" required value='<s:property value="product.productCode"/>'>
                                                    <span class="bar"></span>
                                                    <label>产品编号 <span class="text-danger">*</span></label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <input type="text" class="form-text" id="selected-category" data-am-modal="{target: '#category-dialog'}" required
                                                    name="productCategory" value='<s:property value="product.wmsCategory.wmsCategory.categoryName"/> > <s:property value="product.wmsCategory.categoryName"/>'>
                                                    <span class="bar"></span>
                                                    <label>产品分类</label>
                                                </div>
                                                <!-- Modal -->
                                                <div class="am-modal am-modal-no-btn" id="category-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                                    <div class="am-modal-dialog" role="document" style="text-align:left; width:600px">
                                                        <div class="modal-content">
                                                            <div class="am-modal-hd">
                                                            	<span class="modal-title" id="myModalLabel">选择货品分类</span>
                                                                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                                                                
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="wareSort clearfix">
                                                                    <ul id="sort1"></ul>
                                                                    <ul id="sort2" style="display: none;"></ul>
                                                                </div>
                                                                <div class="selectedSort"><b>当前选择的商品类别：</b><i id="selectedSort"></i></div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default btn-round btn-gradient" data-am-modal-close>取 消</button>
                                                                <button type="button" id="releaseBtn" class="btn btn-primary btn-round btn-gradient" disabled="disabled">确 定</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <input type="text" class="form-text" name="productSupplier" value='<s:property value="product.productStandard"/>'>
                                                    <span class="bar"></span>
                                                    <label>规格</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <input type="text" class="form-text" name="productUnit" value='<s:property value="product.productUnit"/>'>
                                                    <span class="bar"></span>
                                                    <label>单位</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <label>特殊存放条件</label>
                                                    <select class="select2-A btn-block" name="productConditions" multiple="multiple">
                                                        <s:iterator value="conditionList.entrySet()" id="e">
                                                        <option value='<s:property value="#e.key"/>' <s:if test="productConditions.contains(#e.key)">selected</s:if>><s:property value="#e.value"/></option>
                                                        </s:iterator>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                                    <input type="text" class="form-text" name="productDescription" value='<s:property value="product.productDescription"/>'>
                                                    <span class="bar"></span>
                                                    <label>产品描述</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group form-text text-center" style="margin-top:10px; margin-bottom: 10px">
                                                    <button class="btn btn-success btn-round btn-gradient" style="width: 100px; margin-right: 20px;">保 存</button>
                                                    <button class="btn btn-default btn-round btn-gradient" style="width: 100px;">取 消</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- end 产品表单 -->
                                    <!-- 产品图片 -->
                                    <div class="col-md-4">
                                        <div class="up-img-cover"  id="up-img-touch" >
                                            <img class="am-thumbnail" alt="点击图片上传" src='products/<s:property value="product.productImage"/>' data-am-popover="{content: '点击上传产品图片', trigger: 'hover focus'}" 
                                            style="width:250px;height:250px">
                                        </div>
                                        <!--图片上传框-->
                                        <div class="am-modal am-modal-no-btn up-modal-frame" tabindex="-1" id="up-modal-frame">
                                            <div class="am-modal-dialog up-frame-parent up-frame-radius">
                                                <div class="am-modal-hd up-frame-header">
                                                    <label>修改产品图片</label>
                                                    <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                                                </div>
                                                <div class="am-modal-bd up-frame-body">
                                                    <div class="am-g am-fl">

                                                        <div class="am-form-group am-form-file">
                                                            <div class="am-fl">
                                                                <button type="button" class="am-btn am-btn-default am-btn-sm">
                                                                    <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                                                            </div>
                                                            <input type="file" class="up-img-file">
                                                        </div>
                                                    </div>
                                                    <div class="am-g am-fl">
                                                        <div class="up-pre-before up-frame-radius">
                                                            <img alt="" src="" class="up-img-show" id="up-img-show" >
                                                        </div>
                                                        <div class="up-pre-after up-frame-radius">
                                                        </div>
                                                    </div>
                                                    <div class="am-g am-fl">
                                                        <div class="up-control-btns">
                                                            <span class="am-icon-rotate-left"   id="up-btn-left"></span>
                                                            <span class="am-icon-rotate-right"  id="up-btn-right"></span>
    				<span class="am-icon-check up-btn-ok" url="uploadProductImage.action" targetid='<s:property value="id"/>'
                          parameter="{width:'250',height:'250'}">
    				</span>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                        <!--加载框-->
                                        <div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="up-modal-loading">
                                            <div class="am-modal-dialog">
                                                <div class="am-modal-hd">正在上传...</div>
                                                <div class="am-modal-bd">
                                                    <span class="am-icon-spinner am-icon-spin"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <!--警告框-->
                                        <div class="am-modal am-modal-alert" tabindex="-1" id="up-modal-alert">
                                            <div class="am-modal-dialog">
                                                <div class="am-modal-hd">信息</div>
                                                <div class="am-modal-bd"  id="alert_content">
                                                    成功了
                                                </div>
                                                <div class="am-modal-footer">
                                                    <span class="am-modal-btn">确定</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 产品图片 -->
                                </div>
                            </div>
                          </div>
                          <div class="panel panel-default">
                            <div class="panel-heading bg-white border-none">
                              <h4>货品供应商</h4>
                            </div>
                            <div class="panel-body">
                              <div class="responsive-table" style="padding: 15px;">
                                <table class="table table-striped table-bordered" width="100%" cellspacing="0">
                                  <thead>
                                    <tr>
                                      <th>供货商名称</th>
                                      <th>供货商联系人</th>
                                      <th>供货商电话</th>
                                      <th>供货商地址</th>
                                      <th>进价</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                     <s:iterator value="productSupplier" id="s">
                                     <tr>
                                       <td><s:property value="#s.wmsSupplier.supplierName"/></td>
                                       <td><s:property value="#s.wmsSupplier.supplierContactPerson"/></td>
                                       <td><s:property value="#s.wmsSupplier.supplierPhone"/></td>
                                       <td><s:property value="#s.wmsSupplier.supplierAddress"/></td>
                                       <td><s:property value="df.format(#s.psInPrice)"/></td>
                                     </tr>
                                     </s:iterator>
                                   </tbody>
                                 </table>
                               </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div role="tabpanel" class="tab-pane fade" id="storage-stream" aria-labelledby="tabs2">
                        <div class="col-md-12 panel-info">
                            <div class="panel-heading">
                                <h4 class="panel-title text-white">
                                    库存信息
                                </h4>
                            </div>
                            <div class="panel panel-default">
                                <div class="responsive-table" style="padding: 15px;">
                                    <table class="table table-striped table-bordered" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th><span class="fa fa-map-marker"></span> 仓库位置</th>
                                            <th><span class="fa fa-cubes"></span> 库存数量</th>
                                            <th><span class="fa fa-exchange"></span> 流水</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        <tr>
                                            <td>北京海淀仓库</td>
                                            <td>594</td>
                                            <td><a href="#">查看流水</a></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div style="padding: 0 15px 15px 15px">所有库存总数：<span class="text-success">2048</span> </div>
                            </div>
                        </div>
                          <div class="col-md-12 panel-info">
                              <div class="panel-heading">
                                  <h4 class="panel-title text-white">
                                      <span class="text-danger">北京海淀仓库</span> 库存流水详情
                                  </h4>
                              </div>
                              <div class="panel panel-default">
                                  <div class="responsive-table" style="padding: 15px;">
                                      <table id="stream-table" class="table table-striped table-bordered" width="100%" cellspacing="0">
                                          <thead>
                                          <tr>
                                              <th>序号</th>
                                              <th>时间</th>
                                              <th>出入库类型</th>
                                              <th>单价</th>
                                              <th>出入库数量</th>
                                              <th>库存余量</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>2017-06-01</td>
                                              <td>采购入库</td>
                                              <td>9.30</td>
                                              <td class="text-success">+500</td>
                                              <td>594</td>
                                          </tr>
                                          </tbody>
                                      </table>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <!-- end: content -->

      </div>
    <!-- start: Javascript -->
    <script src="asset/js/jquery.min.js"></script>
    <script src="asset/js/jquery.ui.min.js"></script>
    <script src="asset/js/bootstrap.min.js"></script>
   
    
    <!-- plugins -->
      <script src="asset/js/plugins/moment.min.js"></script>
      <script src="asset/js/plugins/jquery.nicescroll.js"></script>
      <script src="asset/js/plugins/jquery.mask.min.js"></script>
      <script src="asset/js/plugins/select2.full.min.js"></script>
      <script src="asset/js/plugins/amazeui.min.js" charset="utf-8"></script>
      <script src="asset/js/plugins/cropper.min.js" charset="utf-8"></script>
      <script src="asset/js/plugins/custom_up_img.js" charset="utf-8"></script>
      <script src="asset/js/plugins/jquery.datatables.min.js"></script>
      <script src="asset/js/plugins/datatables.bootstrap.min.js"></script>

      <!-- custom -->
      <script src="asset/js/main.js"></script>
      <script type="text/javascript">
          $('.mask-money').mask('000,000,000,000,000.00', {reverse: true});
          $(".select2-A").select2({
              placeholder: "选择特殊贮存条件",
              allowClear: true
          });
          $(document).ready(function(){

              $(".nav-tabs a").click(function (e) {
                  e.preventDefault();
                  $(this).tab('show');
              });
              $('#stream-table').DataTable();
              
              <s:if test="msg != null">
              alert('<s:property value="msg" escape="false"/>');
              </s:if>
          });
      </script>

      <script>
          /*定义三级分类数据*/
          //一级分类
          var province = <s:property value="topCategoryListString" escape="false"/>;
          //二级分类
          var city = <s:property value="allSubCategoryListString" escape="false"/>;

          var expressP, expressC, expressD, expressArea, areaCont;
          var arrow = " <font>&gt;</font> ";

          /*初始化一级目录*/
          function intProvince() {
              areaCont = "";
              for (var i=0; i<province.length; i++) {
                  areaCont += '<li onClick="selectP(' + i + ');"><a href="javascript:void(0)">' + province[i] + '</a></li>';
              }
              $("#sort1").html(areaCont);
          }
          intProvince();

          /*选择一级目录*/
          function selectP(p) {
              areaCont = "";
              for (var j=0; j<city[p].length; j++) {
                  areaCont += '<li onClick="selectC(' + p + ',' + j + ');"><a href="javascript:void(0)">' + city[p][j] + '</a></li>';
              }
              $("#sort2").html(areaCont).show();
              $("#sort1 li").eq(p).addClass("active").siblings("li").removeClass("active");
              expressP = province[p];
              $("#selectedSort").html(expressP);
              $("#releaseBtn").attr("disabled", "disabled");
          }

          /*选择二级目录*/
          function selectC(p,c) {
              areaCont = "";
              $("#sort2 li").eq(c).addClass("active").siblings("li").removeClass("active");
              expressC = expressP + arrow + city[p][c];
              $("#selectedSort").html(expressC);
              $("#releaseBtn").removeAttr("disabled");
          }

          /*点击下一步*/
          $("#releaseBtn").click(function() {
              var releaseS = $(this).prop("disabled");
              if (releaseS == false) {//未被禁用
                  $("#selected-category").val($("#selectedSort").text());
                  $("#category-dialog").modal('close');
              }
          });
      </script>
  <!-- end: Javascript -->
  </body>
</html>