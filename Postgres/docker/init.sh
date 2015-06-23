#!/bin/bash

gosu postgres postgres --single <<- EOSQL
    CREATE DATABASE heap;
EOSQL