const express = require('express')
const http = require('http')
const app = express()

const server = http.createServer(app)
server.listen(3000)

app.get('/', (req,res) => {
    res.sendFile(__dirname + '/client.html')
})

const io = require('socket.io')(server)

io.on('connect', (socket) => {
    console.log('클라이언트 접속')

    socket.on('disconnect', () => {
        console.log('클라이언트 접속 종료')
    })

    setInterval(() => {
        socket.emit('message', '메시지');
    }, 3000)
})


/*
    이벤트 기반의 메세지 주고받기
    이벤트를 발생시키는 부분 => socket.emit()
    socket.emit('EVENT', data)

    socket.on() => 이벤트 리스너 등록 (이벤트를 받는 부분)
    socket.on('EVENT', (data) => {})
    이벤트를 이용해서 데이터를 주고받을 수 있음

    socket.io.emit() 을 사용하면 연결된 모든 소켓에 이벤트를 발생시킨다.


    네임스페이스와 룸
        socket.io 기본 연결은 소켓과 1:1통신을 하므로, 1:N통신을 위해서는 네임스페이스와 룸을 이용해야한다.
        같은 네임스페이스끼리만 데이터를 주고받는다.
    
        var nsp = io.of('/Custom-Nmaespace') 형식으로 네임스페이스를 만든다.
        
*/