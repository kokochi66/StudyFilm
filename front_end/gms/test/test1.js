const assert = require('assert');
const expect  = require("chai").expect;
const request = require('request');
var chai = require('chai'), chaiHttp = require('chai-http');
chai.use(chaiHttp);
const url = 'http://localhost:3000'

describe('GET 인덱싱 테스트', () => {
    it('Test :: /', () => {
        request(`${url}`, (err,res,body) => {
            expect(res.statusCode).to.equal(200)
        })
    })
    it('Test :: /login', () => {
        request(`${url}/login`, (err,res,body) => {
            expect(res.statusCode).to.equal(200)
        })
    })
    it('Test :: /logout', () => {
        request(`${url}/logout`, (err,res,body) => {
            expect(res.statusCode).to.equal(200)
        })
    })
});

describe('로그인 기능', () => {

})