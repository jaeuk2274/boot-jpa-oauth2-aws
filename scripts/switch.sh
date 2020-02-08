#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
    IDLE_PORT=$(find_idle_port)

    echo "> 전환할 Port: $IDLE_PORT"
    echo "> Port 전환"
    echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc

    echo "> 엔진엑스 Reload"
    sudo service nginx reload
    # reload 는 restart와 다르다. 끊김 없이 다시 불러온다.
    # 하지만 중요 설정들은 반영되지 않으므로 restart 사용해야 하는 경우.(여기서는 그냥 설정 파일만 불러오는 거라 상관 없음)
}