//https://yamea-guide.tistory.com/182 EJS 설치 관련 오류 잡아주는부분
var server = require('./server'); // ./server는 파일을 얻어오는 경로를 말함.
var router = require('./router');
var requestHandlers = require('./requestHandler');

server.myFunction(); // 테스트코드

console.log("server info = " + server);
console.log("router info = " + router);

server.start(router.route, requestHandlers.handle);
