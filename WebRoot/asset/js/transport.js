function initProductList(data){
    $('.datatable').dataTable().fnClearTable();
    var ctx = $("#DataTables_Table_0_filter input");
    ctx.val("");
    ctx.keyup();
    $.each(data,function(i,n){
        var pid = n["id"];
        $('.datatable').dataTable().fnAddData([
            '<div id="sp-code' + pid + '">' + n["code"] + '</div>',
            '<div id="sp-name'+pid+'" data-id="'+n["productId"]+'">' + n["name"] + '</div>',
            '<div id="sp-category' + pid + '">' + n["category"] + '</div>',
            '<div id="sp-storage' + pid + '">' + n["storage"] + '</div></td>',
            '<div id="sp-shelf'+pid+'" data-id="'+n["shelfId"]+'">' + n["shelf"] + '</div>',
            '<div id="sp-last' + pid + '">' + n["lastNum"] + '</div>',
            '<a class="select-product" data-id="' + pid + '" href="#"><span class="fa fa-check"></span> 选择</a>'
        ]);
    });
}

function showAddProductDialog(){
    $("#loading-box").modal("show");
    var wid = $("select[name='wid']").val();
    $.ajax( {
        url:'fetchTransportProductList.action',
        dataType:'json',
        type: "POST",
        data:{"warehouseId":wid},
        success: function(data, textStatus){
            initProductList(data);
            $("#loading-box").modal("hide");
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
    var productId = $("#sp-name" + pid).attr("data-id");
    var appendStr = '<tr>'
        + '<td>' + $("#sp-code" + pid).text()
        + '<input type="hidden" name="trItem[' + count + '].productId" value="' + productId + '"/>'
        + '<input type="hidden" name="trItem[' + count + '].id" value="' + pid + '"/>'
        + '</td>'
        + '<td><a href="product-details.html?id=' + productId +'">' + $("#sp-name" + pid).text() + '</a></td>'
        + '<td>' + $("#sp-category" + pid).text() + '</td>'
        + '<td>' + $("#sp-storage" + pid).text() + '</td>'
        + '<td>' + $("#sp-shelf" + pid).text()
        + '<input type="hidden" name="trItem[' + count + '].shelfId" value="' + $("#sp-shelf" + pid).attr("data-id") + '"/>'
        + '</td>'
        + '<td>' + $("#sp-last" + pid).text() + '</td>'
        + '<td><input name="trItem['+count+'].number" type="text" class="form-control input-sm android" value="" required></td>'
        + '<td><input name="trItem['+count+'].cost" type="text" class="form-control input-sm android" value="" required></td>'
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
        $("input[name='trItem[" + i + "].productId']").attr("name", "checkItem[" + (i-1) + "].productId");
        $("input[name='trItem[" + i + "].shelfId']").attr("name", "checkItem[" + (i-1) + "].shelfId");
        $("input[name='trItem[" + i + "].number']").attr("name", "checkItem[" + (i-1) + "].number");
        $("input[name='trItem[" + i + "].cost']").attr("name", "checkItem[" + (i-1) + "].cost");
        $("button[data-index='" + i + "']").attr("data-index", i-1);
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
        showAddProductDialog();
    });

    $("select[name='wid']").change(function () {
        window.location.href="new-transport.html?wid=" + $(this).val();
    });

    $("#newTransFormSubmit").click(function(e){
        e.preventDefault();
        var canSubmit = true;
        var tbody = $("#check-item-table").find("tbody");
        var count = parseInt(tbody.attr("data-count"));

        if(count == 0){
            alert("您没有可以添加可以提交的记录哦！");
            return false;
        }

        $("#newTransForm").find("input[required]").each(function(){
            if($(this).val().replace(/(^s*)|(s*$)/g, "").length == 0){
                alert("请填写所有字段之后再提交。");
                $(this).focus();
                canSubmit = false;
                return false;
            }
        });
        if(canSubmit){
            $(window).unbind('beforeunload');
            $("#newTransForm").submit();
        }
    });
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

function showTransDetails(cdid){
    $("#loading-box").modal("show");
    $.ajax( {
        url:'fetchTransportDetailList.action',
        dataType:'json',
        type: "POST",
        data: {"tid": cdid},
        success: function(data, textStatus){
            $("#cp-id").text(data['id']);
            $("#cp-from").text(data['fromHouse']);
            $("#cp-to").text(data['toHouse']);
            $("#cp-create-time").text(data['createTime']);
            $("#cp-accept-time").text(data['acceptTime']);
            $("#cp-finish-time").text(data['finishTime']);
            $("#cp-creator").text(data['creator']);
            $("#cp-acceptor").text(data['acceptor']);
            $("#cp-finisher").text(data['finisher']);
            $("#cp-desc").text(data['desc']);
            var tbody = $("#cp-items");
            tbody.empty();
            $.each(data['items'], function(i, n){
                tbody.append(
                    '<tr>' +
                    '<td>'+n['code']+'</td>' +
                    '<td>'+n['name']+'</td>' +
                    '<td>'+n['category']+'</td>' +
                    '<td>'+n['storage']+'</td>' +
                    '<td>'+n['shelf']+'</td>' +
                    '<td>'+n['lastNum']+'</td>' +
                    '<td>'+n['number']+'</td>' +
                    '<td>'+n['cost']+'</td>' +
                    '</tr>'
                );
            });
            $("#loading-box").modal("hide");
            $("#show-transport").modal("show");
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