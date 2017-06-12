SUMMARY = "The SonoMKR CLI"
DESCRIPTION = "This package builds and deploys The SonoMKR Project's CLI software."
HOMEPAGE = "http://www.sonomkr.fr/"
LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=3e00ca6129dc8358315015204ab9fe15"

RDEPENDS = "python"

SRCREV = "5628faef223feefc804c547492ee35f297ff7b5c"
SRC_URI = "git://github.com/SonoMKR/sonomkrctl.git"

S = "${WORKDIR}/git"

do_install () {
   install -d ${D}${bindir}

   install -m 755 ${S}/sonomkrctl ${D}${bindir}/
}

FILES_${PN} = "${bindir}/sonomkrctl \
"

INHIBIT_PACKAGE_STRIP = "1"