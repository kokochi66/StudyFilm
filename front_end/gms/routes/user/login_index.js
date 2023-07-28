const express = require('express')
const router = express.Router()
const mysql = require('mysql')
const bcrypt = require('bcrypt')
const fs = require('fs')

const connKey = JSON.parse(fs.readFileSync('./key/sql.json'))
const connection = mysql.createConnection({
    host     : connKey.host,
    port     : connKey.port,
    user     : connKey.user,
    password : connKey.password,
    database : connKey.database
});

router.get('/', (req,res) => {
    console.log(bcrypt.hashSync('0000', 10))
    res.status(200).render('./ejs/user/login.ejs', {'user':req.cookies.user, 'url':`${req.query.url}`})
})

router.post('/', (req,res) => {
    connection.query(`SELECT * FROM user WHERE userId = '${req.body.id}'`, (err, rows, fields) => {
        if(err) throw err;
        if(rows.length > 0 && bcrypt.compareSync(req.body.pwd, rows[0]['userPwd'])) {
            let options = {
                maxAge: 1440000,
                expires: new Date(Date.now() + 1440000)
            }
            res.cookie('user', rows[0], options)
            res.send({res:'success'})
        } else {
            res.send({res:'fault'})
        }
    })
})

module.exports = router