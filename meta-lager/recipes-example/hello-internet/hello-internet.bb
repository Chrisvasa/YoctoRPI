SUMMARY = "Simple hello-internet application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SRC_URI = "file://hello-internet.service"

S = "${WORKDIR}"

do_compile() {
    # No compilation needed for the systemd service
    :
}

do_install() {
    # Install the systemd service file
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/hello-internet.service ${D}${systemd_system_unitdir}
}

# Automatically enable the service
SYSTEMD_AUTO_ENABLE = "enable"

# Specify the systemd service file
SYSTEMD_SERVICE = "hello-internet.service"

# Include the service file in the main package
FILES_${PN} += "${systemd_system_unitdir}/hello-internet.service"

