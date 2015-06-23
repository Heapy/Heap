#!/bin/bash

docker run --restart=always --name heap-db -p 127.0.0.1:5432:5432 -e POSTGRES_PASSWORD=qwerty -v $(pwd)/data:/var/lib/postgresql/data -d heap-postgres