DESCRIPTION = "Clementine Music Player"
HOMEPAGE = "https://www.clementine-player.org/"
SECTION = "multimedia"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://git@github.com/clementine-player/Clementine.git;protocol=https"
SRCREV = "15474ada398609164ab3ee6a769ef00556681134"
PV = "1.4.0rc1-487"

S = "${WORKDIR}/git"

inherit cmake_qt5 mime-xdg

DEPENDS = " \
    boost \
    glib-2.0 \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    libcdio \
    libchromaprint \
    libglu \
    protobuf-c \
    protobuf-native \
    qtbase \
    sqlite3 \
    virtual/gettext-native \
    virtual/libgl \
    ${@bb.utils.contains('DISTRO_FEATURES','x11','qtx11extras','',d)} \
"

RDEPENDS_${PN} = " \
    desktop-file-utils \
"

PACKAGECONFIG ??= "visualizations"
PACKAGECONFIG[visualizations] = "-DENABLE_VISUALISATIONS=ON,-DENABLE_VISUALISATIONS=OFF,glew"

PACKAGES += "${PN}-kde "

FILES_${PN} += "${datadir}/icons/* "
FILES_${PN} += "${datadir}/metainfo/clementine.appdata.xml "

FILES_${PN}-kde = "${datadir}/kservices5/* "

EXTRA_OECMAKE = "-DINSTALL_UBUNTU_ICONS=OFF"

do_install_append() {
    # Clean up after the 3rd party projectm installation.
    rm -rf ${D}/usr/share/clementine
}
