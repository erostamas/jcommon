#/bin/bash

$(dirname $0)/make_jar.sh

cd $(dirname $0)/..

ROOT_DIR=$(git rev-parse --show-toplevel)

sudo mkdir -p /usr/lib/erostamas/
sudo cp ${ROOT_DIR}/build/jcommon.jar /usr/lib/erostamas/

