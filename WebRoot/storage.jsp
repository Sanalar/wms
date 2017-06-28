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

          <!-- modal -->
          <div class="modal fade" id="select-warehouse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                  <form class="modal-content" action="storage.html" method="get">
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

          <!-- start: content -->
          <div id="content">
              <div class="tabs-wrapper text-center">
                  <div class="panel box-shadow-none text-left content-header">
                      <div class="panel-body" style="padding-bottom:0px;">
                          <div class="col-md-12">
                              <h3 class="animated fadeInLeft"><a class="text-primary" href="#" id="select-warehouse-bt">北京海淀仓库</a> 库存信息</h3>
                              <p class="animated fadeInDown">
                                  仓库管理系统 <span class="fa-angle-right fa"></span> 库存查询
                              </p>
                          </div>
                          <ul id="tabs-demo" class="nav nav-tabs content-header-tab" role="tablist" style="padding-top:10px;">
                              <li role="presentation" class="active">
                                  <a href="#storage-info" id="tabs1" data-toggle="tab">库存摘要</a>
                              </li>
                              <li role="presentation" class="">
                                  <a href="#storage-position" id="tabs2" data-toggle="tab">库位信息</a>
                              </li>
                              <li role="presentation" class="">
                                  <a href="#storage-details" id="tabs3" data-toggle="tab">库存信息</a>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <div class="col-md-12 tab-content">
                      <div role="tabpanel" class="tab-pane fade active in" id="storage-info" aria-labelledby="tabs1">
                        <div class="col-md-12">
                            <div class="row">
                                    <div class="col-md-6">
                                        <div class="panel">
                                            <div class="panel-heading bg-white border-none" style="padding:20px;">
                                                <div class="col-md-12 col-sm-12 col-sm-12 text-left">
                                                    <h4>库位容量统计</h4>
                                                </div>
                                            </div>
                                            <div class="panel-body" style="padding-bottom:50px;">
                                                <div id="canvas-holder1">
                                                    <canvas class="polar-chart" style="margin-top:30px;height:200px;"></canvas>
                                                </div>
                                                <div class="col-md-12" style="padding-top:20px;">
                                                    <div class="col-md-4 col-sm-4 col-xs-6 text-center">
                                                        <h2 style="line-height:.4;">10,086</h2>
                                                        <small>总库位数</small>
                                                    </div>
                                                    <div class="col-md-4 col-sm-4 col-xs-6 text-center">
                                                        <h2 style="line-height:.4;">9,793</h2>
                                                        <small>已使用库位数</small>
                                                    </div>
                                                    <div class="col-md-4 col-sm-4 col-xs-12 text-center">
                                                        <h2 style="line-height:.4;">88,888</h2>
                                                        <small>剩余库位数</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="panel">
                                            <div class="panel-heading bg-white border-none" style="padding:20px;">
                                                <div class="col-md-12 col-sm-12 col-sm-12 text-left">
                                                    <h4>产品分类统计</h4>
                                                </div>
                                            </div>
                                            <div class="panel-body" style="padding-bottom:50px;">
                                                <div id="canvas-holder2">
                                                    <canvas class="doughnut-chart" style="margin-top:30px;height:200px;"></canvas>
                                                </div>
                                                <div class="col-md-12" style="padding-top:20px;">
                                                    <div class="col-md-4 col-sm-4 col-xs-6 text-center">
                                                        <h2 style="line-height:.4;">10,086</h2>
                                                        <small>产品总数</small>
                                                    </div>
                                                    <div class="col-md-4 col-sm-4 col-xs-6 text-center">
                                                        <h2 style="line-height:.4;">12</h2>
                                                        <small>产品种类数</small>
                                                    </div>
                                                    <div class="col-md-4 col-sm-4 col-xs-12 text-center">
                                                        <h2 style="line-height:.4;">65.6%</h2>
                                                        <small>库位占用率</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                            </div>
                        </div>
                      </div>
                      <div role="tabpanel" class="tab-pane fade" id="storage-position" aria-labelledby="tabs2">
                          <div class="col-md-12 panel-info">
                              <div class="panel-heading">
                                  <h4 class="panel-title text-white">
                                      库位信息
                                  </h4>
                              </div>
                              <div class="panel panel-default">
                                  <div class="responsive-table" style="padding: 15px;">
                                      <table class="datatable table table-striped table-bordered" width="100%" cellspacing="0">
                                          <thead>
                                          <tr>
                                              <th>序号</th>
                                              <th>库位名称</th>
                                              <th>库位容量</th>
                                              <th>库位使用量</th>
                                              <th>库位贮存条件</th>
                                              <th>负责人</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
                                          <tr>
                                              <td>1</td>
                                              <td>D12</td>
                                              <td>1000</td>
                                              <td>354</td>
                                              <td>干燥，通风</td>
                                              <td>郝爱国</td>
                                          </tr>
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
                                      库存详情
                                  </h4>
                              </div>
                              <div class="panel panel-default">
                                  <div class="responsive-table" style="padding: 15px;">
                                      <table class="datatable table table-striped table-bordered" width="100%" cellspacing="0">
                                          <thead>
                                          <tr>
                                              <th>产品名称</th>
                                              <th>产品编号</th>
                                              <th>所在库位</th>
                                              <th>货架号</th>
                                              <th>产品分类</th>
                                              <th>库存数</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <tr>
                                              <td><a href="#">德芙巧克力</a></td>
                                              <td>dfqkl-1011</td>
                                              <td>D12</td>
                                              <td>TP-312</td>
                                              <td>食品 > 糖果/巧克力</td>
                                              <td>312</td>
                                          </tr>
                                          <tr>
                                              <td><a href="#">德芙巧克力</a></td>
                                              <td>dfqkl-1011</td>
                                              <td>D12</td>
                                              <td>TP-312</td>
                                              <td>食品 > 糖果/巧克力</td>
                                              <td>312</td>
                                          </tr>
                                          <tr>
                                              <td><a href="#">德芙巧克力</a></td>
                                              <td>dfqkl-1011</td>
                                              <td>D12</td>
                                              <td>TP-312</td>
                                              <td>食品 > 糖果/巧克力</td>
                                              <td>312</td>
                                          </tr>
                                          <tr>
                                              <td><a href="#">德芙巧克力</a></td>
                                              <td>dfqkl-1011</td>
                                              <td>D12</td>
                                              <td>TP-312</td>
                                              <td>食品 > 糖果/巧克力</td>
                                              <td>312</td>
                                          </tr>
                                          <tr>
                                              <td><a href="#">德芙巧克力</a></td>
                                              <td>dfqkl-1011</td>
                                              <td>D12</td>
                                              <td>TP-312</td>
                                              <td>食品 > 糖果/巧克力</td>
                                              <td>312</td>
                                          </tr>
                                          <tr>
                                              <td><a href="#">德芙巧克力</a></td>
                                              <td>dfqkl-1011</td>
                                              <td>D12</td>
                                              <td>TP-312</td>
                                              <td>食品 > 糖果/巧克力</td>
                                              <td>312</td>
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

      <!-- custom -->
      <script src="asset/js/main.js"></script>
      <script type="text/javascript">
          var doughnutData = [
              {
                  value: 26.3,
                  color:"#4ED18F",
                  highlight: "#15BA67",
                  label: "D12"
              },
              {
                  value: 46.7,
                  color: "#15BA67",
                  highlight: "#15BA67",
                  label: "C3"
              },
              {
                  value: 76.8,
                  color: "#5BAABF",
                  highlight: "#15BA67",
                  label: "G5"
              },
              {
                  value: 40,
                  color: "#94D7E9",
                  highlight: "#15BA67",
                  label: "A1"
              },
              {
                  value: 98.3,
                  color: "#BBE0E9",
                  highlight: "#15BA67",
                  label: "X4"
              }

          ];

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

              var ctx = $(".doughnut-chart")[0].getContext("2d");
              window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {
                  responsive : true,
                  showTooltips: true
              });

              var ctx6 = $(".polar-chart")[0].getContext("2d");
              window.myPolar = new Chart(ctx6).PolarArea(doughnutData, {
                  responsive : true,
                  showTooltips: true
              });
          });
      </script>
  <!-- end: Javascript -->
  </body>
</html>