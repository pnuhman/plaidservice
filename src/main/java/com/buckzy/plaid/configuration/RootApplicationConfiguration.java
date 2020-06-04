package com.buckzy.plaid.configuration;

import com.buckzy.core.configuration.datasource.DataSourceConfiguration;
import com.buckzy.core.messaging.MessageSender;
import com.buckzy.core.messaging.kafka.producer.impl.KafkaMessageSenderImpl;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Import(DataSourceConfiguration.class)
@Configuration
@ComponentScan(basePackages = {"com.buckzy.plaid", "com.buckzy.core"})
@EnableScheduling
@DependsOn("databaseProperties")
public class RootApplicationConfiguration {

    @Value("${buckzy.account.kafka.url}")
    private String BOOTSTRAP_SERVERS_CONFIG;

    @Autowired
    private Environment environment;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "kafkaSender")
    @DependsOn("databaseProperties")
    public MessageSender kafkaSender() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "PLAID_PRODUCER_" + environment.getProperty("BUCKZY.INSTANCE.ID"));
        props.put("BUCKZY.INSTANCE.ID", environment.getProperty("BUCKZY.INSTANCE.ID"));
        props.putAll(KafkaMessageSenderImpl.getDefaultProducerProperties());

        KafkaMessageSenderImpl kafkaMessageSender = new KafkaMessageSenderImpl(props);

        return kafkaMessageSender;
    }

}