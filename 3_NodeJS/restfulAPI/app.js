const express = require('express')
const app = express()
const port = 3000

const users = [
  {'name': 'Alice'}
];

app.get('/', (req, res) => {
  res.status(200);
  res.send('Hello World!')
})
app.get('/users', (req,res) => {
  res.json(users);
});


// app.listen(port, () => {
//   console.log(`Example app listening at http://localhost:${port}`)
// })

module.exports = app;