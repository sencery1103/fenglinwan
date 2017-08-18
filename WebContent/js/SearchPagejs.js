// JavaScript Document
function getdate(obj) {
    var j = 0;
    var o = document.getElementsByClassName('shishi');
    for (var i = 0; i < o.length; i++) {
        if (obj == o[i]) {
            j = i;
        }
    }
    var a = document.getElementsByClassName('choosedate').item(j);
    var getdate = document.getElementById('datepicker').value;
    a.value = getdate;
}
