DESCRIPTION = "AArch64 image for raspberrypi 4 which contains fundamental components"


require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += "vim \
                  ntp \
                  e2fsprogs-resize2fs \
                  openssh \
                  openssl \
                  openssh-sftp-server"
