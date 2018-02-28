@echo off
title Run Install

set dev_path=%~dp0
set desktop_path=%userprofile%\desktop\
set dev_local=%userprofile%\desktop\dev\
set git_app=%dev_local%apps\git\bin\git.exe
set mvn_app=%dev_local%apps\apache-maven-3.5.2\bin\mvn
set JAVA_HOME=%dev_local%java\jdk1.8.0_152
set chrome_app=%dev_local%apps\GoogleChromePortable\GoogleChromePortable.exe
set zip_app=%dev_path%apps\7-ZipPortable\App\7-Zip64\7z.exe

echo Current path: %dev_path%
echo git path: %git_app%
echo mvn path: %mvn_app%
echo dev_local path: %dev_local%
echo desktop_path path: %desktop_path%

title Download from github ...
cd /d %dev_local%git\github\
%git_app% clone https://github.com/jakub-olszewski/sample-javafx.git
cd /d %dev_local%git\github\sample-javafx

REM Update from github
%git_app% pull


pause
exit