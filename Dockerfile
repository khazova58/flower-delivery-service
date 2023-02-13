FROM openjdk:17
#базовый образ с установленной openjdk

ARG JAR_FILE=target/flower-delivery-service-0.0.1-SNAPSHOT.jar
#Переменной JAR_FILE присваивается путь к jar- архиву

WORKDIR /app
#Назначаем рабочую директорию

COPY ${JAR_FILE} fdsApp.jar
#Наш jar-файл, указанный в JAR_FILE, копируется в папку app, и копии задаётся имя app.jar

ENTRYPOINT ["java", "-jar", "/app/fdsApp.jar"]
#запуск файла