#!/bin/bash

DEPLOY_DIR=/app/study-springcloud-zuul
JAR_FILE=$DEPLOY_DIR/study-springcloud-zuul-1.0.jar
LOG_FILE=$DEPLOY_DIR/stdout.log

JAVA_MEM_OPTS=" -server -Xms512M -Xmx512M -Xmn128M -Xss128M -XX:PermSize=128M -XX:MaxPermSize=512M"
JAVA_GC_OPTS=" -XX:+PrintGC -XX:PrintGCDetails -XX:PrintGCTime"
JAVA_OPTS=$JAVA_MEM_OPTS

get_pid() {
  pid=$(ps -ef | grep $JAR_FILE | grep -v grep | awk '{ print $2 }')
  echo "===> $pid"
}
start() {
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    nohup java $JAVA_OPTS -jar $JAR_FILE >$LOG_FILE 2>&1 &
  fi
}
stop() {
  pid=$(get_pid)
  if [ -n "$pid" ]; then
    kill -9 $pid
  fi

}

case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
*)
  echo "Usage: $0 {start|stop}"
  ;;
esac
