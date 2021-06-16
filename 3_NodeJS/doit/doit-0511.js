const express = require('express')
const cookieParser = require('cookie-parser')
const app = express()

const static = require('serve-static')
const path = require('path')
const bodyParser = require('body-parser')
const { resolveNaptr } = require('dns')

app.use('/public', static(path.join(__dirname, 'public')))
app.use(bodyParser.urlencoded({extended:false}))
app.use(bodyParser.json())
app.use(cookieParser())

app.get('/process/setUserCookie',(req,res) => {
    console.log("setUserCookie 함수 호출됨")
    res.cookie('user', {
        id:'kib',
        name:'재원',
        authorized:true
    })

    res.redirect('/process/showCookie')
})

app.get('/process/showCookie' , (req,res) => {
    console.log("showCookie 함수호출됨")
    res.send(req.cookies)
})


app.get('/', (req,res) => {
    res.sendFile(__dirname+'/index.html')
})

app.listen(3000, () => {
    console.log('서버 시작됨')
})