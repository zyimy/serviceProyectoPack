FROM openjdk:11
COPY "./target/restaurante.jar" "app.jar"
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]

