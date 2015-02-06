#!/bin/bash
echo '------- Starting wildfly  -------'
java -version
env
ip addr
cat /etc/hosts
${WILDFLY_HOME}/bin/standalone.sh -b=0.0.0.0 &
#jstatd -J-Djava.security.policy=jstatd.all.policy &
/usr/sbin/sshd -D