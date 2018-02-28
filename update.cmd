@echo off
title Git update

set dev_path=%~dp0
set git_app=%dev_path%apps\git\bin\git.exe
set mvn_app=%dev_path%apps\apache-maven-3.5.2\bin\mvn
set JAVA_HOME=%dev_path%java\jdk1.8.0_152
set chrome_app=%dev_path%apps\GoogleChromePortable\GoogleChromePortable.exe
echo Current path: %dev_path%
echo git path: %git_app%
echo mvn path: %mvn_app%

cd /d %dev_path%git\github\sample-javafx
%git_app% reset --hard HEAD
%git_app% fetch --all
%git_app% reset --hard origin/master
pause
exit