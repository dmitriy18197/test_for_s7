# Необходимо:
<ul>
  <li>Желательно Linux</li>
  <li>JDK 8+</li>
  <li>Zookeeper + Kafka</li>
  <li>Maven/li>
  <li>Все переменные окружения должны быть заданы</li> 
</ul>

# Запуск Kafka
<ol>
  <li>
    Чтобы запустить Zookeeper в терминале исполняем<br>
    {ZOOKEPER_HOME}/bin/zkServer.sh start<br>
  </li>
  <li>
     Далее запускаем Kafka
     {KAFKA_HOME}/bin/kafka-server-start.sh {KAFKA_HOME}/config/server.properties
  </li>  
</ol>

# Запуск producer
В терминале переходим в корень проекта
И исполняем
mvn spring-boot:run

# Запуск consumer
Аналогично, только
mvn spring-boot:run -Dspring-boot.run.arguments==-loggging.level.com.example.consumer=DEBUG

# Проверка
Надеюсь, все заработало

Открываем какой-нибудь rest клиент
И отправляем PUT запрос:
content-type: application/json
http://localhost:8080/test/225eeda1-b71e-4836-b009-c532873d9021/
Пример body:
{
  "name": "name",
  "sum": 1,
  "multiplier": 2
}
