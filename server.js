var http = require('http');
var url = require('url');




function start(route, handle) {  
    function onRequest(request, response) {
    	
    	var pathname = url.parse(request.url).pathname;
    	if(pathname.indexOf("/favicon.ico")> -1){
    		return;
    	}
    	console.log('request for ' + pathname + ' received.');
    	
    	route(handle,pathname,response); // injected function call
    	
        /*console.log('request received.');
        response.writeHead(200, {'Content-Type' : 'text/plain'});
        response.write('Hello World');
        response.end();*/
    }

    http.createServer(onRequest).listen(8888); //서버 생성 및 포트를 지정해준다.

    console.log('server has started.');
}

function myFunction(){
	console.log("모듈 등록 테스트 입니다. 함수명으로 호출함.");
}
/**

 * export 에는 key, value 형태로 담기게 되는데
 * export.키값 = 오브젝트 형태로 담긴다.
 */
exports.start = start;   //전역변수인 exports 라는 곳에 start 함수를 담는다.(모듈을 담는다고 생각하면 되며, index.js 에서 해당 모듈을 꺼내 쓸 수 있음)
exports.myFunction = myFunction;