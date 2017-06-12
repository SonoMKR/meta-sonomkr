SUMMARY = "The SonoMKR Project Software"
DESCRIPTION = "This package builds and deploys The SonoMKR Project's main software."
HOMEPAGE = "http://www.sonomkr.fr/"
LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=3e00ca6129dc8358315015204ab9fe15"

DEPENDS += " nodejs dbus"
RDEPENDS_${PN} += " nodejs dbus bash"

SRCREV = "2bb3f2673184d7e3882d6d074da76bdc34e6aa1d"
SRC_URI = "git://github.com/SonoMKR/sonomkr-api.git"

S = "${WORKDIR}/git"

inherit npm-base

do_install() {
	oe_runnpm install     # Installs dependencies defined in package.json

    install -d ${D}/opt/sonomkr-api

    cp -r ${S}/* ${D}/opt/sonomkr-api/
    chmod -R 0755 ${D}/opt/sonomkr-api
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP_${PN} += "staticdev"

PACKAGES = "${PN}"

FILES_${PN} = "/opt/sonomkr-api/*"
