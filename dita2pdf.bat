rem echo off
setlocal
set DITA=C:\DITA\dita-ot-3.3.3\bin\dita.bat
rem for /D %%i in (pdfs\out\M*) do  %DITA% -i %%i\MIS_3287_Connector_PG_4.3.ditamap -f pdf -o pdfs\pdf\%%~ni.pdf
%DITA% -i dita/MIS_3287_Connector_PG_4.3/MIS_3287_Connector_PG_4.3.ditamap -f pdf -o pdfs/pdf
endlocal
echo on