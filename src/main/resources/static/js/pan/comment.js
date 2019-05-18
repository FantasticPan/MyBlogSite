// $.extend({
//
//     init: function (options) {
//         var $box = $('#comment-box');
//         if (!$box || !$box[0]) {
//             return;
//         }
//         var op = $.extend({
//         }, options);
//         var commentBox = '<div id="comment-place">'
//             + '<div class="comment-post" id="comment-post" style="position: relative">'
//             + '<h5 class="custom-title"><i class="fa fa-commenting-o fa-fw icon"></i><strong>评论</strong><small></small></h5>'
//             + '<form class="form-horizontal" role="form" id="comment-form">'
//             + '<div class="cancel-reply" id="cancel-reply" style="display: none;"><a href="javascript:void(0);" onclick="$.comment.cancelReply(this)" rel="external nofollow"><i class="fa fa-share"></i>取消回复</a></div>'
//             + '<input type="hidden" name="pid" id="comment-pid" value="0" size="22" tabindex="1">'
//             + '<textarea id="comment_content" class="form-control col-md-7 col-xs-12 valid" style="display: none"></textarea>'
//             + '<textarea name="content" style="display: none"></textarea>'
//             + '<div style="position: absolute;right: 10px;bottom: 70px;font-size: 14px;color: #dbdada;z-index: 1;">' + op.wmName + '<br>' + op.wmUrl + '<br>' + op.wmDesc + '</div>'
//             + '<a id="comment-form-btn" type="button" data-loading-text="正在提交评论..." class="btn btn-default btn-block">提交评论</a>'
//             + '</form></div></div>';
//         $box.html(commentBox);
//         // 初始化并缓存常用的dom元素
//         $.comment.initDom();
//         // 创建编辑框
//         this._simplemde = $.comment.createEdit(op);
//         $.comment.loadCommentList($box);
//         $.comment.initValidatorPlugin();
//     }
// });

$(function () {

    init();

    function init() {
        // var $box = $("#comment-box");
        // if (!$box || !$box[0]) {
        //     return;
        // }
        // var op = $.extend({
        // }, options);
        var commentBox = '<div id="comment-place">'
            + '<div class="comment-post" id="comment-post" style="position: relative">'
            + '<h5 class="custom-title"><i class="fa fa-commenting-o fa-fw icon"></i><strong>评论</strong><small></small></h5>'
            + '<form class="form-horizontal" role="form" id="comment-form">'
            + '<div class="cancel-reply" id="cancel-reply" style="display: none;"><a href="javascript:void(0);" onclick="$.comment.cancelReply(this)" rel="external nofollow"><i class="fa fa-share"></i>取消回复</a></div>'
            + '<input type="hidden" name="pid" id="comment-pid" value="0" size="22" tabindex="1">'
            + '<textarea id="comment_content" class="form-control col-md-7 col-xs-12 valid" style="display: none"></textarea>'
            + '<textarea name="content" style="display: none"></textarea>'
            + '<div style="position: absolute;right: 10px;bottom: 70px;font-size: 14px;color: #dbdada;z-index: 1;">' + op.wmName + '<br>' + op.wmUrl + '<br>' + op.wmDesc + '</div>'
            + '<a id="comment-form-btn" type="button" data-loading-text="正在提交评论..." class="btn btn-default btn-block">提交评论</a>'
            + '</form></div></div>';

        $("#comment-box").html(commentBox);
        // 初始化并缓存常用的dom元素
        // $.comment.initDom();
        // // 创建编辑框
        // this._simplemde = $.comment.createEdit(op);
        // $.comment.loadCommentList($box);
        // $.comment.initValidatorPlugin();
    }
});