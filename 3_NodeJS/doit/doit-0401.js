let EventEmitter = require('events').EventEmitter

let Calc = () => {
    this.on('stop', () => {
        console.log('Calc에 stop 이벤트 전달됨')
    })   
}

let util = require('util').inherits(Calc, EventEmitter)

Calc.prototype.add = (a,b) => {
    return a+b
}

module.exports = Calc;