# 第一阶段：用 Maven 编译打包
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 第二阶段：用轻量 JRE 运行
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/springboot-learning-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7860
ENTRYPOINT ["java", "-Xmx256m", "-Dserver.port=7860", "-jar", "app.jar"]