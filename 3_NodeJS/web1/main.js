var http = require('http');
var fs = require('fs');
var qs = require('querystring');
var url = require('url');

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
          list = templateList(filelist);
          var template = templateHTML(title, list, desc);
          response.writeHead(200);
          response.end(template);
        });

      } else {
        fs.readdir('data', function(err, filelist) {
          fs.readFile(`data/${queryData.id}`, 'utf8', function(err, desc){
            list = templateList(filelist);
            var template = templateHTML(title, list, desc);
            response.writeHead(200);
            response.end(template);
          });
        });
      }
    } // 링크가 정상적으로 전달되었을 때 처리
    else if(pathname === '/create') {
      fs.readdir('data', function(err, filelist) {
        title = 'Web - create';
        desc = `

        <form action="http://localhost:3000/process_create" method="post">
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
        list = templateList(filelist);
        var template = templateHTML(title, list, desc);
        response.writeHead(200);
        response.end(template);
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
    else {
      console.log(pathname +" error 발생");
      response.writeHead(404);
      response.end('Not found');
    } // 링크 에러가 있을 경우
});
app.listen(3000);

function templateHTML(title, list, desc) {
  return `
  <!doctype html>
  <html>
  <head>
    <title>WEB1 - ${title}</title>
    <meta charset="utf-8">
  </head>
  <body>
    <h1><a href="/">WEB Of PM2</a></h1>
    <ol>
      ${list}
    </ol>
    <a href="/create">create</a>
    <h2>${title}</h2>
    <p>${desc}</p>
  </body>
  </html>`;
}

function templateList(filelist) {
  var list = '<ul>';
  var i = 0;
  while(i < filelist.length){
    list = list + `<li><a href="/?id=${filelist[i]}">${filelist[i]}</a></li>`;
    i++;
  }
  list = list + '</ul>';
  return list;
}
