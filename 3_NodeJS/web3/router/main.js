var express = require('express');
var app = express();
var router = express.Router();
var path = require('path');     //상대경로를 이용하기 위한 path

router.get('/', (req,res) => {
    res.sendFile(path.join(__dirname, '../public/main.html'));  // 상대경로를 적용함
});

module.exports = router;