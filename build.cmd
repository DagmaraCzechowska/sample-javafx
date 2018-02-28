@echo off
title mvn
set dev_path=%~dp0
echo Current path: %dev_path%
set desktop_path=%userprofile%\desktop\
set dev_local=%userprofile%\desktop\dev\

set PATH=%PATH%;%dev_local%apps\apache-maven-3.5.2\bin
set PATH=%PATH%;%dev_local%apps\git\bin
set PATH=%PATH%;%dev_local%java\jdk1.8.0_152

set JAVA_HOME=%dev_local%java\jdk1.8.0_152

cd /d %dev_path%
REM start "" mvn clean assembly:assembly -DdescriptorId=jar-with-dependencies -source 8
start "" mvn clean package install
timeout /t 15
echo Kopiowanie na pulpit...
REM copy /y target/Aplikacja.jar %userprofile%\desktop\
taskkill /F /IM cmd.exe
exit