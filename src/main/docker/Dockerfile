FROM java:8
VOLUME /tmp


#WORKDIR /application/jenkins/deploy/src/main/docker
#RUN pwd

ADD sector-service-1.0-SNAPSHOT.jar sector-service.jar
ENTRYPOINT ["java","-Xms200m","-Xmx300m","-jar","/sector-service.jar"]