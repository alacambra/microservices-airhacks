# Based on the Fedora image
FROM mattdm/fedora:f20
MAINTAINER Adam Bien, adam-bien.com
RUN yum update -y
RUN yum clean all
RUN yum -y install wget
RUN yum -y install unzip
RUN yum -y install gettext
ADD ping.war ./ping.war
ADD jstatd.all.policy ./jstatd.all.policy
ADD jdk-8u25-linux-x64.tar.gz .
ENV JAVA_HOME /jdk1.8.0_25/
ENV PATH "$PATH":/jdk1.8.0_25/bin:.:
RUN ln -s /jdk1.8.0_25/bin/jjs /usr/bin/jjs