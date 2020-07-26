#!/bin/sh

sudo mkdir /usr/local/lanhuihis
sudo chown -R `whoami`:`whoami` /usr/local/lanhuihis

cp -r release/* /usr/local/lanhuihis/

echo "[Desktop Entry]">/home/`whoami`/桌面/LanHuiHIS.desktop
echo "Encoding=UTF-8">>/home/`whoami`/桌面/LanHuiHIS.desktop
echo "Name=蓝徽医院信息系统">>/home/`whoami`/桌面/LanHuiHIS.desktop
echo "Exec=/usr/local/lanhuihis/start.sh">>/home/`whoami`/桌面/LanHuiHIS.desktop
echo "Type=Application">>/home/`whoami`/桌面/LanHuiHIS.desktop
echo "Icon=/usr/local/lanhuihis/images/image_title.png">>/home/`whoami`/桌面/LanHuiHIS.desktop
echo "Terminal=false">>/home/`whoami`/桌面/LanHuiHIS.desktop

sudo a+x /home/`whoami`/桌面/LanHuiHIS.desktop