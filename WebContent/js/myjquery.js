// JavaScript Document
$(function () {

    $("#datepicker").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: 0,
        maxDate: +2
    });
    $("#datepicker").datepicker('setDate', new Date());
});