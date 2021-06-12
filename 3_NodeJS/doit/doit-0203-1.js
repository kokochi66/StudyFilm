let calc1 = {}
let calc2 = require('./doit-0203-2')

calc1.add = (a,b) => {
    return a+b
}
console.log('모듈로 분리하기 전 - calc.add :', calc1.add(10,10))
console.log('모듈로 분리한 후 - calc.add :', calc2.add(10,10))

let nconf = require('nconf')
let value = nconf.get('OS')
console.log('OS 환경변수의 값', value)