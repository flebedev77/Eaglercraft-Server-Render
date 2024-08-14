@echo off
title EAGLERCRAFT v1.8
start .\bungeeserver.bat
start .\mcserver.bat

ngrok http --domain=casual-mouse-main.ngrok-free.app 8081