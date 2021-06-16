const express = require('express')
const app = express()
const http = require('http')
const static = require('serve-static') // static 미들웨어 : 특정 폴더의 파일들을 특정 패스로 접근할 수 있도록 열어주는 역할을 함
const path = require('path')
const bodyParser = require('body-parser')

app.set('port', process.env.PORT || 3000)
app.use(static(path.join(__dirname, 'public'))) // 경로를 지정함으로써, 지정된 static 폴더를 공개하는 역할을 해준다.
app.use(bodyParser.urlencoded({extended:false}))
app.use(bodyParser.json())
// body라는 영역안에 들어가는 값들을 처리할 수 있는 외장모듈을 설정한다.

const router = express.Router()
router.route('/process/login').post((req,res) => {
    console.log('/process/login 라우팅 함수에서 받음')

    let paramName = req.params.name
    let paramId = req.body.id || req.query.id
    let paramPassword = req.body.password || req.query.password

    res.writeHead(200, {"Content-Type":"text/html;charset=utf8"})
    res.write('<h1>서버에서 로그인 응답</h1>')
    res.write(`<div> <p> ${paramId}  </p> </div>`)
    res.write(`<div> <p> ${paramName}  </p> </div>`)
    res.write(`<div> <p> ${paramPassword}  </p> </div>`)
    res.end()
})

app.use('/', router)

app.get('/', (req,res,next) => {
    console.log('첫번째 미들웨어 호출')
    let userAgent = req.header('User-Agent')
    let paramName = req.query.name || req.body.name

    console.log(paramName)
    res.sendFile(__dirname+"/index.html")
})

app.post('/' , (req,res) => {
    let Id = req.body.Id || ''
    let Password = req.body.password
    console.log(`id = ${Id} , Password = ${Password}`)
    res.sendFile(__dirname+"/index.html")
})

app.all('*', (req,res) => {
    console.log('오류 페이지, 페이지가 존재하지않음')
    res.status(404).send("<h1> 요청한 페이지가 없습니다. 404에러 </h1>")
})





const server = http.createServer(app).listen(app.get('port'), () => {
    console.log('익스프레스로 웹 서버 실행')
})
