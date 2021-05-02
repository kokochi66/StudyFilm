var http = require('http');
var fs = require('fs');
var qs = require('querystring');
var url = require('url');
var template = require('./lib/template.js');
var sanitize = require('sanitize-html');

var app = http.createServer(function(request,response){
  var _url = request.url;
    var queryData = url.parse(_url, true).query;
    var pathname = url.parse(_url, true).pathname;
    var title = queryData.id;
    var list = "";
    // 선언부

    if(pathname === '/') {
      if(queryData.id === undefined) {
        fs.readdir('data', function(err, filelist) {
          title = 'Welcome';
          desc = 'Hello Node JS'
          list = template.LIST(filelist);
          var html = template.HTML(title, list, desc);
          response.writeHead(200);
          response.end(html);
        });

      } else {
        fs.readdir('data', function(err, filelist) {
          fs.readFile(`data/${queryData.id}`, 'utf8', function(err, desc){
            list = template.LIST(filelist);
            var sanitizedTit = sanitize(title);
            var sanitizedDesc = sanitize(desc, {
              allowedTags:['h1']
            });
            var html = template.HTML(sanitizedTit, list, sanitizedDesc);
            response.writeHead(200);
            response.end(html);
          });
        });
      }
    } // 링크가 정상적으로 전달되었을 때 처리
    else if(pathname === '/create') {
      fs.readdir('data', function(err, filelist) {
        title = 'Web - create';
        desc = `

        <form action="/process_create" method="post">
          <p>
            <input type="text" name="title"  placeholder="title">
          </p>
          <p>
            <textarea name="content" rows="8" cols="30" placeholder="content"></textarea>
          </p>
          <p>
            <input type="submit">
          </p>
        </form>

        `;
        list = template.LIST(filelist);
        var html = template.HTML(title, list, desc);
        response.writeHead(200);
        response.end(html);
      });
    }
    else if(pathname === '/update') {
      fs.readdir('data', function(err, filelist) {
        fs.readFile(`data/${queryData.id}`, 'utf8', function(err, desc){
          title = queryData.id;
          desc = `

          <form action="/process_update" method="post">
            <input type="hidden" name="id" value="${title}"/>
            <p>
              <input type="text" name="title" placeholder="title" value="${title}">
            </p>
            <p>
              <textarea name="content" rows="8" cols="30" placeholder="content" >${desc}</textarea>
            </p>
            <p>
              <input type="submit">
            </p>
          </form>

          `;
          list = template.LIST(filelist);
          var html = template.HTML(title, list, desc);
          response.writeHead(200);
          response.end(html);
        });
      });
    }
    else if(pathname === '/process_create') {
        var body = '';
        request.on('data', function(data) {
          body += data;
        });
        request.on('end', function() {
          var post = qs.parse(body);
          title = post.title;
          desc = post.content;
          fs.writeFile(`data/${title}`, desc, 'utf8', function(err) {
            response.writeHead(302, {Location: `/?id=${title}`});
            response.end();
          });
        });
    }
    else if(pathname === '/process_update') {
        var body = '';
        request.on('data', function(data) {
          body += data;
        });
        request.on('end', function() {
          var post = qs.parse(body);
          var title = post.title;
          var desc = post.content;
          var id = post.id;
          fs.rename(`data/${id}`, `data/${title}`, function(err) {
            fs.writeFile(`data/${title}`, desc, 'utf8', function(err) {
              response.writeHead(302, {Location: `/?id=${title}`});
              response.end();
            });

            response.writeHead(302, {Location: `/?id=${title}`});
            response.end();
          });
        });
    }
    else if(pathname === '/process_delete') {
        var body = '';
        request.on('data', function(data) {
          body += data;
        });
        request.on('end', function() {
          var post = qs.parse(body);
          var title = post.title;
          var id = post.id;
          fs.unlink(`data/${id}`, (err) => {
            response.writeHead(302, {Location: `/`});
            response.end();
          });
        });
    }
    else {
      console.log(pathname +" error 발생");
      response.writeHead(404);
      response.end('Not found');
    } // 링크 에러가 있을 경우
});
app.listen(3000);
