const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const multer = require('multer')
const fs = require('fs')
const form_data = multer()


app.listen(3000, () => {
    console.log('3000port connect');
});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));


app.get('/upload', (req,res) => {
    console.log('upload get');
})

app.post('/upload', (req,res) => {
    console.log('post connect')
    res.send(req.body)
})



function base64_encode(file) {
    var bitmap = fs.readFileSync(file)
    return new Buffer(bitmap).toString('base64');
}

function base64_decode(base64str, file) {
    var bitmap = new Buffer(base64str, 'base64')
    fs.writeFileSync(file, bitmap);
    console.log('파일 쓰기 성공')
}