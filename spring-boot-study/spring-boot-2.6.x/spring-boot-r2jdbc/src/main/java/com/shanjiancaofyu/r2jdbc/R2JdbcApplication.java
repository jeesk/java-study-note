package com.shanjiancaofyu.r2jdbc;

import com.shanjiancaofyu.r2jdbc.entity.Customer;
import com.shanjiancaofyu.r2jdbc.repository.CustomerRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class R2JdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(R2JdbcApplication.class, args);
    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("db/schema.sql"), new ClassPathResource("db/data-h2.sql")));

        return initializer;
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {

        return (args) -> {
            // save a few customers
            repository.saveAll(Arrays.asList(new Customer("Jack", "Bauer"),
                            new Customer("Chloe", "O'Brian"),
                            new Customer("Kim", "Bauer"),
                            new Customer("David", "Palmer"),
                            new Customer("Michelle", "Dessler")))
                    .blockLast(Duration.ofSeconds(10));

            repository.findAll().doOnNext(customer -> {
                System.out.println(customer.toString());
            }).blockLast(Duration.ofSeconds(10));


            // fetch an individual customer by ID
            repository.findById(1L).doOnNext(customer -> {
                System.out.println(customer.toString());
            }).block(Duration.ofSeconds(10));


            repository.findByLastName("Bauer").doOnNext(bauer -> {
                System.out.println(bauer.toString());
            }).blockLast(Duration.ofSeconds(10));
        };
    }
}
