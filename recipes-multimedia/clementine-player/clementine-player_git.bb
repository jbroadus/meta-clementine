DESCRIPTION = "Clementine Music Player"
HOMEPAGE = "https://www.clementine-player.org/"
SECTION = "multimedia"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://git@github.com/clementine-player/Clementine.git;protocol=https"
SRCREV = "2d8a56b7c8d8522a9987fbcbbe0f5d6787f0147a"

S = "${WORKDIR}/git"
PV = "1.4.0rc1-484"

inherit cmake

DEPENDS = " \
  boost \
  glib-2.0 \
  gstreamer1.0 \
  gstreamer1.0-plugins-base \
  libcdio \
  libchromaprint \
  protobuf-native \
  virtual/gettext-native \
  virtual/libgl \
"