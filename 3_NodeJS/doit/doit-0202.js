console.time('duration_time')
let res = 0;
for (let i=0;i<10000;i++) {
    res+=i
}
console.timeEnd('duration_time')
// 시간 제기

console.log('파일 이름 : %s', __filename)
console.log('폴더 경로 : %s', __dirname)
// 경로에 대한 전역변수

console.log('argv 속성의 파라미터 수 :', process.argv.length)
process.argv.forEach((item,index) => {
    console.log(index, item)
})