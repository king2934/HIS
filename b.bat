cd source
make
cd ..
cd release
jar cvfm ../release/his.jar META-INF/MANIFEST.MF *.class images com/lanhuispace/his/*.class
mkdir bin
mv his.jar LanHuiHIS.exe bin/
cd ..
