const express = require('express')
const router = express.Router()
const mysql = require('mysql')
const fs = require('fs')
const request = require('request')



const connKey = JSON.parse(fs.readFileSync('./key/sql.json'))
const connection = mysql.createConnection({
    host     : connKey.host,
    port     : connKey.port,
    user     : connKey.user,
    password : connKey.password,
    database : connKey.database
});

router.get('/:id', (req,res) => {
    res.status(200).render('./ejs/game/game.ejs', {'game':req.params.id, 'user':req.cookies.user, 'url':`/game/${req.params.id}`})
})

router.post('/:id/record', (req,res) => {
    if(!req.cookies.user) {
        res.send({res:'fault'})
        return;
    }   // 로그인되어있지 않으면 기록되지 않음
    let playUser = req.cookies.user.userId
    let playGame = req.params.id
    let gameLevel = req.body.level
    let gameRecord = req.body.rec

    connection.query(`SELECT gameRecordValue FROM game WHERE gameName = '${playGame}'`, (err, rows, fields) => {
            // 게임의 레코드값을 먼저 가져와서 지정함
        if(err) throw err;
        if(rows.length > 0) {
            let playGameRecordValue = rows[0]['gameRecordValue']

            connection.query(`select r.recordId, r.recordUserId, r.recordGameName, r.recordGameLevel, t.recordCont 
            from game_record AS r, game_record_${playGameRecordValue} AS t where r.recordId = t.recordId AND r.recordUserId = '${playUser}' AND 
            r.recordGameName = '${playGame}' AND r.recordGameLevel = '${gameLevel}';`, (err, rows2, fields) => {
                // 이미 저장된 값이 있는지 확인함
                if(err) throw err;
                if(rows2.length > 0) {
                    // 저장된 값이 있다면 해당 기록과 현재 기록 중 더 나은 기록으로 바꿈
                    console.log('지정값 변경 : ', playUser, playGame, gameLevel, gameRecord)
                    connection.query(`update game_record_${playGameRecordValue} 
                    set recordCont=IF('${gameRecord}' < '${rows2[0]['recordCont']}', '${gameRecord}', '${rows2[0]['recordCont']}') 
                    where recordId = '${rows2[0]['recordId']}'`, (err, rows3, fields) => {
                        if(err) throw err;
                        console.log('지정값 변경 완료')
                        res.status(200).send({res:'success', record:gameRecord});
                    })

                } else {
                    // 저장된 값이 없다면 새로운 값을 추가함.
                    console.log('새로운 값 추가 : ', playUser, playGame, gameLevel, gameRecord)
                    connection.query(`insert into game_record(recorduserId, recordGameName, recordGameLevel, recordvalue) 
                    value('${playUser}','${playGame}',${gameLevel},'${playGameRecordValue}');`, (err, rows3, fields) => {
                        // 게임테이블 추가
                        connection.query(`insert into game_record_${playGameRecordValue} value( (select recordId from game_record where recorduserId = '${playUser}' 
                        AND recordGameName = '${playGame}' AND recordGameLevel = ${gameLevel}) ,'${gameRecord}');`, (err, rows3, fields) => {
                            // 기록테이블 추가
                            if(err) throw err;
                            console.log('추가 완료')
                            res.status(200).send({res:'success', record:gameRecord});
                        })
                    })
                }
            })


        } else {
            console.log('게임을 찾지못함')
            res.send({res:'fault'}) // 게임을 찾을 수 없으면 기록실패
        }
    })
})

router.get('/:id/record', (req,res) => {
    let gameLevel = req.query.level
    let playGame = req.params.id

    connection.query(`SELECT gameRecordValue FROM game WHERE gameName = '${playGame}'`, (err, rows, fields) => {
        // 게임의 레코드값을 먼저 가져와서 지정함
        if(err) throw err;
        if(rows.length > 0) {
            let playGameRecordValue = rows[0]['gameRecordValue']
            connection.query(`select r.recordId, r.recordUserId, r.recordGameName, r.recordGameLevel, t.recordCont from game_record AS r, 
            game_record_${playGameRecordValue} AS t where r.recordId = t.recordId AND r.recordGameLevel=${gameLevel} AND r.recordGameName='${playGame}' ORDER BY t.recordCont ASC;`, (err, rows2, fields) => {
                res.status(200).send(rows2)
            })
        } else {
            console.log('게임을 찾지못함')
            res.send({res:'fault'}) // 게임을 찾을 수 없으면 기록실패
        }
    })
})

router.get('/:id/myrecord', (req,res) => {
    let playUser = req.query.Userid 
    let playGame = req.params.id

    connection.query(`SELECT gameRecordValue FROM game WHERE gameName = '${playGame}'`, (err, rows, fields) => {
        // 게임의 레코드값을 먼저 가져와서 지정함
        if(err) throw err;
        if(rows.length > 0) {
            let playGameRecordValue = rows[0]['gameRecordValue']
            connection.query(`select r.recordId, r.recordUserId, r.recordGameName, r.recordGameLevel, t.recordCont from game_record AS r, 
            game_record_${playGameRecordValue} AS t where r.recordId = t.recordId AND r.recordUserId='${playUser}' AND r.recordGameName='${playGame}' ORDER BY r.recordGameLevel ASC;`, (err, rows2, fields) => {
                res.status(200).send(rows2)
            })
        } else {
            console.log('게임을 찾지못함')
            res.send({res:'fault'}) // 게임을 찾을 수 없으면 기록실패
        }
    })
})

module.exports = router