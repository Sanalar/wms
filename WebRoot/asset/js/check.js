function getAllShelfList(shown){
	var sid = $("#storage-id").val();
	$.ajax( {  
    	url:'fetchShelfList.action',  
    	dataType:'json',
    	type: "POST",
    	data: {"storageId":sid},
    	success: function(data, textStatus){
    		var widSel = $("#shelf-id");
    		widSel.empty();
    		$.each(data,function(i,n){ 
				widSel.append('<option value="'+n["id"]+'">'+n["name"]+'</option>'); 
			}); 
    		$("#loading-box").modal("hide");
    		if(shown){
    			$("#shelf-dialog").modal('show');
    		}
    	},
    	error: function(){
    		$("#loading-box").modal("hide");
    		alert("请求货架列表失败！请检查网络设置！"); 
    	}  
		});
}

function getAllStorageList(){
	$("#loading-box").modal("show");
	var wid = $("select[name='wid']").val();
	$.ajax( {  
    	url:'fetchStorageList.action',  
    	dataType:'json',
    	type: "POST",
    	data: {"warehouseId":wid},
    	success: function(data, textStatus){
    		var widSel = $("#storage-id");
    		widSel.empty();
    		$.each(data,function(i,n){ 
				widSel.append('<option value="'+n["id"]+'">'+n["name"]+'</option>'); 
			}); 
    		$("#storage-id").unbind("change").change(function(){
    			$("#loading-box").modal("show");
    			getAllShelfList(false);
    		});
    		getAllShelfList(true);
    	},
    	error: function(){
    		$("#loading-box").modal("hide");
    		alert("请求库位列表失败！请检查网络设置！"); 
    	}  
		});
}

function showShelfDialog(idx){
    $("#shelf-for-index").val(idx);
    getAllStorageList();
}

function initProductList(data){
	$('.datatable').dataTable().fnClearTable();
	var ctx = $("#DataTables_Table_0_filter input");
    ctx.val("");
    ctx.keyup();
	$.each(data,function(i,n){ 
		var pid = n["id"];
		$('.datatable').dataTable().fnAddData([
			'<div id="sp-code' + pid + '">' + n["code"] + '</div>',
			'<div id="sp-name'+pid+'">' + n["name"] + '</div>',
			'<div id="sp-category' + pid + '">' + n["category"] + '</div>',
			'<div id="sp-standard' + pid + '">' + n["standard"] + '</div>',
			'<div id="sp-unit' + pid + '">' + n["unit"] + '</div>',
			'<a class="select-product" data-id="' + pid + '" href="#"><span class="fa fa-check"></span> 选择</a>'
			]);
	});
}

function showAddProductDialog(idx){
	$("#loading-box").modal("show");
	$.ajax( {  
    	url:'fetchBasicProductList.action',  
    	dataType:'json',
    	type: "POST",
    	success: function(data, textStatus){
    		initProductList(data);
			$("#loading-box").modal("hide");
			$("#product-for-index").val(idx);
		    $("#choose-product").modal('show');
		    $(".select-product").unbind('click').click(function (e) {
		        var pid = $(this).attr("data-id");
		        appndCheckItem(pid);
		        $("#choose-product").modal('hide');
		    });
    	},
    	error: function(){
    		$("#loading-box").modal("hide");
    		alert("请求产品列表失败！请检查网络设置！"); 
    	}  
		});
}

function appndCheckItem(pid){
    var tbody = $("#check-item-table").find("tbody");
    var count = parseInt(tbody.attr("data-count"));
    var appendStr = '<tr>'
        + '<td>' + $("#sp-code" + pid).text()
            + '<input type="hidden" name="checkItem[' + count + '].productId" value="' + pid + '"/>'
        + '</td>'
        + '<td><a href="product-details.html?id=' + pid +'">' + $("#sp-name" + pid).text() + '</a></td>'
        + '<td>' + $("#sp-category" + pid).text() + '</td>'
        + '<td data-storage="' + count + '">(未指定)</td>'
        + '<td>'
            + '<input type="text" data-index="' + count +'" class="form-control input-sm android select-shelf"'
            + ' value="" name="checkItem[' + count + '].shelfName" required/>'
            + '<input type="hidden" name="checkItem[' + count + '].shelfId" value="0"/>'
        + '</td>'
        + '<td>' + $("#sp-standard" + pid).text() + '</td>'
        + '<td>' + $("#sp-unit" + pid).text() + '</td>'
        + '<td><input type="text" onkeyup="value=value.replace(/[^\\d]/g,\'\')" class="form-control input-sm android" name="checkItem[' + count + '].number" value="0" required></td>'
        + '<td>'
            + '<button class="btn btn-danger btn-mn btn-circle delete-item" data-index="' + count + '">'
            + '<span class="fa fa-close"></span></button>'
        + '</td>'
    + '</tr>';

    if(count == 0){
        tbody.empty();
        $(window).bind('beforeunload',function(){
        	$("select[name='wid']").val($("option[data-fixed]").val());
            return '您输入的内容尚未保存，直接离开该页面将丢失这些信息，确定离开此页面吗？';
        });
    }
    tbody.append(appendStr);
    tbody.attr("data-count", count + 1);
    
    $(".select-shelf").unbind("click").click(function(e){
        showShelfDialog($(this).attr("data-index"));
    });

    $(".delete-item").unbind("click").click(function (e) {
        e.preventDefault();
        if(!confirm("您确定要删除这条记录吗？")){
            return false;
        }
        var idx = parseInt($(this).attr("data-index"));
        removeCheckItem(idx);
    });
}

function removeCheckItem(idx){
    var tbody = $("#check-item-table").find("tbody");
    var count = parseInt(tbody.attr("data-count"));
    if(idx >= count){
        return false;
    }

    for(var i=idx + 1; i < count; ++i){
        $("input[name='checkItem[" + i + "].productId']").attr("name", "checkItem[" + (i-1) + "].productId");
        $("input[name='checkItem[" + i + "].shelfName']").attr("data-index", i-1);
        $("input[name='checkItem[" + i + "].shelfName']").attr("name", "checkItem[" + (i-1) + "].shelfName");
        $("input[name='checkItem[" + i + "].shelfId']").attr("name", "checkItem[" + (i-1) + "].shelfId");
        $("input[name='checkItem[" + i + "].number']").attr("name", "checkItem[" + (i-1) + "].number");
        $("button[data-index='" + i + "']").attr("data-index", i-1);
        $("td[data-storage='" + i + "']").attr("data-storage", i-1);
    }

    tbody.children("tr:eq("+idx+")").remove();

    if(count == 1){
        tbody.append(
            '<tr><td colspan="9"><div class="text-center text-default">没有记录</div></td></tr>'
        );
        $(window).unbind('beforeunload');
    }

    tbody.attr("data-count", count - 1);
}

function prepare(){
    $("#add-product").click(function (e) {
        showAddProductDialog($(this).attr("data-index"));
    });

    $("select[name='wid']").change(function () {
        $("#swForm").submit();
    });
    
    $("#checkItemsFormSubmit").click(function(e){
    	e.preventDefault();
    	var canSubmit = true;
    	var tbody = $("#check-item-table").find("tbody");
        var count = parseInt(tbody.attr("data-count"));
        
        if(count == 0){
        	alert("您没有可以添加可以提交的记录哦！");
        	return false;
        }
        
    	$("#checkItemsForm").find("input[required]").each(function(){
    		if($(this).val().replace(/(^s*)|(s*$)/g, "").length == 0){
    			alert("请填写所有字段之后再提交。");
    			$(this).focus();
    			canSubmit = false;
    			return false;
    		}
    	});
    	if(canSubmit){
	    	$(window).unbind('beforeunload');
	    	$("#checkItemsForm").submit();
    	}
    });

    $("#ok-for-shelf-id").click(function (e) {
        var index = $("#shelf-for-index").val();
        var nameInputName = "checkItem[" + index + "].shelfName";
        var idInputName = "checkItem[" + index + "].shelfId";
        var shelfId = $("#shelf-id").val();
        var shelfName = $("#shelf-id").find("option:selected").text();
        $("input[name='" + nameInputName + "']").val(shelfName);
        $("input[name='" + idInputName + "']").val(shelfId);
        $("td[data-storage='" + index + "'").text($("#storage-id").find("option:selected").text());
        $("#shelf-dialog").modal('hide');
    });
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

function showCheckDetails(cdid){
    $("#loading-box").modal("show");
    $.ajax( {
        url:'fetchCheckDetails.action',
        dataType:'json',
        type: "POST",
        data: {"checkId": cdid},
        success: function(data, textStatus){
            $("#cd-id").text(data['id']);
            $("#cd-warehouse").text(data['warehouse']);
            $("#cd-create-time").text(data['createTime']);
            $("#cd-accept-time").text(data['acceptTime']);
            $("#cd-creator").text(data['creator']);
            $("#cd-acceptor").text(data['acceptor']);
            $("#cd-desc").text(data['desc']);
            var tbody = $("#cd-items");
            tbody.empty();
            $.each(data['items'], function(i, n){
                tbody.append(
                    '<tr>' +
                        '<td>'+n['id']+'</td>' +
                        '<td>'+n['code']+'</td>' +
                        '<td>'+n['name']+'</td>' +
                        '<td>'+n['category']+'</td>' +
                        '<td>'+n['storage']+'</td>' +
                        '<td>'+n['shelf']+'</td>' +
                        '<td>'+n['oldNumber']+'</td>' +
                        '<td>'+n['newNumber']+'</td>' +
                    '</tr>'
                );
            });
            $("#loading-box").modal("hide");
            $("#show-checks").modal("show");
        },
        error: function(){
            $("#loading-box").modal("hide");
            alert("请求盘点详情列表失败！请检查网络设置！");
        }
    });
}

function prepareForChecks(){
    $(".check-ok").click(function(e){
        e.preventDefault();
        if(!confirm("您确认要同意这一笔盘存信息吗？")){
            return false;
        }
        window.location.href = "passCheck.action?id=" + $(this).attr("data-id");
    });

    $(".check-bad").click(function(e){
        e.preventDefault();
        if(!confirm("您确认要关闭这一笔盘存信息吗？")){
            return false;
        }
        window.location.href = "abandonCheck.action?id=" + $(this).attr("data-id");
    });
}