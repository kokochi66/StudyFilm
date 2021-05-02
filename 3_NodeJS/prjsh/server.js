const express = require('express');
const bodyParser = require('body-parser');
const server = express();
server.use(bodyParser.json());

const users = [
  {
    id:"kokochi",
    name:"jaewon",
    age:"25"
  },
  {
    id:"dlwodlfrnt",
    name:"jaeil",
    age:"26"
  }
];

server.get("/api/user", (req,res)=> {
  res.json(users);
});
server.post("/api/user", (req,res)=> {
  users.push(req.body);
  res.json(users);
});

server.listen(3000, () => {
  console.log('server is running');
});
