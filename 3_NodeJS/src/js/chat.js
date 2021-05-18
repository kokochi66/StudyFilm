'use strict'

const socket = io()

const nickname = document.querySelector('#nickname'),
    chatList = document.querySelector('.chatting-list'),
    chatInput = document.querySelector('.chatting-input'),
    sendButton = document.querySelector('.send-button'),
    displayContainer = document.querySelector('.display-container');

chatInput.addEventListener('keypress', (event) => {
    if(event.keyCode === 13) {
        send()
    }
})
function send() {
    const param = {
        'name':nickname.value,
        'msg':chatInput.value
    }
    socket.emit('chatting', param);
}

sendButton.addEventListener('click', () => {
    send()
})  // 버튼 클릭 시 서버로 데이터를 오브젝트 형태로 보낸다.

socket.on('chatting', (data) => {
    const {name , msg, time} = data;
    const item = new LiModel(name, msg, time)
    item.makeLi()
    displayContainer.scrollTo(0, displayContainer.scrollHeight);
    chatInput.value = '';
})  // 서버로부터 받는 내용

console.log(socket)

function LiModel(name, msg, time) {
    this.name = name;
    this.msg = msg;
    this.time = time;

    this.makeLi = () => {
        const li = document.createElement('li')
        li.classList.add(nickname.value === this.name ? 'sent' : 'received')
        const dom = `
            <span class="profile">
                <span class="user">${this.name}</span>
                <img src="https://placeimg.com/50/50/any" alt="any" class="img">
            </span>
            <span class="message">${this.msg}</span>
            <span class="time">${this.time}</span>
        `;
        li.innerHTML = dom;
        chatList.appendChild(li)
    }
}

