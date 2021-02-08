# kafka-spring-base-test
Test project including consumer + producer + admin (to see the messages)

## Tests:
Check the branches that includes changes to the configuration on the producer and consumer to test different scenarios

Consumer, run app on another port
```
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085
```

| Test Id | Test | Result |
| :---: | :---: | :---: |
| 1 | Multiple earliest test |  |
| 1.1 | Earliest + messages, then shutdown consumer, then publishes multiple messages, then re-connect consumer | The property `auto.offset.reset` is used when the consumer doesn't know the offset that has been used, will need more tests |
| 1.2 | Normal + earliest, then shutdown earliest consumer, then publishes multiple messages (normal will catch), then re-connect consumer | Will need more tests |
| 2 | Balance consumer groups | This requires multiple partitions and multiple brokers (given that each consumer will be balanced among all the ) |
| 3 | Message as JSON (using jackson) |  |
| 4 | Multiple brokers |  |
| 4.1 | Multiple brokers test (at least once) |  |
| 4.2 | Multiple brokers test (at most once) |  |
| 4.3 | Multiple brokers test (exactly once) |  |
| 5 | Multiple brokers, change ack behavior |  |
| 6 | Autocommit state |  |
| 7 | Lag example | The lag is the number of messages that a consumer group is behind the offset of the last messages |
| 8 | Aggregates |  |
| 9 | Message as Protobuff |  |

## Refs:
- https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html
- https://www.baeldung.com/spring-kafka
- https://github.com/confluentinc/cp-all-in-one/blob/6.0.1-post/cp-all-in-one/docker-compose.yml
- https://kafka.apache.org/documentation/
