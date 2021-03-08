FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://Add-Glowforge-to-Arch-Kconfig.patch \
	file://git/ \
	file://fw_env.config \
	file://uEnv.txt \
"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 644 ${WORKDIR}/uEnv.txt ${D}${sysconfdir}/uEnv.txt
}

FILES_${PN}-env += " \
    ${sysconfdir}/uEnv.txt \
"

COMPATIBLE_MACHINE = "glowforge"
