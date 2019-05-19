$(function () {

    $("#comment-form-btn").click(function () {
        $(this).button('loading');

        $("#comment-form").ajaxSubmit({
            // target: '#comment-post',
            url: '/comment/' + blogId,
            type: 'POST',
            // dataType: 'json',//返回数据是json配置
            // cleanFrom: true,
            resetForm: true,
            success: function () {
                // console.log('success')
            },
            error: function (error) {
                console.log('error');
                console.log(error)
            }
        });
        $(this).button('reset');
        return false;
    });
});