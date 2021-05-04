var express = require('express');
var bodyParser = require('body-parser');
var app = express();
app.locals.pretty = true;   // jada파일의 표시를 깔끔하게 해줌

app.set('view engine', 'jade'); // jdae를 사용하는것을 설정함
app.set('views', './views');  // jade파일의 경로를 설정함.

app.use(express.static('public'));
app.use(bodyParser.urlencoded({extended:false}));


var cont = ['JavaScript', 'Jade', 'NodeJS'];
app.get('/topic', (req,res) => {
  var id = req.query.id;
  var temp = `
    <a href="/topic?id=0">JavaScript</a><br>
    <a href="/topic?id=1">Jade</a><br>
    <a href="/topic?id=2">NodeJS</a><br>
    <h1>${cont[id]}</h1>
  `;
  res.send(temp);
}); // 쿼리 스트링을 적용하여 동적 페이지 만들기 (Non-semantic URL)

app.get('/semantic/:id/:name', (req,res) => {
  var temp = `
    <a href="/semantic/0/JavaScript">JavaScript</a><br>
    <a href="/semantic/1/Jade"/>Jade</a><br>
    <a href="/semantic/2/NodeJS">NodeJS</a><br>
    <h1>${req.params.id} :: ${req.params.name}</h1>
  `;
  res.send(temp);
}); // Semantic형식으로 주소를 가져오도록 하기

app.get('/template', (req,res) => {
  res.render('temp', {time:Date(), _title:'Jade'});
}); // jada파일을 불러오도록 하는 함수를 이용

app.get('/', function(req, res) {
  res.send('hello world');
}); // get방식의 기본주소

app.get('/form' , (req, res) => {
  res.render('form');
});
app.post('/form_receiver' , (req,res) => {
  console.log('Post Linked');
  var title = req.body.title;
  var desc = req.body.desc;
  var temp = `
    <h1>${title}</h1>
    <p>${desc}</p>
  `;
  res.send(temp);
}); // form 태그에서 post로 값을 가져오는 페이지
app.get('/form_receiver' , (req,res) => {
  console.log("Get Linked");
  var title = req.query.title;
  var desc = req.query.desc;
  var temp = `
    <h1>${title}</h1>
    <p>${desc}</p>
  `;
  res.send(temp);
}); // form 태그에서 값을 가져와서 queryString을 읽어내는 페이지


app.listen(3000, () => {
  console.log('Connected 3000 port');
});
