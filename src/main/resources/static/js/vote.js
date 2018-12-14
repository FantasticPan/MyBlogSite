/**
 * 点赞的js
 * Created by FantasticPan on 2018/12/10.
 */
$(function () {

    getVoteSize();

    $("#submitVote").click(function () {
        submiteVote();
    });

    function submiteVote() {

        $(document).ajaxStart(function () {
            $("#loading").show();
        }).ajaxStop(function () {
            $("#loading").hide();
        });

        $.ajax({
            type: "GET",
            url: submitVoteUrl,
            dataType: "json",
            success: function (data) {
                // console.log('数据请求成功：' + data);
                $(".count").html(data);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

    function getVoteSize() {
        // $.ajax({
        //     type: "GET",
        //     url: "/vote/" + blogId,
        //     dataType: "json",
        //     success: function (data) {
        //         // console.log('点赞数据请求成功：' + data);
        //         $(".count").html(data);
        //     },
        //     error: function (error) {
        //         console.log(error);
        //     }
        // });
        $.get("/vote/" + blogId, {}, function (data) {
            // console.log("get请求数据成功：" + data)
            $(".count").html(data);
        });
    }
});