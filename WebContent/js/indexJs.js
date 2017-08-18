// JavaScript Document
var pos = 0;
var img = null;
var len = null;
var timer = null;

function aa() {
    img = document.getElementsByClassName('qiehuan');
    len = img.length;
    timer = setInterval(function () {
        dong()
    }, 2000);
}

function qiehuan(i) {
    for (var j = 0; j < len; j++) {
        img[j].style.display = 'none';
    }
    img[--i].style.display = 'inline';
}

function dong() {
    img[pos].style.display = 'none';
    pos = ++pos == len ? 0 : pos;
    img[pos].style.display = 'inline';
}