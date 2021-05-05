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

router.get('/form', (req,res) => {
    res.sendFile(path.join(__dirname, '../public/form.html'));
  });

router.post('/send', (req,res) => {
    var m = req.body.email;
    res.render('email.ejs', {'email':m});
});

router.post('/ajax', (req,res) => {
   var email = req.body.email;
   var resData = {};
   var query = connection.query("select name from web3.user where email='" + email + "'", (err,rows) => {
     if(err) throw err;
     if(rows[0]) {
      console.log(rows[0]); 
      resData.result = 'ok';
      resData.name = rows[0].name;
     } else {
      resData.result = 'none';
      resData.name = 'undefined';
     }
     res.send(resData);
   });
});


module.exports = router;