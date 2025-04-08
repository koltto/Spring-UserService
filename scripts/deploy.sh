#!/bin/bash

REPOSITORY=/home/ec2-user/service/app
PROJECT_NAME=Spring-UserService

CD $REPOSITORY

echo "> Build 파일 복사"

cp $REPOSITORY/$PROJECT_NAME/build/libs/$PROJECT_NAME-0.0.1-SNAPSHOT.jar $REPOSITORY/

echo "> 현재 구동중인 애플리케이션 pid 확인"

# 파라미터 이름의 프로세스 id를 찾는다.
CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)

echo "현재 구동중인 애플리케이션: $CURRENT_PID"

# -z : 문자열이 null 이면 참
if [ -z "$CURRENT_PID"]; then
	echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
	echo "> kill -9 $CURRENT_PID"
	kill -9 $CURRENT_PID
	sleep 5
fi

echo "> 새 애플리케이션 배포"

# jar 파일을 읽는다.
JAR_NAME=$PROJECT_NAME-0.0.1-SNAPSHOT.jar

echo "> JAR Name: $JAR_NAME"

# nohup : 프로세스를 데몬 형태로 실행하게 되어 사용자 세션이 끊어져도 종료되지 않고 계속 실행된다.
# 2>&1 : 표준 출력과 표준 에러를 같은 파일에 출력한다.
# $ : &를 맨 끝에 붙이면 프로세스를 백그라운드로 실행한다.
nohup java -jar $JAR_NAME > $REPOSITORY/userservice.log 2>&1 &


