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
     Далее запускаем Kafka<br>
     {KAFKA_HOME}/bin/kafka-server-start.sh {KAFKA_HOME}/config/server.properties<br>
  </li>  
</ol>

# Запуск producer
В терминале переходим в корень проекта<br>
И исполняем<br>
mvn spring-boot:run<br>

# Запуск consumer
Аналогично, только<br>
mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.com.example.consumer=DEBUG<br>

# Проверка
Надеюсь, все заработало<br>
<br>
Открываем какой-нибудь rest клиент<br>
И отправляем PUT запрос: <br>
content-type: application/json<br>
http://localhost:8080/test/225eeda1-b71e-4836-b009-c532873d9021/<br>
Пример body:<br>
{
  "name": "name",
  "sum": 1,
  "multiplier": 2
}
