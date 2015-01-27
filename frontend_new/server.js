(function () {

    'use strict';

    var PORT = 8808,
        API_KEY = '/api/';

    var http = require('http'),
        url = require('url'),
        path = require('path'),
        fs = require('fs'),
        request = require('request'),
        queryString = require('querystring'),
        mime = require('mime');

    var server = http.createServer(function (req, res) {
        var urlData = url.parse(req.url),
            theUrl = urlData.pathname,
            someFileName = path.join(process.cwd(), theUrl),
            data = '',
            queryData = queryString.parse(urlData.query);

        req.on('data', function (datum) {
            data += datum;
        });

        req.on('end', function () {

            if (theUrl.indexOf(API_KEY) !== -1) {

                delete req.headers.host;

                var proxyUrl = theUrl.replace(API_KEY, '');
                request({
                    url: proxyUrl,
                    method: req.method,
                    headers: req.headers,
                    body: data,
                    qs: queryData
                }, function (error, response) {
                    if (response) {
                        // override content type for ie
                        response.headers['content-type'] = 'text/plain';
                        res.writeHead(response.statusCode, response.headers);
                        res.write(response.body, 'utf-8');
                        res.end();
                    } else {
                        res.writeHead(408);
                        res.write(error.message, 'utf-8');
                        res.end();
                    }
                });

            } else {
                if (theUrl === '/') {
                    someFileName += 'index.html';
                }
                fs.exists(someFileName, function (exists) {
                    var type = mime.lookup(someFileName);
                    if (!exists) {
                        res.writeHead(404, {'Content-Type': 'text/plain'});
                        res.write('404 Nothing Here\n');
                        res.end();
                        return;
                    }
                    fs.readFile(someFileName, 'binary', function (err, file) {
                        if (err) {
                            res.writeHead(500, {'Content-Type': 'text/plain'});
                            res.write(err + '\n');
                            res.end();
                            return;
                        }

                        res.writeHead(200, {'Content-Type': type});
                        res.write(file, 'binary');
                        res.end();
                    });
                });
            }

        });

    });

    server.listen(PORT);

    console.log('Server running at http://localhost:' + PORT);

}());

