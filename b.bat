@echo off
cd source
make
cd ..
cd release

rem "���"
jar cvfm ../release/his.jar META-INF/MANIFEST.MF Main.class images libs ^
com/lanhuispace/his/*.class ^
com/lanhuispace/his/events/*.class ^
com/lanhuispace/his/assemblys/*.class ^
com/lanhuispace/his/utils/*.class ^
com/lanhuispace/his/interfaces/*.class

rem "���������"
del *.class /S /Q
rd com /S /Q
::mkdir bin
::mv his.jar LanHuiHIS.exe bin/
cd ..
