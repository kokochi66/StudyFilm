const express = require('express')
const fs = require('fs')
const app = express()
const url = require('url')
const bodyParser = require('body-parser')

const PORT = process.env.PORT || 3000;


app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))

app.get('/', (req,res) => {
    let file = JSON.parse(fs.readFileSync('./user.json'))
    console.log(file);
    res.send(file)
})

app.post('/', (req,res) => {
    let file = JSON.parse(fs.readFileSync('./user.json'))
    let body = req.body
    let idx = file.findIndex(function(item) {return item.name === body.name})
    if(idx >= 0)  console.log('user exist')
    else {
        file.push(body)
        fs.writeFileSync('./user.json', JSON.stringify(file))
    }
    
    res.send(file)
})

app.delete('/', (req,res) => {
    let file = JSON.parse(fs.readFileSync('./user.json'))
    let queryData = req.query.name
    let idx = file.findIndex(function(item) {return item.name === queryData})
    if(idx >= 0) {
        file.splice(idx,1)
        fs.writeFileSync('./user.json', JSON.stringify(file))
    }
    res.send(file)
})

app.put('/', (req,res) => {
    let file = JSON.parse(fs.readFileSync('./user.json'))
    let body = req.body
    let idx = file.findIndex(function(item) {return item.name === body.name})
    if(idx >= 0) {
        file[idx] = body
        fs.writeFileSync('./user.json', JSON.stringify(file))
    }
    res.send(file)
})

app.listen(PORT, () => {console.log(`${PORT} server connect`)})

