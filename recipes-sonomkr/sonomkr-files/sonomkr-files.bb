SUMMARY = "copy The SonoMKR Project's files to rootfs"
SECTION = "base"
LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENCE;md5=b6b333b0d50db48b3e0b9e04b53801af"

SRC_URI = "file://default.ini \
   file://sonomkr.conf \
   file://LICENCE \
"

do_install () {
   #install -d ${D}${bindir}
   install -d ${D}${sysconfdir}
   install -d ${D}${sysconfdir}/modules-load.d
   install -d ${D}${ROOT_HOME}/configs
   install -d ${D}$/media/card

   #install -m 755 ${WORKDIR}/SonoMKR ${D}${bindir}/
   install -m 755 ${WORKDIR}/default.ini ${D}${ROOT_HOME}/configs/
   install -m 755 ${WORKDIR}/sonomkr.conf ${D}${sysconfdir}/modules-load.d/
}

FILES_${PN} = "${sysconfdir}/modules-load.d/sonomkr.conf \
	${ROOT_HOME}/configs/default.ini \
"

INHIBIT_PACKAGE_STRIP = "1"
