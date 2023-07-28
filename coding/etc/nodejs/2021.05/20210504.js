let fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');
var max = 0, num = 0;
for(var i = 1; i <= 5 ; i ++) {
    var c = Number(sum(input[i-1].split(' ')));
    if(max < c) {
        max = c;
        num = i;
    }
}
console.log(num+" "+max);


function sum(arr) {
    var s = 0;
    for(var i=0;i<arr.length;i++) s += Number(arr[i]);
    return s;
}
