const assert = require('assert');
const should = require('should');
const request = require('supertest');
const app = require('./index');




describe('GET /users', () => {
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
});