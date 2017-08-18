// JavaScript Document
function qiehuan() {
    var xmlhttp;
    var obj = document.getElementById("city");
    var value = obj.options[obj.selectedIndex].value;
    var getdate = document.getElementById('datepicker').value;

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("shouResult").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", "ChooseSearch?city=" + value + "&date=" + getdate, true);
    xmlhttp.send();
}

function qiehuanroom() {
    var xmlhttp;
    var getdate = document.getElementById('datepicker').value;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("shouResult").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", "ChooseRoom?date=" + getdate, true);
    xmlhttp.send();
}

function setComment(obj) {
    var xmlhttp;
    var b = document.getElementsByClassName('setcomment');
    var j = 0;
    for (var i = 0; i < b.length; i++) {
        if (obj == b[i]) {
            j = i;
        }
    }
    var name = document.getElementsByClassName('getUsername').item(j).value;
    var id = document.getElementsByClassName('getOrderid').item(j).value;
    var date = getNowFormatDate();
    var comment = document.getElementsByClassName('pinglun').item(j).value;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementsByClassName("inbox_three").item(j).innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", "setcomment?date=" + date + "&comment=" + comment + "&name=" + name + "&id=" + id, true);
    xmlhttp.send();
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
