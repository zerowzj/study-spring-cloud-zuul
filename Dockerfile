#
FROM frolvlad/alpine-java:jdk8-slim
#
LABEL maintainer="wangzhj<zerowzj@163.com>" app="study-springcloud-zuul"
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
WORKDIR ${DEPLOY_DIR}
ENTRYPOINT ["java", "-jar", "study-springcloud-zuul-1.0.jar"]