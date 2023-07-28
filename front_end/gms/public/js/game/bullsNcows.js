let func = function() {
    const participant_room = (e) => {
        e.target.innerHTML = '';
        
        let inputText_box = document.createElement('input')
        inputText_box.type = 'text';
        inputText_box.maxLength = 5;
        inputText_box.className = 'inputText'
        e.target.append(inputText_box)

        let inputSubmit_box = document.createElement('div')
        inputSubmit_box.className = 'inputSubmit'
        inputSubmit_box.innerHTML = '입력'
        game_channel_partroom_submit = inputSubmit_box
        game_channel_partroom_submit.addEventListener('click', roomChannelSubmit)
        e.target.append(inputSubmit_box)
        e.target.removeEventListener('click', participant_room)
    } // 방 참가하기 클릭 시 이벤트(입력 칸 열리기)
    const roomChannelSubmit = (e) => {
        let curr_input_box = document.querySelector('.game_box .game_info_box .game_channel .game_part_room .inputText')
        let msg = { code:curr_input_box.value};
        socket.emit('partRoom', msg)
    } // 방 코드 입력 후 해당 코드값으로 채널 접속하기


    let game_play_box = document.querySelector('.game_box .game_play_box'),
        game_channel_partroom = document.querySelector('.game_box .game_info_box .game_channel .game_part_room'),
        game_channel_partroom_submit;

    game_channel_partroom.addEventListener('click', participant_room)

    

    let colorArr = ['red', 'blue', 'green', 'purple', 'white', 'yellow']

    boxSetting()
    function boxSetting() {
        let top_box = document.createElement('div')
        top_box.classList.add('top')
        let user1_box = document.createElement('div')
        let user2_box = document.createElement('div')
        user1_box.className = 'user user1'
        user2_box.className = 'user user2'
        let img1_box = document.createElement('div')
        let info1_box = document.createElement('div')
        let name1_box = document.createElement('div')
        let img2_box = document.createElement('div')
        let info2_box = document.createElement('div')
        let name2_box = document.createElement('div')
        img1_box.classList.add('img')
        info1_box.classList.add('info')
        info1_box.innerHTML = '0승 0패'
        name1_box.classList.add('name')
        name1_box.innerHTML = 'kokochi'
        img2_box.classList.add('img')
        info2_box.innerHTML = '0승 0패'
        info2_box.classList.add('info')
        name2_box.classList.add('name')
        name2_box.innerHTML = 'crec'
        user1_box.append(img1_box)
        user1_box.append(info1_box)
        user1_box.append(name1_box)
        top_box.append(user1_box)
        user2_box.append(img2_box)
        user2_box.append(info2_box)
        user2_box.append(name2_box)
        top_box.append(user2_box)
        game_play_box.append(top_box)

        let play_box = document.createElement('div')
        play_box.classList.add('play')
        for(let i=0;i<8;i++) {
            let box_box = document.createElement('div')
            box_box.classList.add('box')

            let board_box = document.createElement('div')
            board_box.classList.add('board')
            for(let i=0;i<4;i++) {
                let balld_box = document.createElement('div')
                balld_box.classList.add('balld')
                let circle_box = document.createElement('div')
                circle_box.className = 'circle empty'
                balld_box.append(circle_box)
                board_box.append(balld_box)
            }
            box_box.append(board_box)

            let pannel_box = document.createElement('div')
            pannel_box.classList.add('pannel')
            for(let i=0;i<4;i++) {
                let ball_box = document.createElement('div')
                ball_box.classList.add('ball')
                let circle_box = document.createElement('div')
                circle_box.className = 'circle empty'
                ball_box.append(circle_box)
                pannel_box.append(ball_box)
            }
            box_box.append(pannel_box)
            play_box.append(box_box)
        }
        game_play_box.append(play_box)

        let select_box = document.createElement('div')
        select_box.classList.add('select')
        for(let i=0;i<6;i++) {
            let ball_box = document.createElement('div')
            ball_box.classList.add('ball')
            let circle_box = document.createElement('div')
            circle_box.className = `circle ${colorArr[i]}`
            ball_box.appendChild(circle_box)
            select_box.appendChild(ball_box)
        }
        game_play_box.appendChild(select_box)
    }    
    
}


func()