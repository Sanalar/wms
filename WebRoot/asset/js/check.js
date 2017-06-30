function showShelfDialog(idx){
    $("#shelf-for-index").val(idx);
    $("#shelf-dialog").modal('show');
}

function showAddProductDialog(idx){
    $("#product-for-index").val(idx);
    $("#choose-product").modal('show');
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
            + ' value="" name="checkItem[' + count + '].shelfName"/>'
            + '<input type="hidden" name="checkItem[' + count + '].shelfId" value="0"/>'
        + '</td>'
        + '<td>' + $("#sp-standard" + pid).text() + '</td>'
        + '<td>' + $("#sp-unit" + pid).text() + '</td>'
        + '<td><input type="text" class="form-control input-sm android" name="checkItem[' + count + '].number" value="0"></td>'
        + '<td>'
            + '<button class="btn btn-danger btn-mn btn-circle delete-item" data-index="' + count + '">'
            + '<span class="fa fa-close"></span></button>'
        + '</td>'
    + '</tr>';

    if(count == 0){
        tbody.empty();
        $(window).bind('beforeunload',function(){
            return '您输入的内容尚未保存，直接离开该页面将丢失这些信息，确定离开此页面吗？';
        });
    }
    tbody.append(appendStr);
    tbody.attr("data-count", count + 1);
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
        $("option[data-fixed]").attr("selected", true);
        $("#swForm").submit();
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

    $(".select-product").click(function (e) {
        var pid = $(this).attr("data-id");
        appndCheckItem(pid);
        $("#choose-product").modal('hide');

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
        })
    });
}

function checkSubmit(){
    $("form#")
}