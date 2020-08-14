#!/bin/sh

USER=admin
SERVICEPATH=/home/admin
SERVICE=$(cd $(dirname $0); pwd | awk -F '/' '{print $(NF)}')
MEMORY=512m
if [[ -f $SERVICEPATH/${SERVICE}/args.sh ]];then
    source $SERVICEPATH/${SERVICE}/args.sh
else
    ARGS=''
fi
GCLOG="-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:${SERVICEPATH}/${SERVICE}/${SERVICE}.gc  "
HEAPDUMP="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${SERVICEPATH}/${SERVICE}/${SERVICE}.heap"

Start() {
    proc=$(ps -ef | grep ${SERVICEPATH}/${SERVICE}/${SERVICE}.jar | grep -v grep | wc -l)
    if [[ $proc != 0  ]];then
        exit 5
    fi
    if [[ `whoami` == 'root' ]];then
        exec su admin -c "java -server -Xms${MEMORY} -Xmx${MEMORY} ${GCLOG}  ${HEAPDUMP}  $ARGS -jar ${SERVICEPATH}/${SERVICE}/${SERVICE}.jar >> ${SERVICEPATH}/${SERVICE}/${SERVICE}.log 2>&1 &"
    elif [[ `whoami` == 'admin' ]];then
        exec java -server -Xms${MEMORY} -Xmx${MEMORY} ${GCLOG}  ${HEAPDUMP} $ARGS -jar ${SERVICEPATH}/${SERVICE}/${SERVICE}.jar  >> ${SERVICEPATH}/${SERVICE}/${SERVICE}.log 2>&1 &
    else
        echo "Run with admin user"
        exit 10
    fi
}

Stop() {
    ps -ef | grep ${SERVICEPATH}/${SERVICE}/${SERVICE}.jar | grep -v grep | awk '{print $2}'| xargs kill
    sleep 3
    proc=$(ps -ef | grep ${SERVICEPATH}/${SERVICE}/${SERVICE}.jar | grep -v grep | wc -l)
    if [[ $proc != 0 ]];then
        ps -ef | grep ${SERVICEPATH}/${SERVICE}/${SERVICE}.jar | grep -v grep | awk '{print $2}'| xargs kill -9
    fi
}

Restart() {
    Stop
    Start
}

case $1 in
    start|run)
        Start
        ;;
    stop)
        Stop
        ;;
    restart)
        Restart
        ;;
    *)
        Start
        ;;
esac