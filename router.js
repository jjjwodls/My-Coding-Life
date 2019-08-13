var requestHandlers = require('./requestHandler');

function route(handle, pathName, response){
	console.log("route a request for " + pathName);
	requestHandlers.count = requestHandlers.count+1;  
	if(typeof handle[pathName] === 'function'){ 
		handle[pathName](response);
	}else{
		console.log('no request handler found for ' + pathName);
		response.writeHead(404, {'Content-Type' : 'text/plain'});
        response.write('404 Not found');
        response.end();
	}
}

exports.route = route;