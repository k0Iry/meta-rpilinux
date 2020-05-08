DISTRO_FEATURES_append += "bluetooth \
                           wifi"

IMAGE_INSTALL_append += "linux-firmware-rpidistro-bcm43455 \
                         hostapd \
                         dhcp-server \
                         iptables \
                         gettext \
                         shadowsocks-libev \
                         wpa-supplicant"
