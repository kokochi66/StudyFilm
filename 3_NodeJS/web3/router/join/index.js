var express = require('express');
var app = express();
var router = express.Router();
var path = require('path');
var mysql = require('mysql');
const passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;

var connection = mysql.createConnection({
    host: 'localhost',
    port: 3307,
    user: 'root',
    password: 'rmeka5959!',
    database: 'web3'
});
connection.connect();

router.get('/', function(req, res) {
    var msg;
    var errMsg = req.flash('error');
    if(errMsg) msg = errMsg;
    res.render('join.ejs', {'message' : msg});
})

passport.serializeUser(function(user, done) {
    console.log('passport session save : ', user.id);
    done(null, user.id);
});

passport.deserializeUser(function(id, done) {
    console.log('passport session get id : ', id);
    done(null, id);
});

passport.use('local-join', new LocalStrategy({
    usernameField: 'email',
    passwordField: 'password',
    passReqToCallback: true
}, function(req, email, password, done) {
    var query = connection.query('select * from web3.user where email=?', [email], function(err,rows) {
        if(err) return done(err);

        if(rows.length) {
            console.log('existed user');
            return done(null, false, {message : 'your email is already used'});
        } else {
            var sql = {'name':'kibo', 'email':email, 'password':password};
            var query =  connection.query('insert into web3.user set ?', sql, function(err, rows) {
                console.log('query success');
                if(err) throw err
                return done(null, {'email':email, 'id':rows.insertId});
            });
        }
    });
}));

router.post('/', passport.authenticate('local-join', {
    successRedirect: '/main',
    failureRedirect: '/join',
    failureFlash: true
}));



module.exports = router;