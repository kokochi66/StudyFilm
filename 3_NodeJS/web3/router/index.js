var express = require('express');
var app = express();
var router = express.Router();
var path = require('path');     //상대경로를 이용하기 위한 path

var main = require('./main');  // 라우팅 메인
var email = require('./email');
var join = require('./join');

router.use('/main', main);               // main에 대한 라우팅을 해당 라우터로 넘김
router.use('/email', email);               
router.use('/join', join);              


router.get('/', (req,res) => {
    res.sendFile(path.join(__dirname, '../public/main.html'));
});


module.exports = router;