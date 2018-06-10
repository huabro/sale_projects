function login() {
    var loginName=document.getElementById("loginName").value;
    var password=document.getElementById("password").value;
    if(!loginName){
        alert("用户名不能为空");
        return false;
    }
    else if(!password){
        alert("密码不能为空");
        return false;
    }
    else
        return true;
}
$(function () {
    var loginName=$("#loginName").val();
    if(loginName) {
        $("#loginName").blur(function () {
            $.post(ctx + "/user/verifyUser", {'loginName': $("#loginName").val()}, function (result) {
                $("#msg")[0].innerText = result.msg;
            });
        });
    }
});