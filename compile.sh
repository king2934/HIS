#!/bin/sh
cp -r images release/images
cp -r libs release/libs
cd src
make
cd ..



