@echo off
cd src
make
cd ..
cd release

rem "打包"
rem jar cvfm ../release/his.jar META-INF/MANIFEST.MF Main.class images libs ^
rem com/lanhuispace/his/*.class ^
rem com/lanhuispace/his/events/*.class ^
rem com/lanhuispace/his/assemblys/*.class ^
rem com/lanhuispace/his/utils/*.class ^
rem com/lanhuispace/his/interfaces/*.class

rem "打包后清理"
rem del *.class /S /Q
rem rd com /S /Q
::mkdir bin
::mv his.jar LanHuiHIS.exe bin/
cd ..
