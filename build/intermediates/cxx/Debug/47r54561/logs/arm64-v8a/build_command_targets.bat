@echo off
"F:\\Android\\Sdk\\ndk\\25.2.9519653\\ndk-build.cmd" ^
  "NDK_PROJECT_PATH=null" ^
  "APP_BUILD_SCRIPT=F:\\DeepSeek\\Cpp\\DroidGEN\\jni\\Android.mk" ^
  "NDK_APPLICATION_MK=F:\\DeepSeek\\Cpp\\DroidGEN\\jni\\Application.mk" ^
  "APP_ABI=arm64-v8a" ^
  "NDK_ALL_ABIS=arm64-v8a" ^
  "NDK_DEBUG=1" ^
  "APP_PLATFORM=android-19" ^
  "NDK_OUT=F:\\DeepSeek\\Cpp\\DroidGEN\\build\\intermediates\\cxx\\Debug\\47r54561/obj" ^
  "NDK_LIBS_OUT=F:\\DeepSeek\\Cpp\\DroidGEN\\build\\intermediates\\cxx\\Debug\\47r54561/lib" ^
  "APP_CFLAGS+=-std=c99 -fPIC -O2 -w" ^
  "APP_CPPFLAGS+=-std=c++11 -fPIC -O2 -w" ^
  "NDK_APPLICATION_MK:=jni/Application.mk" ^
  genesis ^
  gnupng ^
  zip
