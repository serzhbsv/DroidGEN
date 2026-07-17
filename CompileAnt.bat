SET JAVA_HOME=F:\JAVA\openjdk\openjdk-1.8.0_x64
SET PATH=%PATH%;F:\JAVA\ant\bin;F:\JAVA\ant\lib;F:\JAVA\openjdk\openjdk-1.8.0_x64\bin;F:\Android\Sdk\ndk\30.0.14904198
call ndk-build
call ant debug
pause