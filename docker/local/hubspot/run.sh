#!/bin/bash

args="$@"

args="$@ -p 80 --id guid"

file=/data/routes.json
if [ -f $file ]; then
    echo "Found routes.json, trying to open"
    args="$args --routes routes.json"
fi

file=/data/hubspot.json
if [ -f $file ]; then
    echo "Found hubspot.json, trying to open"
    args="$args hubspot.json"
fi

file=/data/file.js
if [ -f $file ]; then
    echo "Found file.js seed file, trying to open"
    args="$args file.js"
fi

echo args: $args
json-server $args