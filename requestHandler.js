var ejs = require('ejs');
var fs = require('fs');
//https://araikuma.tistory.com/454 참고사이트
function view(response) {  
    console.log('request handler called --> view');
    response.writeHead(200, {'Content-Type' : 'text/html'}); // 이 부분에서 text/html 로 되어있어야 ejs가 제대로 표현된다.
    response.write("<H1>Hello View</H1>");
    response.end();
}

function create(response) {  
    console.log('request handler called --> create');
    response.writeHead(200, {'Content-Type' : 'text/plain'});
    response.write('Hello Create');
    response.end();
}

function viewEjs(response){
	var helloEjs = fs.readFileSync('./HelloEJS.ejs', 'UTF-8');
	console.log('request handler called --> viewEjs');
	var data = { title: 'ejs init', message: 'Hello World' , loopData : ["one","two","three","four"]};
    //var hello2 = ejs.render(hello, {title : "test! ㄱㄱ", data : ""});
	var renderEjs = ejs.render(helloEjs, data);
    response.writeHead(200, {'Content-Type' : 'text/html'}); // 이 부분에서 text/html 로 되어있어야 ejs가 제대로 표현된다.
    response.write(renderEjs);
    response.end();
}

var handle = {}; // javascript object has key:value pair.  
handle['/'] = view;  
handle['/view'] = view;  
handle['/create'] = create;
handle['/viewEjs'] = viewEjs;

exports.handle = handle;
