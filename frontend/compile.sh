#!/bin/bash

function commandExists() {
    which "$1" > /dev/null;
}

if !(commandExists npm); then
    echo "Please first install NPM:";
    echo "https://www.npmjs.org/";
    echo "Exit...";
    exit 1;
fi

echo "Installing node packages for project building...";
if !(npm install); then
    echo "Problem with node packages installing!";
    echo "Exit...";
    exit 2;
fi

echo "Updating already installed node packages...";
if !(npm install); then
    echo "Problem with node packages updating!";
    echo "Exit...";
    exit 3;
fi

echo "Downloading project dependies using Bower...";
if !(./node_modules/bower/bin/bower install); then
    echo "Problem with Bower packages installing!";
    echo "Exit...";
    exit 4;
fi

echo "Updating project dependies using Bower...";
if !(bower install); then
    echo "Problem with Bower packages updating!";
    echo "Exit...";
    exit 5;
fi

echo "Running gulp default task...";
if !(./node_modules/gulp/bin/gulp.js); then
    echo "Problem gulp task execution!";
    echo "Exit...";
    exit 6;
fi

echo "Run node server?";
read answer;
case "$answer" in
    '')
        echo "All done. Exit..."
        ;;
    [yY])
        node server;
        ;;
    [nN])
        echo "All done. Exit..."
        ;;
    *)
        echo "\"$answer\" is unexpected value."
        echo "Do nothing. Exit...";
        ;;
esac
exit 0;
