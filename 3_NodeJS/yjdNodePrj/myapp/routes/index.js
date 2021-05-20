var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get(/d/, (req,res) => {
  res.send('d com')
})

module.exports = router;
