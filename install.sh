#!/bin/sh

sudo mkdir /usr/local/lanhuihis
sudo chown -R `whoami`:`whoami` /usr/local/lanhuihis

cp -r release/* /usr/local/lanhuihis/

echo "[Desktop Entry]">/home/`whoami`/����/LanHuiHIS.desktop
echo "Name=����ҽԺ��Ϣϵͳ">>/home/`whoami`/����/LanHuiHIS.desktop
echo "Type=Application">>/home/`whoami`/����/LanHuiHIS.desktop
echo "Terminal=false">>/home/`whoami`/����/LanHuiHIS.desktop
echo "/usr/local/lanhuihis/start.sh">>/home/`whoami`/����/LanHuiHIS.desktop
echo "/usr/local/lanhuihis/images/image_title.png">>/home/`whoami`/����/LanHuiHIS.desktop

