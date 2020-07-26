#!/bin/sh
cp -r images release/
cp -r libs release/
cd src
make
cd ..



