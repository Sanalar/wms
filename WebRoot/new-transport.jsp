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
    <link href="asset/css/plugins/font-awesome-animation.min.css" rel="stylesheet"/>

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

          <!-- Modal -->
          <div class="modal fade" id="choose-product" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document" style="width:800px;">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title">选择货品</h4>
                      </div>
                      <div class="modal-body">
                          <div class="responsive-table" style="padding: 15px;">
                              <table class="datatable table table-striped table-bordered" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                      <th>产品编号</th>
                                      <th>产品名称</th>
                                      <th>分类</th>
                                      <th>库位号</th>
                                      <th>货架号</th>
                                      <th>剩余库存</th>
                                      <th>添加</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                      <td><div id="sp-code1">dfqkl-1011</div></td>
                                      <td><div id="sp-name1" data-id="1">德芙巧克力</div></td>
                                      <td><div id="sp-category1">食品 > 糖果/糖果巧克力</div></td>
                                      <td><div id="sp-storage1">D12</div></td>
                                      <td><div id="sp-shelf1" data-id="2">TP-312</div></td>
                                      <td><div id="sp-last1">334</div></td>
                                      <td><a class="select-product" data-id="1" href="#"><span class="fa fa-check"></span> 选择</a></td>
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
          <div class="modal fade" id="category-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title" id="myModalLabel">选择货品分类</h4>
                      </div>
                      <div class="modal-body">
                          <div class="wareSort clearfix">
                              <ul id="sort1"></ul>
                              <ul id="sort2" style="display: none;"></ul>
                          </div>
                          <div class="selectedSort"><b>当前选择的商品类别：</b><i id="selectedSort"></i></div>
                      </div>
                      <div class="modal-footer">
                          <button type="button" class="btn btn-default btn-round btn-gradient" data-dismiss="modal">取 消</button>
                          <button type="button" id="releaseBtn" class="btn btn-primary btn-round btn-gradient" disabled="disabled">确 定</button>
                      </div>
                  </div>
              </div>
          </div>
          <!-- start: content -->
          <div id="content">
              <div class="tabs-wrapper text-center">
                  <div class="panel box-shadow-none text-left content-header">
                      <div class="panel-body" style="padding-bottom:0;">
                          <div class="col-md-12">
                              <h3 class="animated fadeInLeft">新建调度任务</h3>
                              <p class="animated fadeInDown">
                                  仓库管理系统 <span class="fa-angle-right fa"></span> 仓库调度 <span class="fa-angle-right fa"></span> 新建调度任务
                                  
                              </p>
                          </div>
                      </div>
                  </div>
                  <div class="col-md-12">
                      <div class="panel form-element-padding text-left">
                          <div class="panel-heading">
                              <h4><span class="fa fa-truck"></span> 仓库调度申请表</h4>
                          </div>
                          <div class="panel-body">
                              <form action="newTransport.action" method="post" id="newTransForm">
                                  <div class="form-group">
                                      <div class="col-md-6 form-inline">
                                          <label>
                                              <span class="fa fa-sign-out"></span> 调出仓库：
                                              <select class="form-control" name="wid">
                                              <s:iterator value="warehouseList" id="w">
	                                          	<s:if test="#w.warehouseId == wid">
	                                          	<option value='<s:property value="#w.warehouseId"/>' data-fixed selected><s:property value="#w.warehouseName"/></option>
	                                          	</s:if>
	                                          	<s:else>
	                                          	<option value='<s:property value="#w.warehouseId"/>'><s:property value="#w.warehouseName"/></option>
	                                          	</s:else>
	                                          </s:iterator>
                                              </select>
                                          </label>
                                      </div>
                                      <div class="col-md-6 form-inline">
                                          <label>
                                              <span class="fa fa-sign-in"></span> 调入仓库：
                                              <select class="form-control">
                                              <s:iterator value="warehouseList" id="w">
                                          		<option value='<s:property value="#w.warehouseId"/>'><s:property value="#w.warehouseName"/></option>
                                              </s:iterator>
                                              </select>
                                          </label>
                                      </div>
                                      <div class="col-md-12">
                                          <div class="form-group form-animate-text" style="margin-top:10px; margin-bottom: 10px">
                                              <input type="text" class="form-text">
                                              <span class="bar"></span>
                                              <label><span class="fa fa-align-justify"></span> 调度备注</label>
                                          </div>
                                      </div>
                                      <div class="responsive-table" style="padding: 15px;">
                                          <table id="check-item-table" class="table table-striped table-bordered" width="100%" cellspacing="0">
                                              <thead>
                                              <tr>
                                                  <th>产品编号</th>
                                                  <th>产品名称</th>
                                                  <th>分类</th>
                                                  <th>库位</th>
                                                  <th>货架号</th>
                                                  <th>现有库存</th>
                                                  <th>调出数量</th>
                                                  <th>调度成本</th>
                                                  <th>操作</th>
                                              </tr>
                                              </thead>
                                              <tbody data-count="0">
                                              <tr><td colspan="9"><div class="text-center text-default">没有记录</div></td></tr>
                                              </tbody>
                                          </table>
                                      </div>
                                      <div class="form-inline text-center">
                                          <a class="btn btn-primary btn-round btn-gradient btn-lg" id="add-product">添加货品</a>
                                          <button class="btn btn-success btn-round btn-gradient btn-lg" style="margin-left: 20px;" id="newTransFormSubmit">确认提交</button>
                                      </div>
                                  </div>
                              </form>
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
      <script src="asset/js/transport.js"></script>

      <!-- custom -->
      <script src="asset/js/main.js"></script>
      <script type="text/javascript">
          $('.mask-money').mask('000,000,000,000,000.00', {reverse: true});
          $(document).ready(function(){

              $(".nav-tabs a").click(function (e) {
                  e.preventDefault();
                  $(this).tab('show');
              });
              $('.datatable').DataTable();
              $('#DataTables_Table_0_filter').append('<button class="btn btn-primary btn-circle btn-mn" style="margin-left: 5px" data-toggle="modal" data-target="#category-dialog"><span class="fa fa-list"></span></button>');

              prepare();
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
                  var ctx = $("#DataTables_Table_0_filter input");
                  ctx.val($("#selectedSort").text());
                  ctx.keyup();
                  $("#category-dialog").modal('hide');
              }
          });
      </script>
  <!-- end: Javascript -->
  </body>
</html>