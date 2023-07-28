const express = require('express')
const router = express.Router()

const loginRouter = require('./user/login_index')
const logoutRouter = require('./user/logout_index')
const registRouter = require('./user/register_index')
const gameRouter = require('./game/game_index')
router.use('/login', loginRouter)
router.use('/logout', logoutRouter)
router.use('/register', registRouter)
router.use('/game', gameRouter)
// user 인덱싱


router.get('/', (req,res) => {

    res.status(200).render('./ejs/main/index.ejs', {'user':req.cookies.user, 'url':`/`})
})

module.exports = router