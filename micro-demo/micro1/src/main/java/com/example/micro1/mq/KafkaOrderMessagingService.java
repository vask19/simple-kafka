package com.example.micro1.mq;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@Configuration
public class KafkaOrderMessagingService {
    private KafkaTemplate<String, TacoOrder> kafkaTemplate;

    public void sendOrder(TacoOrder order) {

        Properties kaProperties =
                new Properties();
        kaProperties.put("bootstrap.servers",
                "localhost:9092,localhost:9093,localhost:9094");
        kaProperties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        kaProperties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        try (Producer<String, String> producer =
                     new KafkaProducer<>(kaProperties)) {
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<>("kinaction_helloworld",
                            null, order.toString());
            producer.send(producerRecord);

        }
    }


}
