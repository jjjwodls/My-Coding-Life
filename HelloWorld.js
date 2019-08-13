/**
 * http://usejsdoc.org/
 */
console.log("Hello Node Js");

var http = require('http');
var fs = require('fs');

http.createServer(function(req,res){
	try{
		var url = req.url;
		//console.log(url + " /// " + __dirname);
		console.log("init reqUrl = " + url);
		if(url.indexOf("/") > -1){
			url = "/Board.html";
		}
		return res.end(fs.readFileSync(__dirname + url));
		
		if(url.indexOf('/favicon.ico') > -1){
		      return res.writeHead(404);
		}
		console.log(url.indexOf("/api/members"));
		if(url.indexOf("/api/members") > -1){
			console.log("info");
			url = "/api/members";
		}
		
		console.log("cur url = " + url);
		res.writeHead(200);
		
	}catch (e) {
		console.log(e);
	}
	/*res.writeHead(200,{'Content-Type':'text/html'});
	res.end('<h1>Hello NodeJS</h1>');*/
}).listen(9090,function(){
	console.log("success");
});



