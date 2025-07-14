package dev.chhaya.customer;

import dev.chhaya.customer.config.props.ServiceInfoProps;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {
        ServiceInfoProps.class
})
@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
