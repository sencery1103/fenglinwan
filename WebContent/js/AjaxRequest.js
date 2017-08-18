/**
 * AJAX重构
 */
var net = new Object();
//编写构造函数
net.AjaxRequest = function (url, onload, onerror, method, params) {
    this.request = null;
    this.onload = onload;
    this.onerror = (onerror) ? onerror : this.defaultError;
    this.loadDate(url, method, params);
}
