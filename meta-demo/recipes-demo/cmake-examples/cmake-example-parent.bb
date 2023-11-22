SUMMARY = "The cmake-examples project from the previous demo on CMake"
PV = "1.0.0"
LICENSE = "CLOSED"

inherit cmake

SRC_URI = "git://github.com/dvnrrs/cmake-examples;protocol=https;branch=main"
SRCREV = "7ea96ced8d5bbe879bca21b9794574d13722126f"
S = "${WORKDIR}/git"

DEPENDS = "cmake-example-child"

OECMAKE_SOURCEPATH = "${S}/5-consuming-packages"
