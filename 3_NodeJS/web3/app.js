var express = require('express');
var bodyParser = require('body-parser');
var app = express();

app.use(express.static('public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

app.set('view engine', 'ejs');

app.listen(3000, () => {
  console.log('server start for 3000');
});

app.get('/', (req,res) => {
  console.log('test');
  res.sendFile(__dirname + '/public/main.html');
});

app.get('/main', (req,res) => {
  console.log('test');
  res.sendFile(__dirname + '/public/main.html');
});

app.get('/form', (req,res) => {
  console.log('test');
  res.sendFile(__dirname + '/public/form.html');
});

app.post('/send_email', (req,res) => {
    var m = req.body.email;
    res.render('email.ejs', {'email':m});
});