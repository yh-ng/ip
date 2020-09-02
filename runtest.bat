@ECHO OFF

REM create bin directory if it doesn't exist
if not exist C:\cs2113\ip\bin mkdir C:\cs2113\ip\bin

REM delete output from previous run
del ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp C:\cs2113\ip\src -Xlint:none -d C:\cs2113\ip\bin C:\cs2113\ip\src\main\java\Duke.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath C:\cs2113\ip\bin Duke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT