const express =require('express')
const app = express()
const server = require('http').createServer(app)
const fs = require('fs')

app.get('/', (req,res) => {
    res.sendFile(__dirname+"/room.html")
})

server.listen(3000, () => {
    console.log('Socket IO server start')
})

const io = require('socket.io')(server);
io.sockets.on('connection', (socket) => {
    socket.on('SendChat', (data) => {
        console.log('전달된 데이터 =  ', data)
        io.to(data.Room).emit('ChatResult', data);
    })

    socket.on('SettingChannel', (data) => {
        console.log('채널 설정 ' , data);
        socket.join(data.Room)
    })
})