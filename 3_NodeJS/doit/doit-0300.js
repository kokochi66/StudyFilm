let person = {}

person.name = '소녀시대'
person['age'] = 20
person.add = function(a,b) {
    return a + b
}

console.log('name =',person['name'])
console.log('age =',person.age)
console.log('add =',person.add(10,20))

let users  = [{name:'소녀시대', age:20}, {name:'걸스데이', age:22}, {name:'티아라', age:21}]

users.splice(1,0)
console.dir(users)

function add(a,b,gg) {
    var res = a+b
    gg(res)
}

add(10,10, (res) => {
    console.log('더하기 결과 ', res)
})

console.log('add의 자료형 :' ,typeof(add))

function Person(name, age) {
    this.name = name;
    this.age = age;
}

var person3 = new Person('abc', 20)

console.log(person3)