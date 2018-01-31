@echo off
git pull
set com=
set /p com=Mettez le commentaire: 
git add .
git commit -m "%com%"
git push
pause