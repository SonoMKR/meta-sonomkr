do_deploy_append() {
echo "dtparam=audio=on" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "dtparam=i2s=on" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "dtoverlay=sonomkr-card" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}