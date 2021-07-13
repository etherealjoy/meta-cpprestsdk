HOMEPAGE    = "https://github.com/Microsoft/cpprestsdk"
SUMMARY     = "C++ REST SDK"
DESCRIPTION = "The C++ REST SDK is a Microsoft project for cloud-based \
    client-server communication in native code using a modern asynchronous C++ \
    API design. This project aims to help C++ developers connect to and interact with services. \
   "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/license.txt;md5=a2e15b954769218ff912468eecd6a02f"

SRCREV_cpprestsdk = "122d09549201da5383321d870bed45ecb9e168c5"
SRC_URI = "gitsm://github.com/Microsoft/cpprestsdk.git;branch=master;name=cpprestsdk"

CPPRESTSDK_VERSION = "2.10.18"
PV = "${CPPRESTSDK_VERSION}+git${SRCREV_cpprestsdk}"
PR = "r0"

DEPENDS += " \
    openssl  \
    boost    \
"
S = "${WORKDIR}/git/Release"

EXTRA_OECMAKE += "-DWERROR=OFF -DBUILD_TESTS=OFF -DBUILD_SAMPLES=OFF"
inherit cmake pkgconfig

FILES_${PN} = "          \
    ${libdir}/lib*.so    \
    ${libdir}/lib*.so.*  \
    "

FILES_${PN}-dev = "         \
    ${includedir}/*         \
    ${includedir}/cpprest/* \
    ${includedir}/pplx/*    \
    ${libdir}/cpprestsdk    \
    ${libdir}/cpprestsdk/*  \
    usr/lib/cmake/cpprestsdk/*  \
    "
INSANE_SKIP_${PN} += "dev-so"
INSANE_SKIP_${PN} += "dev-elf"

BBCLASSEXTEND = "nativesdk"
 

