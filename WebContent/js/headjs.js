// JavaScript Document
function qiehuanlogin() {
    var shishi = document.getElementById('shishi');
    if (shishi.innerHTML != "hello") {
        document.getElementById('rightheadtwo').style.display = "inline";
        document.getElementById('righthead').style.display = "none";
    } else {
        document.getElementById('rightheadtwo').style.display = "none";
        document.getElementById('righthead').style.display = "inline";
    }
}

$(document).ready(function () {
    $("#butt").click(function () {
        $("#secondmenu").slideToggle("fast");
    });
});