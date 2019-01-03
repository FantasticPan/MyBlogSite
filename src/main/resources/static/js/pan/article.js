$(function () {

    getFirstArticleByReadSize();
    getSecondArticleByReadSize();
    getThirdArticleByReadSize();

    function getFirstArticleByReadSize() {
        $.ajax({
            type: "GET",
            url: "/getFirstArticleByReadSize",
            dataType: "json",
            success: function (data) {
                var article1 = $('<span class="li-icon li-icon-1">1</span>' +
                    '<a href="/blog/' + data.id + '" data-placement="bottom">' + data.title +
                    '</a>');

                $("#first").append(article1);
            },
            error: function (error) {
                console.log("错误信息：" + error);
            }
        });
    }function getSecondArticleByReadSize() {
        $.ajax({
            type: "GET",
            url: "/getSecondArticleByReadSize",
            dataType: "json",
            success: function (data) {
                var article2 = $('<span class="li-icon li-icon-2">2</span>' +
                    '<a href="/blog/' + data.id + '" data-placement="bottom">' + data.title +
                    '</a>');

                $("#second").append(article2);
            },
            error: function (error) {
                console.log("错误信息：" + error);
            }
        });
    }function getThirdArticleByReadSize() {
        $.ajax({
            type: "GET",
            url: "/getThirdArticleByReadSize",
            dataType: "json",
            success: function (data) {
                var article3 = $('<span class="li-icon li-icon-3">3</span>' +
                    '<a href="/blog/' + data.id + '" data-placement="bottom">' + data.title +
                    '</a>');

                $("#third").append(article3);
            },
            error: function (error) {
                console.log("错误信息：" + error);
            }
        });
    }
});