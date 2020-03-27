#/bin/bash

cd $(dirname $0)/..

ROOT_DIR=$(git rev-parse --show-toplevel)

cd $ROOT_DIR
mkdir -p build
rm -rf build/*
cd $ROOT_DIR/src/
jar cf ../build/jcommon.jar ./erostamas/common/udp_messenger/* ./erostamas/common/interfaces/*
