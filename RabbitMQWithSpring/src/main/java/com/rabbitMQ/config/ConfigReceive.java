package com.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReceive {
    public static final String QUEUE_NAME = "queue_name";
    public static final String EXCHANGE_NAME = "exchange_name";
    public static final String ROUTING_KEY = "rabbitmq.*";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME,false);
    }

    @Bean
    TopicExchange topicExchange () {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue,TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
