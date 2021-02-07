# kafka-spring-base-test
Test project including consumer + producer + admin (to see the messages)

## Test 0.1
Change Consumer config in order to allow the new consumers that joins Kafka to read all the existing messages on the queue:
```
AUTO_OFFSET_RESET_CONFIG, "earliest"
```
