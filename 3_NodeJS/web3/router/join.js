var express = require('express');
var app = express();
var router = express.Router();
var path = require('path');     //상대경로를 이용하기 위한 path
var mysql = require('mysql');

var connection = mysql.createConnection({
    host     : 'localhost',
    port     : 3307,    
    user     : 'root',
    password : 'rmeka5959!',
    database : 'web3',
  }); 
connection.connect(); // db 연결

router.get('/', (req,res) => {
    res.sendFile(path.join(__dirname, '../public/join.html'));
});

router.post('/', (req,res) => {
    var sql = {'name':req.body.name, 'password':req.body.password, 'email':req.body.email};
    var query = connection.query("insert into web3.user set ?", sql ,(err,rows) => {
        if(err) throw err;
        console.log('ok, db insert');
    });
});

module.exports = router;