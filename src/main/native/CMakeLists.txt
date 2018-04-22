cmake_minimum_required(VERSION 3.5)

project(crypto)
set(CMAKE_BUILD_TYPE Release)
set(CMAKE_CXX_STANDARD 11)

# Java JNI
find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

# source files
set(SOURCE_FILES org_semux_evmc_jni_Native.cpp)

# build
add_library(evmcjni SHARED ${SOURCE_FILES})