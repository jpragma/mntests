FROM openjdk:14-alpine
COPY build/libs/kafka-eager-init-demo-*-all.jar kafka-eager-init-demo.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "kafka-eager-init-demo.jar"]