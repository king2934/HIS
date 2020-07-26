#!/bin/sh

sudo mkdir /usr/local/lanhuihis
sudo chown -R `whoami`:`whoami` /usr/local/lanhuihis

cp -r release/* /usr/local/lanhuihis/

