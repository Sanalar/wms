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
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/jquery.vector-map.css"/>
	<link href="asset/css/style.css" rel="stylesheet">
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
              <div class="panel box-shadow-none content-header" style="margin-bottom:0">
                  <div class="panel-body">
                      <div class="col-md-12">
                          <h3 class="animated fadeInLeft">产品管理</h3>
                          <p class="animated fadeInDown">
                              仓库管理系统 <span class="fa-angle-right fa"></span> 产品库存 <span class="fa-angle-right fa"></span> 产品管理
                          </p>
                      </div>
                  </div>
              </div>
              <div class="panel box-shadow-none">
                  <div class="panel-body">
                      <div class="col-md-12">
                        <div class="form-inline">
                            <button class=" btn btn-circle btn-gradient btn-mn btn-success" value="添加">
                                <span class="fa fa-plus"></span>
                            </button>
                            <button class=" btn btn-circle btn-gradient btn-mn btn-success" value="复制添加">
                                <span class="fa fa-copy"></span>
                            </button>
                            <div class="btn-group" role="group" style="margin-left:20px">
                                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="fa fa-cubes"></span> 所有分类
                                    <span class="fa fa-angle-down"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><span class="fa fa-cubes"></span> 所有分类</a></li>
                                    <li><a href="#"><span class="fa fa-flask"></span> 危化品</a></li>
                                    <li><a href="#"><span class="fa fa-cutlery"></span> 食品</a></li>
                                    <li><a href="#"><span class="fa fa-futbol-o"></span> 日用品</a></li>
                                    <li><a href="#"><span class="fa fa-tv"></span> 电子设备</a></li>
                                    <li><a href="#"><span class="fa fa-medkit"></span> 医药品</a></li>
                                </ul>
                            </div>
                            <div class="btn-group" role="group">
                                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="fa fa-cubes"></span> 所有分类
                                    <span class="fa fa-angle-down"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><span class="fa fa-cubes"></span> 所有分类</a></li>
                                </ul>
                            </div>
                            <div class="search pull-right">
                                <span class="fa fa-search icon-search" style="font-size:23px;"></span>
                                <div class="form-group form-animate-text" style="margin-bottom: 0;">
                                    <input name="goodsname" id="goodsname" type="text" class="form-text" placeholder="搜索货品" required style="padding-bottom: 5px; padding-top: 0">
                                    <span class="bar"></span>
                                </div>
                            </div>
                        </div>
                      </div>
                  </div>
              </div>
              <div class="col-md-12">
                  <div class="row">
                  	<s:iterator value="products" id="p">
                  	<div class="col-sm-6 col-md-3 product-grid">
                  		<div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥<s:property value="#p.productInPrice"/></h4>
                              </div>
                              <img src='products/<s:property value="#p.productImage"/>' alt="..." style="width:250px;height:250px">
                              <div class="caption">
                                  <small><s:property value="#p.wmsCategory.wmsCategory.categoryName"/> <span class="fa-angle-right fa"></span> 
                                  		<s:property value="#p.wmsCategory.categoryName"/></small>
                                  <small class="pull-right">
                                      <span><s:property value="#p.productCode"/></span>
                                  </small>
                                  <h4 class="text-primary"><s:property value="#p.productName"/></h4>
                                  <p style="height: 60px; overflow: hidden"><s:property value="#p.productDescription"/></p>
                                  <p><a href='product-detail.html?id=<s:property value="#p.productId"/>' class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                  	</div>
                  	</s:iterator>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="product-detail.html" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="product-detail.html" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="#" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="#" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="#" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="#" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>
                      <div class="col-sm-6 col-md-3 product-grid">
                          <div class="thumbnail">
                              <div class="product-location">
                                  <span class="fa-map-marker fa"></span> 北京海淀仓库
                              </div>
                              <div class="product-price product-price-bottom">
                                  <h4 class="text-danger">￥12.50</h4>
                              </div>
                              <img src="holder.js/250x250" alt="...">
                              <div class="caption">
                                  <small>食品 <span class="fa-angle-right fa"></span> 糖果巧克力</small>
                                  <small class="pull-right">
                                      <span>dfqkl-1011</span>
                                  </small>
                                  <h4 class="text-primary">德芙巧克力</h4>
                                  <p style="height: 60px; overflow: hidden">德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。</p>
                                  <p><a href="#" class="btn btn-primary btn-block" role="button">查看详情</a></p>
                              </div>
                          </div>
                      </div>

                  </div>
              </div>
              <div class="col-md-12">
                  <div class="row">
                      <div class="col-sm-12 text-center">
                          <div class="btn-group" role="group" aria-label="..." style="margin-bottom:20px">
                              <button type="button" class="btn">
                                  <span class="fa fa-angle-left"></span>
                              </button>
                              <button type="button" class="btn active">1</button>
                              <button type="button" class="btn">2</button>
                              <button type="button" class="btn">
                                  <span class="fa fa-angle-right"></span>
                              </button>
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
      <script src="asset/js/plugins/holder.min.js"></script>
      <script src="asset/js/plugins/moment.min.js"></script>
      <script src="asset/js/plugins/jquery.nicescroll.js"></script>

    <!-- custom -->
      <script src="asset/js/main.js"></script>
      <script type="text/javascript">
          $(document).ready(function(){

          });
      </script>
  <!-- end: Javascript -->
  </body>
</html>