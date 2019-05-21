$(function () {

    getComments();

    $("#comment-form-btn").click(function () {

        $(this).button('loading');

        var content = document.getElementById("comment_content").value;
        console.log("获取评论内容"+ content);
        if (content == '') {
            alert('内容为空，评论失败');
            return;
        }

        $("#comment-form").ajaxSubmit({
            // target: '#comment-post',
            url: '/comment/' + blogId,
            type: 'POST',
            // dataType: 'json',//返回数据是json配置
            // cleanFrom: true,
            resetForm: true,
            success: function () {
                // console.log('success')
                alert('评论成功');
            },
            error: function (error) {
                console.log('error');
                console.log(error)
            }
        });

        $(this).button('reset');
        getComments();

        return false;
    });

    function getComments() {
        $.ajax({
            type: "GET",
            url: "/getComments/" + blogId,
            dataType: "json",
            success: function (data) {
                // console.log("请求评论数据成功：" + data);
                for (var i in data) {
                    var comment = $('<li>' +
                        '<div class="comment-body fade-in" id="comment-48">' +
                        '<div class="cheader">' +
                        '<div class="user-info">' +
                        '<div class="nickname">' +
                        '<a target="_blank" href="https://www.zhyd.me/" rel="external nofollow"><strong>' + 'ggggggggggg' +
                        '</strong></a>'+
                        '</div>'+
                        '<div class="timer"> <i class="fa fa-clock-o fa-fw"></i>' + data[i].commentDate +
                        '</div></div></div>' +
                        '<div class="content">' +
                        '<div><p>' + data[i].commentContent +
                        '</p></div></div>' +
                        '<div class="sign">' +
                        '<a href="javascript:void(0);" class="comment-up" onclick="commentVote(' + data[i].id + ', this)"><i class="fa fa-thumbs-o-up"></i>赞(<span class="count">' + data[i].voteSize + '</span>)<i class="sepa"></i></a>'+
                        '<a href="javascript:void(0);" class="comment-down" onclick="commentStep(' + data[i].id + ', this)"><i class="fa fa-thumbs-o-down"></i>踩(<span class="count">' + data[i].stepSize + '</span>)<i class="sepa"></i></a>'+
                        // '<a href="javascript:void(0);" class="comment-reply" onclick="$.comment.reply('+ data[i].id +', this)"><i class="fa fa-reply"></i>回复</a>'+
                        '</div></div></li>');

                    $(".comment").append(comment);
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
});

function commentVote(commentId, target) {
    $.ajax({
        type: "POST",
        url: "/commentVote/" + commentId,
        // dataType: "json",
        success: function (data) {
            // console.log('点赞数据请求成功：' + data);
            var oldCount = $(target).find('span.count').text();
            $(target).find('span.count').text(parseInt(oldCount) + 1);
        },
        error: function (error) {
            console.log(error);
        }
    });

}

function commentStep(commentId, target) {
    $.ajax({
        type: "GET",
        url: "/commentStep/" + commentId,
        dataType: "json",
        success: function (data) {
            // console.log('点赞数据请求成功：' + data);
            $(".count").html(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
}