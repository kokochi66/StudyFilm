// url 모듈을 통해서 원하는 url에서 필요한 부분을 뽑아낼 수 있도록 한다.
const url = require('url')

let urlStr = `https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=Over`
let curUrl = url.parse(urlStr);
// parse를 실행하면 url을 각 부분에 따라서 나눠진 json파일로 반환된다.
// 프로토콜, 호스트, 각 쿼리부분을 별도로 따로 나눠진다.
// console.log(curUrl)

let curStr = url.format(curUrl)
// console.log(curStr)
// format 을 실행하면 반환된 값을 다시 원래 url값으로 바꿔준다.

const querystring = require('querystring')
let params = querystring.parse(curUrl.query)
// console.log('검색어 :',params.query)
// 쿼리값을 가져올 수 있다.

// process.on('exit', () => {
//     console.log('exit 이벤트 발생')
// })
// // process라는 이벤트를 이미 상속중이다.

// setTimeout(() => {
//     console.log('2초 후 실행')
//     process.exit();
// }, 2000)
// console.log('2초 후에 실행될 것임.')

// process.on('tick', (count) => {
//     console.log('tick 이벤트 발생 :', count)
// })
// setTimeout(() => {
//  console.log('2초 후 실행')
//  process.emit('tick', '2')
// }, 2000)

// process객체를 이용한 이벤트 만들기

// const calc = require('./doit-0401');
// // 프로토타입으로 계산기 모듈을 가져옴

// let calc1 = new calc()
// // calc1.emit('stop')
// // 모듈객체에 stop 이벤트를 보냄


const fs = require('fs')
// let data = fs.readFileSync('../package.json', 'utf8')
// console.log(data)
// 동기와 비동기 방식으로 파일을 실행시킬 수 있다.
