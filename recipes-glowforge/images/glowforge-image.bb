
DESCRIPTION = "OpenGlow image for Glowforge Factory Firmware"

LICENSE = "GPLv2"

inherit core-image

IMAGE_INSTALL = " \
	packagegroup-base \
	packagegroup-core-boot \
	kernel-devicetree \
	${CORE_IMAGE_EXTRA_INSTALL} \
	curl \
	dhcpcd \
	e2fsprogs \
	e2fsprogs-resize2fs \
	glowforge-compat \
	hostapd \
	htpdate \
	libv4lconvert-bayer \
	nano \
  ntp \
	openssh \
	python \
	u-boot-fw-utils \
	wlconf \
	wpa-supplicant \
	zstd \
"

create_dirs() {
	mkdir -p ${IMAGE_ROOTFS}/data
	mkdir -p ${IMAGE_ROOTFS}/factory
	mkdir -p ${IMAGE_ROOTFS}/factory/img1
	mkdir -p ${IMAGE_ROOTFS}/factory/img2
}
IMAGE_PREPROCESS_COMMAND += "create_dirs; "

link_boot_env() {
	cd ${IMAGE_ROOTFS}/boot
	ln -sf ../etc/uEnv.txt uEnv.txt
}
ROOTFS_POSTPROCESS_COMMAND += "link_boot_env; "
