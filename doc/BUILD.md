# Build
Instructions are for a Linux environment supported by Yocto.
Can also be built on Windows under WSL2.

To get the build the Glowforge firmware you need to have `repo` installed:

## Install the `repo` utility:

```console
mkdir ~/.bin
curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
chmod a+x ~/.bin/repo
PATH=${PATH}:~/.bin
```
Add the following to the end of ```~/.bashrc``` to permanently add ```repo``` to your path:
```console
export PATH=~/.bin:$PATH
```
## Download the BSP source:

```console
mkdir glowforge-gpl
cd glowforge-gpl
repo init -u https://github.com/ScottW514/meta-glowforge-gpl.git -b master -m default.xml
repo sync
```

At the end of the commands you have all meta packages you need to build the basic firmware images.

## Build the Glowforge frimware image
First time environment setup:
```console
(in glowforge-gpl directory)
MACHINE=glowforge DISTRO=glowforge-factory . setup-environment build
bitbake glowforge-image
```
Subsequent builds:
```console
(in glowforge-gpl directory)
. setup-environment build
bitbake glowforge-image
```

## Bootable Image:
The bootable image can be found in ```glowforge-gpl/build/tmp/deploy/images/```.

It can be written directly to an SDCARD:
```console
(in glowforge-gpl/build directory)
cd tmp/deploy/images/glowforge
sudo zcat glowforge-image-glowforge.wic.gz | dd of=/dev/sdX bs=1M
```
