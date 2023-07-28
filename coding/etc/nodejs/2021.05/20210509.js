let fs = require('fs');
var cDate = new Date();
var year = cDate.getFullYear();
var mon = cDate.getMonth()+1;
var day = cDate.getDate();

console.log(`${year}-${("00"+mon.toString()).slice(-2)}-${("00"+day.toString()).slice(-2)}`);