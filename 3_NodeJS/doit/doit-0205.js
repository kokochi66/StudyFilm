let os = require('os')
console.log('hostname  :', os.hostname())
console.log('memory :',os.freemem())
// 운영체제의 정보를 확인하게 해줌(유용X)

let path = require('path')
let directories = ['users', 'kokochi', 'docs']
let dirStr = directories.join(path.sep)
console.log(dirStr)
console.log(path.join('/Users/Mars', 'notepad.exe'))
// 파일의 경로를 만들때 도와줌