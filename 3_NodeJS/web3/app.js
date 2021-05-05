var express = require('express');
var bodyParser = require('body-parser');
var app = express();

var root = require('./router/index');  // 라우팅 메인

app.use(express.static('public'));    // 퍼블릭 폴더 정의
app.use(bodyParser.json());           // json 파일 파싱
app.use(bodyParser.urlencoded({extended:false})); // 인코딩 파싱
app.use(root);               // 인덱스 라우팅

app.set('view engine', 'ejs');

app.listen(3000, () => {
  console.log('server start for 3000');
});

