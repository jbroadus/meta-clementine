SUMMARY = "Test image for meta-clementine"

LICENSE = "MIT"

require recipes-core/images/core-image-minimal-xfce.bb

export IMAGE_BASENAME = "clementine-image"

IMAGE_INSTALL += " \
    clementine-player \
"
