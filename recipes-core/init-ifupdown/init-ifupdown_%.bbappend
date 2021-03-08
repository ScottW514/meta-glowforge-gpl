FILESEXTRAPATHS_append := "${THISDIR}/${PN}"

SRC_URI += "\
  file://interface-wlan0_ap \
  file://interface-wlan0_sta \
  file://interface-wlan0_sta-auto \
"

do_install_append () {
  install -d ${D}${sysconfdir}/network/
  install -m 0644 ${WORKDIR}/interface-wlan0_ap ${D}${sysconfdir}/network/interface-wlan0_ap
  install -m 0644 ${WORKDIR}/interface-wlan0_sta ${D}${sysconfdir}/network/interface-wlan0_sta
  install -m 0644 ${WORKDIR}/interface-wlan0_sta-auto ${D}${sysconfdir}/network/interface-wlan0_sta-auto
}

FILES_${PN} += " \
  ${sysconfdir}/network/interface-wlan0_ap \
  ${sysconfdir}/network/interface-wlan0_sta \
  ${sysconfdir}/network/interface-wlan0_sta-auto \
"
