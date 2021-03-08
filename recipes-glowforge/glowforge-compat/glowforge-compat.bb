SUMMARY = "Odds and Ends to make the Glowforge image work"
DESCRIPTION = "Things needed to get the Glowforge process to run"

LICENSE = "GPLv2"
LICENSE_PATH = "${S}"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
  file://99-glowforge.rules \
  file://ov5648_camera_slave_mipi.conf \
  file://glowforge-compat.init \
  file://glowforge-compat.list \
  file://glowforge-compat.version \
"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "glowforge-compat"
INITSCRIPT_PARAMS_${PN} = "start 01 1 2 3 4 5 . stop 01 1 ."

do_install() {
  install -d ${D}${sysconfdir}
  install -d ${D}${sysconfdir}/udev/rules.d
  install -d ${D}${sysconfdir}/modules-load.d
  install -d ${D}${INIT_D_DIR}
	install -m 644 ${WORKDIR}/99-glowforge.rules ${D}${sysconfdir}/udev/rules.d/99-glowforge.rules
	install -m 644 ${WORKDIR}/ov5648_camera_slave_mipi.conf ${D}${sysconfdir}/modules-load.d/ov5648_camera_slave_mipi.conf
  install -Dm 0755 ${WORKDIR}/glowforge-compat.init ${D}${INIT_D_DIR}/glowforge-compat
  install -m 644 ${WORKDIR}/glowforge-compat.list ${D}${sysconfdir}/glowforge-compat.list
  install -m 644 ${WORKDIR}/glowforge-compat.version ${D}${sysconfdir}/glowforge-compat.version
}

FILES_${PN} = " \
  ${sysconfdir}/udev/rules.d/99-glowforge.rules \
  ${sysconfdir}/modules-load.d/ov5648_camera_slave_mipi.conf \
  ${INIT_D_DIR}/glowforge-compat \
  ${sysconfdir}/glowforge-compat.list \
  ${sysconfdir}/glowforge-compat.version \
"
