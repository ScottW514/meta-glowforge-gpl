DESCRIPTION = "Glowforge Kernel Module"
LICENSE = "GPLv2"

PV = "0.0.1"

SRC_URI = "git://github.com/Glowforge/kernel-module-glowforge.git;protocol=https"
SRCREV = "1fa67fc337b05e04104a143b399bcbd8dabf94fc"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/extras/
	install -m 0644 *.ko ${D}/lib/modules/${KERNEL_VERSION}/extras/
}
COMPATIBLE_MACHINE = "glowforge"
