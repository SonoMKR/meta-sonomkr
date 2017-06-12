SUMMARY = "The SonoMKR Project Software"
DESCRIPTION = "This package builds and deploys The SonoMKR Project's main software."
HOMEPAGE = "http://www.sonomkr.fr/"
LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=3e00ca6129dc8358315015204ab9fe15"

PR = "r01"

DEPENDS = "ncurses alsa-lib qtbase"

SRCREV = "42ffb722ccc4590e2a0fae3319ca98ec9e2c2c30"
SRC_URI = "git://github.com/SonoMKR/sonomkr-daemon.git"

S = "${WORKDIR}/git"

PARALLEL_MAKEINST = ""

do_install_append() {
    install -d ${D}${bindir}
    install -d ${D}/etc/dbus-1/system.d
    install -d ${D}/usr/share/dbus-1/system-services
    install -d ${D}/lib/systemd/system

    install -m 0755 ${WORKDIR}/build/sonomkrd ${D}${bindir}/
    install -m 0755 ${S}/sonomkrd.conf ${D}/etc/dbus-1/system.d/
    install -m 0755 ${S}/fr.sonomkr.service ${D}/usr/share/dbus-1/system-services
    install -m 0755 ${S}/sonomkr.service ${D}/lib/systemd/system
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

PACKAGES = "${PN}"

FILES_${PN} = "${bindir}/sonomkrd /etc/dbus-1/system.d/sonomkrd.conf /usr/share/dbus-1/system-services/fr.sonomkr.service /lib/systemd/system/sonomkr.service"

inherit qmake5
