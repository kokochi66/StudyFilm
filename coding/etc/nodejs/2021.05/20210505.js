let fs = require('fs');
var input = fs.readFileSync('dev/stdin').toString().split('\n');
var c = input[0];
var curr = 1, sum = 0;

while(c.length > 0) {
    var r = c.charAt(c.length-1);
    c = c.slice(0,-1);
    sum += curr *  Xconvert(r);
    curr *= 16;
}
console.log(sum);

function Xconvert(a) {
    var n = a.charCodeAt();
    if(n >= ('0'.charCodeAt()) && n <= ('9'.charCodeAt())) return n - '0'.charCodeAt();
    else return (n - ('A'.charCodeAt())) + 10;
}