const http = require('http')
const fs = require('fs')
// http를 이용한 노드 서버 만들기

const server = http.createServer()

let host = 'localhost'
let port = 3000
server.listen(port, host, 50000, () => {
    console.log('웹서버가 실행됨',port, host)
})

server.on('connection', (socket) => {
    console.log('클라이언트가 접속했습니다.')
})

server.on('request', (req,res) => {
    console.log('클라이언트 요청이 들어왔습니다.')
    // console.dir(req)
    let filename = './index.html'
    fs.readFile(filename, (err,data) => {
        res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"})
        res.write(data)
        res.end()
    })

    
})