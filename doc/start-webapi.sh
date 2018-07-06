#!/bin/sh

PROJECT_NAME=demo-webapi
DEPLOY_HOME=/app/demo-webapi

pid=`ps -ef |grep $PROJECT_NAME |grep -v grep |awk '{print $2}'`

if [ -n "$pid" ]; then
    kill -9 $pid
    echo "------------------------------"
    echo "     Shutdown tomcat...       "
    echo "------------------------------"
fi

cd $DEPLOY_HOME/bin
sh startup.sh


