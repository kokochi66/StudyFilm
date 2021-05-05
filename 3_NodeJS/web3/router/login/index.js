var express = require('express');
var app = express();
var router = express.Router()
var path = require('path')
var mysql = require('mysql')
var passport = require('passport')
var LocalStrategy = require('passport-local').Strategy

var connection = mysql.createConnection({
    host : 'localhost',
    port : 3307,
    user : 'root',
    password : 'rmeka5959!',
    database : 'web3'
})
connection.connect()

router.get('/', function(req,res) {
    var msg;
    var errMsg = req.flash('error');
    if(errMsg) msg = errMsg;
    res.render('login.ejs', {'message' : msg});
})

passport.serializeUser(function(user, done) {
    console.log('passport session save : ', user.id);
    done(null, user.id)
});

passport.deserializeUser(function(id, done) {
    console.log('passport session get id ',id)
    done(null, id);
})

passport.use('local-login', new LocalStrategy({
    usernameField: 'email',
    passwordField: 'password',
    passReqToCallback: true
    }, function(req, email, password, done) {
        console.log(1);
        var query = connection.query('select * from web3.user where email=?', [email], function(err, rows) {
            if(err) return done(err);

            if(rows.length) {
                console.log('existed user')
                return done(null, false, {message: 'your email is already used'})
            } else {
                var sql = {email: email, password:password, name:'ggb'};
                var query = connection.query('insert into web3.user set ?', sql, function(err, rows) {
                    if(err) throw err
                    return done(null, {'email':email, 'id':rows.insertId});
                })
            }
        })
    }))

    
router.post('/', function(req, res, next) {
    passport.authenticate('local-login', function(err, user, info) {
        if(err) res.status(500).json(err);
        if(!user) return res.status(401).json(info.message);

        req.logIn(user, function(err) {
            if(err) return next(err);
            return res.redirect(user);
        });
    })(req,res,next);
});

module.exports = router;