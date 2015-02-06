# Based on the Fedora image
FROM abien/base-java-server
MAINTAINER Adam Bien, adam-bien.com
ENV WILDFLY_HOME ./wildfly-8.2.0.Final
ADD ${WILDFLY_HOME}.zip ./
RUN unzip ${WILDFLY_HOME}.zip
RUN rm ${WILDFLY_HOME}/bin/standalone.conf
ADD standalone.conf ${WILDFLY_HOME}/bin/
RUN chmod a+x ${WILDFLY_HOME}/bin/standalone.sh
ADD start.sh ./start.sh
RUN chmod +x ./start.sh
RUN cp ./ping.war ${WILDFLY_HOME}/standalone/deployments/
EXPOSE 8080 9900 5701 1099 2099 22
