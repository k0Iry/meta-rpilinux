DISTRO_FEATURES_append += "bluetooth \
                           wifi \
                           virtualization"

IMAGE_INSTALL_append += "linux-firmware-rpidistro-bcm43455 \
                         hostapd \
                         dhcp-server \
                         iptables \
                         gettext \
                         wpa-supplicant \
                         docker-ce"
