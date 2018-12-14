$(function () {

    getAllArticle();

    $(".child_menu li").each(function (i, val) {
        $(val).click(function () {
            $(".child_menu li").each(function (i, val) {
                $(val).removeClass("active");
            })
            $(this).addClass("active");
            $(".right_col").each(function (i, val) {
                $(val).css("display", "none");
            })
            $(".right_col").eq(i).css("display", "block");
        });
    });

    function getAllArticle() {
        $.ajax({
            type: "GET",
            url: "/admin/getAllArticle",
            dataType: "json",
            success: function (data) {
                console.log(data);
                for (var i in data) {
                    var article = $('<tr>' +
                        '<td class="articleId">' + data[i].id + '</td>' +
                        '<td>' +
                        '<a>' + data[i].title + '</a>' +
                        '<br/>' +
                        '<small>' + '发布于' + data[i].createTime + '</small>' +
                        '</td>' +
                        '<td>' +
                        '<button type="button" class="btn btn-success btn-xs">' + data[i].category + '</button>' +
                        '</td>' +
                        '<td>' +
                        '<button type="button" class="btn btn-success btn-xs">' + data[i].catalog + '</button>' +
                        '</td>' +
                        '<td>' +
                        '<button type="button" class="btn btn-success btn-xs">' + data[i].readSize + '</button>' +
                        '</td>' +
                        '<td>' +
                        '<button type="button" class="btn btn-success btn-xs">' + data[i].voteSize + '</button>' +
                        '</td>' +
                        '<td><a href="/blog/' + data[i].id + '" class="btn btn-primary btn-xs" target="_blank"><i class="fa fa-folder"></i> View</a>' +
                        '<a href="/' + authenticationName + '/blog/edit/' + data[i].id + '" class="btn btn-info btn-xs" target="_blank"><i class="fa fa-pencil"></i> Edit</a>' +
                        '<a class="btn btn-danger btn-xs btn-delete"><i class="fa fa-trash-o"></i>Delete </a></td>');

                    $("#articles").append(article);


                }
                $(".btn-delete").click(function () {
                    var articleId = $(this).parents("tr").find(".articleId").html();
                    if (confirm("确认删除？") === true) {
                        $(this).parents("tr").remove();
                        $.get("/delete/" + articleId, {}, function (data) {
                        });
                    }
                });

            },
            error: function (error) {
                console.log("错误信息：" + error);
            }
        });
    }


});