const assert = require('assert');
const should = require('should');
const request = require('supertest');
const app = require('../../index');

describe('GET /users', () => {
    describe('성공', () => {
        it('배열을 반환한다', (done) => {
            // assert.equal(1,2);
            request(app)
                .get('/users')
                .end((err,res) => {
                    res.body.should.be.instanceof(Array);
                    res.body.forEach(user => {
                        user.should.have.property('name');
                    })
                    console.log(res.body);
                    done();
                })
        });
        it('최대 limit 갯수만큼 응답한다', done => {
            request(app)
                .get('/users?limit=2')
                .end((err,res) => {
                    res.body.should.have.lengthOf(2)
                    done();
                })
        })
    })
    describe('실패', () => {
        it('limit이 정수가 아니면 400을 응답', done => {
            request(app)
                .get('/users?limit=two')
                .expect(400)
                .end(done);
        })
    })
    
});     // 일반 유저 가져오기 테스트

describe('GET /users/:id', () => {
    describe('성공', () => {
        it('유저 객체를 반환', done => {
            request(app)
                .get('/users/1')
                .end((err,res) => {
                    res.body.should.have.property('id', 1);
                    done();
                });
        })
    })
    describe('실패', () => {
        it('id가 숫자가 아닐 경우 400 응답', done => {
            request(app)
                .get('/users/one')
                .expect(400)
                .end(done);
        })
        it('찾을 수 없는 id 일 경우 404 응답', done => {
            request(app)
                .get('/users/9')
                .expect(404)
                .end(done);
        })
    })
});      // 특정 유저 가져오기 테스트

describe('DELETE /users/:id', () => {
    describe('성공', () => {
        it('204 응답', done => {
            request(app)
                .delete('/users/3')
                .expect(204)
                .end(done);
        });
    });
    describe('실패', () => {
        it('id가 숫자가 아닐 경우 400 반환', done => {
            request(app)
                .delete('/users/three')
                .expect(400)
                .end(done);
        });
    });
});     // 특정 유저 삭제하기 테스트

describe('POST /user', () => {
    describe('성공', () => {
        it('201 응답', done => {
            request(app)
                .post('/users')
                .send({name: 'Daniel'}) // Daniel이라는 이름을 가진 객체를 보냄
                .expect(201).end((err,res) => {
                    res.body.should.have.property('name', 'Daniel');    // 유저객체가 일치하는지 확인
                    done();
                });
        });
    });
    describe('실패', () => {
        it('name이 없으면 400 응답', done => {
            request(app)
                .post('/users')
                .send({}).expect(400).end(done);
        });
        it('name이 중복이면 409 응답', done => {
            request(app)
                .post('/users').send({name : 'Alice'})
                .expect(409).end(done);
        });
    });
});     // 특정 유저 삭제하기 테스트
