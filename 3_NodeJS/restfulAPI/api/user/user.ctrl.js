let users = [
    {'id': 1, 'name': 'Alice'},
    {'id': 2, 'name': 'Ball'},
    {'id': 3, 'name': 'Cross'}
  ];

const index = (req,res) => {
    var limit = parseInt(req.query.limit, 10);
    var st = 200;
    if(isNaN(limit)) {
      st = 400;
      
      limit = users.length;
    } 
    res.status(st);
    res.json(users.slice(0, limit));  
  }

const show = (req,res) => {
    const id = parseInt(req.params.id, 10); // id값을 얻어내야함.
    if(Number.isNaN(id)) return res.status(400).end(); // id가 숫자가 아니면 400응답
    const user = users.filter(user => user.id === id)[0]; // id값을 통해서 users 배열을 조회함
    if(!user) return res.status(404).end(); // id가 지정 숫자를 넘으면 404 응답 (id가 undefined라면)
    res.json(user); // 조회한 값을 응답해야함.
  }

const destroy = (req,res) => {
    const id = parseInt(req.params.id, 10); // id값을 얻어내야함.
    if(Number.isNaN(id)) return res.status(400).end(); // id가 숫자가 아니면 400응답
    users = users.filter(user => user.id !== id);
    res.status(204).end();
  }

const create = (req,res) => {
    const name = req.body.name;
    if(!name) return res.status(400).end();   // 이름이 주어지지 않았다면 400에러를 응답
    if(users.filter(user => user.name === name).length) 
      return res.status(409).end(); // 이미 같은 이름값이 있다면 409에러를 응답
    const id = Date.now();
    const user = {id, name};
    users.push(user);
  
    res.status(201).json(user);
  }

module.exports = {
    index, show, destroy, create
};