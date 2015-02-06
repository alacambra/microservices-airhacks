FROM abien/wildfly
MAINTAINER Adam Bien, adam-bien.com
ADD porcupine-sample.war ${WILDFLY_HOME}/standalone/deployments/
EXPOSE 8080 5701 22
ENTRYPOINT ./start.sh