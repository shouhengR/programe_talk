// 登出
function loginOut() {

    layer.confirm('您确定要退出登录吗？', {
        btn: ['取消', '确定'] //按钮
    }, function () {
        layer.msg('操作取消!', {
            time: 1000
        });
    }, function () {

        fetch("/user/loginOut").then((response) => {
            response.json().then((data) => {
                window.location.href = "/";
            });
        });

    });

}

// 搜索框动画.
search.onfocus = (ev) => {

    let searchPanelUL = document.getElementById('searchPanelUL');

    search.style.width = "210px";

    if (searchPanelUL) {
        searchPanelUL.innerHTML = "";
    }
    // 按键按下松开
    search.onkeyup = function (event) {

        let searchPanel = document.getElementById('searchPanel');

        if (searchPanel) {
            searchPanel.removeAttribute("hidden");
        }

        articleTitleSearch(this);

        event.stopPropagation();
    };
    // 执行搜索
    function articleTitleSearch(This) {

        let title = This.value;

        console.log(title);

        fetch("/nav/article/search?title=" + title, {
            method: "get"
        }).then((response) => {

            response.json().then((data) => {

                console.log(data);

                let template = "";

                for (let item in data) {

                    let temp = `<li>
                                <a target="_blank" href="/user/article/details?uid=${data[item]["uid"]}&aid=${data[item]["id"]}">${data[item]["title"]}</a>
                            </li>`;

                    template += temp;
                }
                searchPanelUL.innerHTML = template;
            });

        });

    }

};
search.onblur = (ev) => {

    search.style.width = "180px";
    search.onkeyup = null;
};

document.onclick = ()=>{
    let searchPanel = document.getElementById('searchPanel');
    if (searchPanel){
        searchPanel.setAttribute("hidden","hidden");
    }
};

// 登录过后 页面的 后台管理按钮
let backMake = document.getElementById('backMake');

if (backMake) {

    backMake.onclick = function () {
        // 进入后台管理 需判断是否是管理员  否则进入用户的后台
        goBack(this.dataset.username);
    }
}

function goBack(name) {

    fetch("/user/check"
        , {
            method: "get"
        }).then((response) => {
        response.json().then((data) => {

            console.log(data);

            if (!data.flage){

                layer.alert(data.msg, {
                    icon: 2,
                    time: 3000
                });
            }else {
                if (name == 'admin')
                    window.location.href="/admin/";
                else
                    window.location.href="/user/";
            }
        });
    });

}

// 点击导航栏的中的搜索后
function goSearch(form){
    let value =  form["search"].value;
    window.open("/search/result?title="+value);
    // window.location.href =
}

// 导航条动画
window.onscroll = function (e) {

    let top = document.documentElement.scrollTop;

    if (top-40 >= 0) {

        main_nav_two.style.position = "fixed";
        main_nav_two.style.top = "0";
        main_nav_two.style.right = "0";
        main_nav_two.style.left = "0";
        main_nav_two.style.zIndex = "2";

        main_nav_two.style.backgroundColor="#393d49";
        main_nav_two_ul.style.backgroundColor="#393d49";

        [...main_nav_two_ul.children].slice(0,6).forEach((item)=>{
            item.children[0].style.color = "#ffffff";
        });

        searchBtn.style.border = "none";


        searchPanel.style.position = "fixed";
        searchPanel.style.top="60px";
        searchPanel.style.left = "1295px";

    } else {
        main_nav_two.style.position = "relative";
        main_nav_two.style.top = "0";

        main_nav_two.style.backgroundColor="#ffffff";
        main_nav_two_ul.style.backgroundColor="#ffffff";

        searchBtn.style.border = "1px solid #ffff;";

        [...main_nav_two_ul.children].slice(0,6).forEach((item)=>{
            item.children[0].style.color = "#333";
        });

        searchPanel.style.position = "fixed";
        searchPanel.style.top="110px";
        searchPanel.style.left = "1293px";
    }
};