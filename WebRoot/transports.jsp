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
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/select2.min.css"/>
      <link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/datatables.bootstrap.min.css"/>
    <link href="asset/css/style.css" rel="stylesheet">
    <style type="text/css">
        .up-img-cover {width: 250px;height: 250px;}
        .up-img-cover img{width: 100%;}
    </style>
    <link href="asset/css/plugins/font-awesome-animation.min.css" type="text/css" rel="stylesheet"/>

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
                    <li class="ripple active">
                        <a class="tree-toggle nav-header">
                            <span class="fa-truck fa"></span> 仓库调度
                            <span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree">
                            <li><a href="new-transport.html">新建调度任务</a></li>
                            <li><a href="transports.html">仓库调度列表</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
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

			<!-- modal -->
          <div class="modal fade" id="select-warehouse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                  <form class="modal-content" action="checks.html" method="get">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title">选择当前仓库</h4>
                      </div>
                      <div class="modal-body">
                          <div class="row">
                              <div class="col-md-12">
                                  <div class="form-group">
                                      <select class="form-control" name="warehouseId" id="warehouseId-select">
                                          <option value="1">北京海淀仓库</option>
                                      </select>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="modal-footer">
                          <button type="button" class="btn btn-default btn-round btn-gradient" data-dismiss="modal">关 闭</button>
                          <button type="submit" class="btn btn-success btn-round btn-gradient">确 定</button>
                      </div>
                  </form>
              </div>
          </div>

          <!-- modal -->
          <div class="modal fade" id="show-transport" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document" style="width:800px;">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title">调度信息 - <span id="cp-id"></span></h4>
                      </div>
                      <div class="modal-body">
                          <div class="col-md-6" style="font-size: 16px;">
                              <span class="text-primary">调出仓库:</span>
                              <span id="cp-from">北京海淀仓库</span>
                          </div>
                          <div class="col-md-6" style="font-size: 16px;">
                              <span class="text-primary">调入仓库:</span>
                              <span id="cp-to">天津武清仓库</span>
                          </div>
                          <div class="col-md-4" style="font-size: 16px;">
                              <span class="text-primary">调出时间:</span>
                              <span id="cp-create-time">2017-06-07</span>
                          </div>
                          <div class="col-md-4" style="font-size: 16px;">
                              <span class="text-primary">审核时间:</span>
                              <span id="cp-accept-time">2017-06-07</span>
                          </div>
                          <div class="col-md-4" style="font-size: 16px;">
                              <span class="text-primary">确认时间:</span>
                              <span id="cp-finish-time">2017-06-07</span>
                          </div>
                          <div class="col-md-4" style="font-size: 16px;">
                              <span class="text-primary">申请人:</span>
                              <span id="cp-creator">2017-06-07</span>
                          </div>
                          <div class="col-md-4" style="font-size: 16px;">
                              <span class="text-primary">审核人:</span>
                              <span id="cp-acceptor">2017-06-07</span>
                          </div>
                          <div class="col-md-4" style="font-size: 16px;">
                              <span class="text-primary">确认人:</span>
                              <span id="cp-finisher">2017-06-07</span>
                          </div>
                          <div class="col-md-12" style="font-size: 16px; margin-bottom: 15px">
                              <div class="text-primary">备注信息:</div>
                              <div class="text-default" id="cp-desc">快点给老子调度</div>
                          </div>
                          <div class="responsive-table" style="padding: 15px;">
                              <table class="table table-striped table-bordered" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                      <th>编号</th>
                                      <th>品名</th>
                                      <th>分类</th>
                                      <th>库位号</th>
                                      <th>货架号</th>
                                      <th>剩余库存</th>
                                      <th>调出数量</th>
                                      <th>调度成本</th>
                                  </tr>
                                  </thead>
                                  <tbody id="cp-items">
                                  <tr>
                                      <td>dfqkl-1011</td>
                                      <td>德芙巧克力</td>
                                      <td>食品 > 糖果/糖果巧克力</td>
                                      <td>D12</td>
                                      <td>TP-312</td>
                                      <td>334</td>
                                      <td>12</td>
                                      <td>55.0</td>
                                  </tr>
                                  </tbody>
                              </table>
                          </div>
                      </div>
                      <div class="modal-footer">
                          <button type="button" class="btn btn-primary btn-round btn-gradient" data-dismiss="modal">关 闭</button>
                      </div>
                  </div>
              </div>
          </div>

          <!-- start: content -->
          <div id="content">
              <div class="tabs-wrapper text-center">
                  <div class="panel box-shadow-none text-left content-header">
                      <div class="panel-body" style="padding-bottom:0px;">
                          <div class="col-md-12">
                              <h3 class="animated fadeInLeft"><a class="text-primary" href="#" id="select-warehouse-bt"><s:property value="warehouseName"/></a> 仓库调度列表</h3>
                              <p class="animated fadeInDown">
                                  仓库管理系统 <span class="fa-angle-right fa"></span> 仓库调度
                              </p>
                          </div>
                          <ul id="tabs-demo" class="nav nav-tabs content-header-tab" role="tablist" style="padding-top:10px;">
                              <li role="presentation" class="active">
                                  <a href="#storage-info" id="tabs1" data-toggle="tab">待审核调度表</a>
                              </li>
                              <li role="presentation" class="">
                                  <a href="#storage-position" id="tabs2" data-toggle="tab">待确认调度表</a>
                              </li>
                              <li role="presentation" class="">
                                  <a href="#storage-details" id="tabs3" data-toggle="tab">所有调度表</a>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <div class="col-md-12 tab-content">
                      <div role="tabpanel" class="tab-pane fade active in" id="storage-info" aria-labelledby="tabs1">
                          <div class="col-md-12 panel-info">
                              <div class="panel-heading">
                                  <h4 class="panel-title text-white">
                                      待审核调度列表
                                  </h4>
                              </div>
                              <div class="panel panel-default">
                                  <div class="responsive-table" style="padding: 15px;">
                                      <table class="datatable table table-striped table-bordered" width="100%" cellspacing="0">
                                          <thead>
                                          <tr>
                                              <th>调度编号</th>
                                              <th>申请时间</th>
                                              <th>调出仓库</th>
                                              <th>调入仓库</th>
                                              <th>调拨数量</th>
                                              <th>调拨费用</th>
                                              <th>申请人</th>
                                              <th>审核操作</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <s:iterator value="summary1" id="s">
                                          <tr>
                                              <td><a href="#" onclick='showTransDetails("<s:property value="#s.id"/>")'><s:property value="#s.id"/></a> </td>
                                              <td><s:property value="#s.createTime"/></td>
                                              <td><s:property value="#s.fromHouse"/></td>
                                              <td><s:property value="#s.toHouse"/></td>
                                              <td><s:property value="#s.number"/></td>
                                              <td><s:property value="df.format(#s.cost)"/></td>
                                              <td><s:property value="#s.creator"/></td>
                                              <td>
                                                  <a data-id='<s:property value="#s.id"/>' class="ok-accept-t btn btn-success btn-circle btn-mn btn-gradient" style="font-size: 22px"><span class="fa fa-check"></span></a>
                                                  <a data-id='<s:property value="#s.id"/>' class="bad-accept-t btn btn-danger btn-circle btn-mn btn-gradient" style="font-size: 22px"><span class="fa fa-times"></span></a>
                                              </td>
                                          </tr>
                                          </s:iterator>
                                          </tbody>
                                      </table>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div role="tabpanel" class="tab-pane fade" id="storage-position" aria-labelledby="tabs2">
                          <div class="col-md-12 panel-info">
                              <div class="panel-heading">
                                  <h4 class="panel-title text-white">
                                      待确认调度列表
                                  </h4>
                              </div>
                              <div class="panel panel-default">
                                  <div class="responsive-table" style="padding: 15px;">
                                      <table class="datatable table table-striped table-bordered" width="100%" cellspacing="0">
                                          <thead>
                                          <tr>
                                              <th>调度编号</th>
                                              <th>审核时间</th>
                                              <th>调出仓库</th>
                                              <th>调入仓库</th>
                                              <th>调拨数量</th>
                                              <th>调拨费用</th>
                                              <th>审核人</th>
                                              <th>确认操作</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <s:iterator value="summary2" id="s">
                                          <tr>
                                              <td><a href="#" onclick='showTransDetails("<s:property value="#s.id"/>")'><s:property value="#s.id"/></a> </td>
                                              <td><s:property value="#s.acceptTime"/></td>
                                              <td><s:property value="#s.fromHouse"/></td>
                                              <td><s:property value="#s.toHouse"/></td>
                                              <td><s:property value="#s.number"/></td>
                                              <td><s:property value="df.format(#s.cost)"/></td>
                                              <td><s:property value="#s.acceptor"/></td>
                                              <td>
                                                  <a data-id='<s:property value="#s.id"/>' class="ok-check-t btn btn-success btn-circle btn-mn btn-gradient" style="font-size: 22px"><span class="fa fa-check"></span></a>
                                                  <a data-id='<s:property value="#s.id"/>' class="bad-check-t btn btn-danger btn-circle btn-mn btn-gradient" style="font-size: 22px"><span class="fa fa-times"></span></a>
                                              </td>
                                          </tr>
                                          </s:iterator>
                                          </tbody>
                                      </table>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div role="tabpanel" class="tab-pane fade" id="storage-details" aria-labelledby="tabs3">
                          <div class="col-md-12 panel-info">
                              <div class="panel-heading">
                                  <h4 class="panel-title text-white">
                                      所有调度列表
                                  </h4>
                              </div>
                              <div class="panel panel-default">
                                  <div class="responsive-table" style="padding: 15px;">
                                      <table class="datatable table table-striped table-bordered" width="100%" cellspacing="0">
                                          <thead>
                                          <tr>
                                              <th>调度编号</th>
                                              <th>调度时间</th>
                                              <th>调出仓库</th>
                                              <th>调入仓库</th>
                                              <th>调拨数量</th>
                                              <th>调拨费用</th>
                                              <th>申请人</th>
                                              <th>审核人</th>
                                              <th>确认人</th>
                                              <th>状态</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <s:iterator value="summary3" id="s">
                                          <tr>
                                              <td><a href="#" onclick='showTransDetails("<s:property value="#s.id"/>")'><s:property value="#s.id"/></a> </td>
                                              <td><s:property value="#s.createTime"/></td>
                                              <td><s:property value="#s.fromHouse"/></td>
                                              <td><s:property value="#s.toHouse"/></td>
                                              <td><s:property value="#s.number"/></td>
                                              <td><s:property value="df.format(#s.cost)"/></td>
                                              <td><s:property value="#s.creator"/></td>
                                              <td><s:property value="#s.acceptor"/></td>
                                              <td><s:property value="#s.finisher"/></td>
                                              <td><s:property value="#s.state"/></td>
                                          </tr>
                                          </s:iterator>
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

          <!-- modal -->
          <div class="modal fade" id="loading-box" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title">正在加载</h4>
                      </div>
                      <div class="modal-body">
                          <div class="row">
                              <div class="col-md-12" style="font-size:22px">
                                  <span class="fa fa-spinner faa-spin animated"></span> <span id="loading-msg">正在拼命加载数据，请稍后...</span>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>

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
      <script src="asset/js/plugins/jquery.datatables.min.js"></script>
      <script src="asset/js/plugins/datatables.bootstrap.min.js"></script>
      <script src="asset/js/plugins/chart.min.js"></script>
      <script src="asset/js/transport.js"></script>

      <!-- custom -->
      <script src="asset/js/main.js"></script>
      <script type="text/javascript">

          $(document).ready(function(){

              $(".nav-tabs a").click(function (e) {
                  e.preventDefault();
                  $(this).tab('show');
              });
              $('.datatable').DataTable();

				$("#select-warehouse-bt").click(function(event){
                  event.preventDefault();
                  $("#loading-box").modal({backdrop: 'static', keyboard: false});
                  $.ajax( {  
                	url:'fetchWarehouseList.action',  
                	dataType:'json',
                	type: "POST",
                	success: function(data, textStatus){
                		var widSel = $("#warehouseId-select");
                		widSel.empty();
                		$.each(data,function(i,n){ 
							widSel.append('<option value="'+n["id"]+'">'+n["name"]+'</option>'); 
						}); 
						$("#loading-box").modal("hide");
						$("#select-warehouse").modal();
                	},
                	error: function(){
                		$("#loading-box").modal("hide");
                		alert("请求仓库列表失败！请检查网络设置！"); 
                	}  
         		});
              });
              
              $(".ok-accept-t").click(function(e){
              	e.preventDefault();
              	var id = $(this).attr("data-id");
              	if(!confirm("审核通过意味着将要创建对应的出库单，并按照此单的设置进行出库，您确定要继续吗？")){
              		return false;
              	}
              	window.location.href="aceeptTransport.action?id=" + id;
              });
              $(".bad-accept-t").click(function(e){
              	e.preventDefault();
              	var id = $(this).attr("data-id");
              	if(!confirm("此操作将驳回该调度请求，您确定要继续吗？")){
              		return false;
              	}
              	window.location.href="abandonTransport.action?id=" + id;
              });
              $(".ok-check-t").click(function(e){
              	e.preventDefault();
              	var id = $(this).attr("data-id");
              	if(!confirm("确认调度意味着将要创建对应的入库单，并按照此单的设置进行入库，您确定要继续吗？")){
              		return false;
              	}
              	window.location.href="aceeptTransport2.action?id=" + id;
              });
              $(".bad-check-t").click(function(e){
              	e.preventDefault();
              	var id = $(this).attr("data-id");
              	if(!confirm("此操作将驳回该调度请求，您确定要继续吗？")){
              		return false;
              	}
              	window.location.href="abandonTransport2.action?id=" + id;
              });
          });

          function showDetail(id){
              $("#show-transport").modal('show');
          }
      </script>

  <!-- end: Javascript -->
  </body>
</html>