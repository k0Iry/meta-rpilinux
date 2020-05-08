DESCRIPTION = "AArch64 image for raspberrypi 4 which contains fundamental components"


require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += "e2fsprogs \
                  openssh \
                  openssl \
                  libsodium \
                  mbedtls \
                  libev \
                  c-ares \
                  c-ares-dev \
                  openssh-sftp-server"
