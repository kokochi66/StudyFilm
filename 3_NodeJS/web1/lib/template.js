module.exports = {
  HTML: function(title, list, desc) {
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
      <a href="/update?id=${title}">update</a>
      <form action="process_delete" method="post">
        <input type="hidden" name="id" value="${title}">
        <input type="submit" value="delete">
      </form>
      <h2>${title}</h2>
      <p>${desc}</p>
    </body>
    </html>`;
  },
  LIST: function(filelist) {
    var list = '<ul>';
    var i = 0;
    while(i < filelist.length){
      list = list + `<li><a href="/?id=${filelist[i]}">${filelist[i]}</a></li>`;
      i++;
    }
    list = list + '</ul>';
    return list;
  }
}
