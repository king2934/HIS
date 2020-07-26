@echo off
@md "%ProgramFiles%\LanHui"
echo d|xcopy /E /C /Q /H /Y release "%ProgramFiles%\LanHui\his"
echo f|xcopy /E /C /Q /H /Y LanHuiHIS.exe "%ProgramFiles%\LanHui\his\LanHuiHIS.exe"
echo d|xcopy /E /C /Q /H /Y META-INF "%ProgramFiles%\LanHui\his\META-INF"
echo d|xcopy /E /C /Q /H /Y libs "%ProgramFiles%\LanHui\his\libs"
echo d|xcopy /E /C /Q /H /Y images "%ProgramFiles%\LanHui\his\images"

for /f "tokens=2,*" %%i in ('reg query "HKCU\Software\Microsoft\Windows\CurrentVersion\Explorer\Shell Folders" /v "Desktop"') do Set desktop=%%j

set WorkDir=%ProgramFiles%\LanHui\his\
set Program=%ProgramFiles%\LanHui\his\LanHuiHIS.exe
set LnkName=蓝徽HIS

if not defined WorkDir call:GetWorkDir "%Program%"
(echo Set WshShell=CreateObject("WScript.Shell"^)
echo strDesKtop=WshShell.SpecialFolders("DesKtop"^)
echo Set oShellLink=WshShell.CreateShortcut(strDesKtop^&"\%LnkName%.lnk"^)
echo oShellLink.TargetPath="%Program%"
echo oShellLink.WorkingDirectory="%WorkDir%"
echo oShellLink.WindowStyle=1
echo oShellLink.Description="%Desc%"
echo oShellLink.Save)>makelnk.vbs
echo 桌面快捷方式创建成功！
makelnk.vbs
del /f /q makelnk.vbs

rem echo [InternetShortcut]>>"%desktop%\蓝徽HIS.url"
rem echo URL="%ProgramFiles%\LanHui\his\LanHuiHIS.exe" >>"%desktop%\蓝徽HIS.lnk"
rem echo IconIndex=0 >>"%desktop%\蓝徽HIS.lnk"
rem echo IconFile="%ProgramFiles%\LanHui\his\LanHuiHIS.exe" >>"%desktop%\蓝徽HIS.lnk"

rem rd /s /q release