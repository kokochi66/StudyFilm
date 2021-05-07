const express = require('express')
const router = express.Router();
const ctrl = require('./user.ctrl')

router.get('/', ctrl.index);   // 유저정보 가져오기
router.get('/:id', ctrl.show);   // 특정 유저 정보 가져오기
router.delete('/:id', ctrl.destroy);   // 특저 유저 정보 삭제하기
router.post('/', ctrl.create);   // 유저정보 입력하
module.exports = router;