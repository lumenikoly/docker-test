# docker-test
This is a simple project to learn Docker

Укажите конфигурацию для Spring Boot в файле "application.properties".
По умолчанию файл содержит: server.port=7776

Пример:

1) docker image build -t test-img .
2) docker container run -d -p 8080:7776 test-img

Для проверки выполните команду "curl localhost:8080"
