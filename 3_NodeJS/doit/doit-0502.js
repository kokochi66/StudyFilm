const express = require('express')
const app = express()
const http = require('http')

app.set('port', process.env.PORT || 3000)

app.use((req,res,next) => {
    console.log('첫번째 미들웨어 호출')
    req.user = 'kokochi'
    next()
})

app.use((req,res,next) => {
    console.log('두번째 미들웨어 호출')
    res.sendFile(__dirname + '/index.html')
})

const server = http.createServer(app).listen(app.get('port'), () => {
    console.log('익스프레스로 웹 서버 실행')
})
