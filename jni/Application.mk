APP_BUILD_SCRIPT = $(APP_PROJECT_PATH)/Android.mk

#LOCAL_JNI_SHARED_LIBRARIES := libzip libpng

#APP_OPTIM := debug
APP_OPTIM := release

#APP_STL := gnustl_static
#APP_STL := stlport_static

APP_ABI := armeabi-v7a arm64-v8a
APP_PLATFORM := android-19
APP_CFLAGS := -std=c99 -O0 -g -fPIC -w
APP_CPPFLAGS := -std=c++11 -O0 -g -fPIC -w
APP_LDFLAGS := -fPIC
APP_STL := c++_static
#APP_ABI := armeabi
APP_ABI := armeabi-v7a

#APP_CPPFLAGS += -fexceptions
 
# Use Crystax 4.6.3 toolchain ? 
APP_TOOLCHAIN_VERSION := 4.4.3

compile-s-source = $(eval $(call ev-compile-c-source,$1,$(1:%.s=%.o)))

#JNI_H_INCLUDE = $(APP_PROJECT_PATH)/../common/libnativehelper/include/