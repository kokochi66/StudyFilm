let func = function() {
    const game_play_box = document.querySelector('.game_box .game_play_box'),
        game_diff_btn = document.querySelectorAll('.game_box .game_info_box .game_level > button'),
        game_mine_count = document.querySelector('.game_box .game_info_box .game_info .mine_count .cont'),
        game_play_time = document.querySelector('.game_box .game_info_box .game_info .play_time .cont'),
        game_record_box = document.querySelectorAll('.game_mypage .my_record .record_box > .cont'),
        game_ranking = document.querySelector('.game_ranking .game_ranking_numberbox');
    myRecord_setting(game_record_box)
    let EIndex;
    let game_pannel;
    let win_Count = 0;
    let bgpRootY, bgpRootX, bgpRound;
    let arr = [];
    let timer, timeset = [];
    const gameStartEvent = (e) => {
        EIndex = find_nodeIndex(e.target)
        rankRecord_setting(game_ranking, EIndex)
        let col = EIndex === 0 ? 10 : EIndex === 1 ? 18 : 25;
        let row = col;
        let diff = EIndex === 0 ? 'easy' : EIndex === 1 ? 'normal' : 'hard';
        let mine = EIndex === 0 ? 20 : EIndex === 1 ? 60 : 120;
        timeset = [0,0]
        game_play_time.innerHTML = '00 : 00'
        clearInterval(timer)
        timer = setInterval(() => {
            addTime(timeset)
        }, 1000);
        
        bgpRootY = EIndex === 0 ? -178.718 : EIndex === 1 ? -100 : -70.3;
        bgpRootX = 0;
        bgpRound = EIndex === 0 ? 3.6 : EIndex === 1 ? 2 : 1.427;
        win_Count = (row * col) - mine;
        game_mine_count.innerHTML = mine;
        arr = []
        for(let i=0;i<col;i++) {
            arr[i] = []
            for(let j=0;j<col;j++) arr[i][j] = 0;
        } // 배열 초기화
        game_play_box.classList.remove('easy', 'normal', 'hard')
        game_play_box.classList.add(diff)
        boxclear(game_play_box)
        boxSetting(col,col)
        game_pannel = document.querySelectorAll('.row_set .pannel')

        let minePoint = []
        let checking = []
        for(let i=0;i<row*col;i++) checking[i] = i
        random_mine(minePoint, checking, mine)
        for(let i=0;i<mine;i++) {
            let c = Math.floor(minePoint[i] / row)
            let r = minePoint[i] % row
            arr[c][r] = -1
            box_mineNumberSetting(c,r,arr)
        }
        // 지뢰찾기 맵 전체 배치를 arr에 적용한다

        let maxZero_set = maxZero()
        game_pannel[col * maxZero_set[0] + maxZero_set[1]].classList.add('first')
        

        game_pannel.forEach(elem => {
            elem.addEventListener('mousedown', panneldown)
            elem.addEventListener('mouseleave', pannelup)
            elem.addEventListener('click', pannelClick)
            elem.addEventListener('contextmenu', pannelCheck)
        })

    }
    const panneldown = (e) => {
        if(e.button === 0) e.target.classList.add('active')
    }
    const pannelup = (e) => {
        e.target.classList.remove('active')
    }
    const pannelClick = (e) => {
        if(e.target.classList.contains('flag')) return;
        if(e.target.classList.contains('first')) {
            e.target.classList.remove('first')
        }
        let c = find_nodeIndex(e.target.parentElement)
        let r = find_nodeIndex(e.target)
        if(arr[c][r] === 0) find_BFS(c,r)
        else {
            pannel_bgp_setting(e.target, num_class(arr[c][r]))
            win_Count--
            if(arr[c][r] !== -1) arr[c][r] = -2;
        }
        removeEvent(e.target)
        e.target.removeEventListener('click', pannelClick)
        if(arr[c][r] === -1) { // 패배
            console.log('패배하였습니다.')
            game_set(c,r)
            clearInterval(timer)
        } else if(win_Count === 0) { // 승리
            console.log("승리하였습니다. ", EIndex)
            game_set(-1, -1)
            clearInterval(timer)
            addGameRecord(timeset, EIndex)
            rankRecord_setting(game_ranking , EIndex)
            myRecord_setting(game_record_box)
        }
    }
    const pannelCheck = (e) => {
        e.preventDefault()
        if(e.target.classList.contains('first')) return;
        if(e.target.classList.contains('flag')) {
            e.target.classList.remove('flag')
            game_mine_count.innerHTML = Number(game_mine_count.innerHTML) + 1
            pannel_bgp_setting(e.target, 3)
            e.target.classList.add('ques')
        } else if(e.target.classList.contains('ques')) {
            e.target.classList.remove('ques')
            pannel_bgp_setting(e.target, 0)
        } else {
            game_mine_count.innerHTML = Number(game_mine_count.innerHTML) - 1
            e.target.classList.add('flag')
            pannel_bgp_setting(e.target, 2)
        }
    }
    function boxSetting(col, row) {
        for(let i = 0 ; i < col ; i++) {
            let set = document.createElement('div')
            set.classList.add('row_set')

            for(let j = 0 ; j < row ; j ++) {
            let pannel = document.createElement('div')
            pannel.classList.add('pannel')
            set.append(pannel)
            }
            game_play_box.append(set)
        }
    }
    function find_nodeIndex(elem) {
        let idx = 0
        while((elem = elem.previousElementSibling) != null) {
            idx++
        }
        return idx
    }
    function random_mine(minePoint, checking, mine) {
        if(mine == 0) return;
        let num = randomNum(0, checking.length-1)
        minePoint.push(checking.splice(num,1))
        random_mine(minePoint, checking, mine-1)
    }
    function randomNum(low,up) {
        return Math.floor(Math.random() * (up - low + 1)) + low
    }
    function box_mineNumberSetting(h, w, MineArr) {
    for(let i=-1;i<=1;i++) {
        for(let j=-1;j<=1;j++) {
        if(h+i >= 0 && h+i < MineArr.length &&
            w+j >= 0 && w+j < MineArr.length &&
            MineArr[h+i][w+j] != -1) {
            MineArr[h+i][w+j]++
            }
        }
    }
    }
    function num_class(num) {
        let str = 0
        if(num === 1) str = 8
        else if(num === 2) str = 9
        else if(num === 3) str = 10
        else if(num === 4) str = 11
        else if(num === 5) str = 12
        else if(num === 6) str = 13
        else if(num === 7) str = 14
        else if(num === 8) str = 15
        else if(num === 0) str = 1
        else if(num === -1) str = 6
        return str
    }
    function find_BFS(h, w) {
        if(!(h>=0&& h<arr.length&&w>=0&&w<arr[0].length) || arr[h][w] < 0) return;
        pannel_bgp_setting(game_pannel[(h*arr[0].length) + w], num_class(arr[h][w]))
        removeEvent(game_pannel[(h*arr[0].length) + w])
        win_Count--
        if(arr[h][w] > 0) {
            arr[h][w] = -2;
            return;
        }
        arr[h][w] = -2;
        find_BFS(h+1, w+1)
        find_BFS(h+1, w)
        find_BFS(h+1, w-1)
        find_BFS(h-1, w+1)
        find_BFS(h-1, w)
        find_BFS(h-1, w-1)
        find_BFS(h, w+1)
        find_BFS(h, w-1)
    }
    function game_set(h, w) {
        for(let i=0;i<arr.length;i++) {
            for(let j=0;j<arr[0].length;j++) {
                let target_pan = game_pannel[(i*arr[0].length) + j];
            if(!(i == h && j == w) && arr[i][j] == -1) {
                pannel_bgp_setting(target_pan, 5)
            } else if(target_pan.classList.contains('flag')) {
                pannel_bgp_setting(target_pan, 7)
            }
            removeEvent(target_pan)
            }
        }
        GameStart = false;
    }
    function removeEvent(target) {
        target.removeEventListener('mousedown', panneldown)
        target.removeEventListener('mouseleave', pannelup)
        target.removeEventListener('click', pannelClick)
        target.removeEventListener('contextmenu', pannelCheck)
    }
    function pannel_bgp_setting(elem, pan) {
    elem.style.backgroundPosition = `${bgpRootX - (16.5 * (bgpRound * (pan%8)))}px ${bgpRootY - (16 * (bgpRound * Math.floor(pan/8)))}px`
    }
    function addTime(timeset) {
        timeset[0] = timeset[1] + 1 >= 60 ? timeset[0] + 1 : timeset[0];
        timeset[1] = timeset[1] + 1 >= 60 ? 0 : timeset[1] + 1;
        game_play_time.innerHTML = `${timeset[0] < 10 ? '0'+timeset[0] : timeset[0]} : ${timeset[1] < 10 ? '0'+timeset[1] : timeset[1]}`;
    }
    function maxZero() {
        let curx = 0, cury = 0, maxValue = 0;
        let checkTrue = [];
        for(let i=0;i<arr.length;i++) {
            checkTrue[i] = [];
            for(let j=0;j<arr[0].length;j++) {
                checkTrue[i][j] = false;
            }
        }
        for(let i=0;i<arr.length;i++) {
            for(let j=0;j<arr[0].length;j++) {
                if(arr[i][j] === 0 && checkTrue[i][j] === false) {
                    let cBFS_res = maxZero_BFS(i,j,checkTrue)
                    if(maxValue < cBFS_res) {
                        maxValue = cBFS_res;
                        curx = j;
                        cury = i;
                    }
                } else if(checkTrue[i][j] === false) checkTrue[i][j] = true;
            }
        }
        return [cury, curx]
    }
    function maxZero_BFS(h, w, checkTrue) {
        if(h < 0 || h >= arr.length || w < 0 || w >= arr[0].length
            || checkTrue[h][w] === true || arr[h][w] != 0) return 0;
        checkTrue[h][w] = true;
        let sumValue = 1;
        sumValue += maxZero_BFS(h+1, w, checkTrue)
        sumValue += maxZero_BFS(h-1, w, checkTrue)
        sumValue += maxZero_BFS(h, w+1, checkTrue)
        sumValue += maxZero_BFS(h, w-1, checkTrue)
        return sumValue;
    }
    function addGameRecord(TimeSet, level) {
        let record = `00:${TimeSet[0] < 10 ? '0'+TimeSet[0] : TimeSet[0]}:${TimeSet[1] < 10 ? '0'+TimeSet[1] : TimeSet[1]}`
        //Ajax POST Method TEST
        $.ajax({
            url: `/game/${gameName}/record`,
            dataType: 'json',
            type: 'POST',
            data: {rec:record, level:level},
            success: (result) => {
                if (result) {
                } 
            },
            error: (xhr, status) => {
                alert(xhr +" : "+status)
            }
        });
    }

    game_diff_btn.forEach(elem => {elem.addEventListener('click', gameStartEvent)})
}
func()