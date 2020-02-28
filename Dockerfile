#
FROM frolvlad/alpine-java:jdk8-slim
#
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#
ARG JAR_FILE
ENV DEPLOY_DIR=/app
#
RUN mkdir ${DEPLOY_DIR}
ADD ${JAR_FILE} ${DEPLOY_DIR}
#
ENTRYPOINT ["java", "-jar", "/app.jar"]
