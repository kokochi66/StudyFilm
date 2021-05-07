const express = require('express')
const logger = require('morgan')
const bodyParser = require('body-parser')
const app = express()
const users_module = require('./api/user/index')

app.use(logger('dev'))
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

app.use('/users', users_module);

app.get('/', (req, res) => {
  res.status(200);
  res.send('Hello World!')
})    // 홈 이동

module.exports = app