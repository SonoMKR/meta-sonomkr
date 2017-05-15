FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.4:"

SRC_URI += "file://0001-add-SonoMKR-audio-card-support.patch"

KERNEL_DEVICETREE_append = " overlays/sonomkr-card-overlay.dtb \
"

