DESCRIPTION = "libev port of shadowsocks"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "pcre c-ares mbedtls libev libsodium"
RDEPENDS_${PN} = "bash"
PR = "r0"

SRC_URI = "gitsm://github.com/shadowsocks/shadowsocks-libev.git;protocol=https;tag=v${PV}"

S = "${WORKDIR}/git"

inherit autotools

LDFLAGS += "-L${STAGING_LIBDIR}"
CFLAGS += "-L${STAGING_LIBDIR} -I${STAGING_INCDIR}"

do_configure() {
	cd ${S}
        ./autogen.sh
	oe_runconf --disable-documentation
}

do_compile() {
        cd ${S}/libbloom
        make clean
        oe_runmake -C ${S} CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
        cd ..
        oe_runmake -C ${S} CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
        mkdir -p ${D}/${bindir}
        install -m 0755 ${S}/src/ss-local ${D}/${bindir}
        install -m 0755 ${S}/src/ss-manager ${D}/${bindir}
        install -m 0755 ${S}/src/ss-server ${D}/${bindir}
        install -m 0755 ${S}/src/ss-redir ${D}/${bindir}
        install -m 0755 ${S}/src/ss-tunnel ${D}/${bindir}
        install -m 0755 ${S}/src/ss-nat ${D}/${bindir}
}
do_populate_lic[noexec] = "1"
