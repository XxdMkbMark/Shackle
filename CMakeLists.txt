cmake_minimum_required(VERSION 3.23)
project(Shackle)

set(CMAKE_CXX_STANDARD 17)

add_executable(Shackle Shackle/Shackle.cpp src/level/Level.cpp src/level/Level.h)

#include(FetchContent)
#FetchContent_Declare(
#        tomlplusplus
#        GIT_REPOSITORY https://github.com/marzer/tomlplusplus.git
#        GIT_TAG        v3.2.0
#)
#FetchContent_MakeAvailable(tomlplusplus)
#add_subdirectory(Data)