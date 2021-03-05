DESCRIPTION = "Fingerprint library used by AcoustID"
HOMEPAGE = "https://github.com/acoustid/chromaprint"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=5d50f7a9fde1110fa1756b0f5faa26f2"

SRC_URI = "https://github.com/acoustid/chromaprint/archive/v1.5.0.tar.gz"
SRC_URI[md5sum] = "77f133f01047c54605e7f2fccd96ff34"
SRC_URI[sha256sum] = "5c8e0d579cb3478900699110aa961c1552a422a18741cf67dd62136b1b877c7b"

S = "${WORKDIR}/chromaprint-1.5.0"

inherit cmake

PACKAGECONFIG ??= "fftw"
PACKAGECONFIG[ffmpeg] = "-DFFT_LIB=ffmpeg,,ffmpeg"
PACKAGECONFIG[fftw] = "-DFFT_LIB=fftw3,,fftw"
PACKAGECONFIG[kissfft] = "-DFFT_LIB=kissfft,,"
