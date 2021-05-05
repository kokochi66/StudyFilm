var express = require('express');
var app = express();
var router = express.Router();
var path = require('path');     //상대경로를 이용하기 위한 path

router.get('/', (req,res) => {
    console.log('main js loaded ', req.user);
    var id = req.user;
    res.render('main.ejs', {'id':id});
});

module.exports = router;