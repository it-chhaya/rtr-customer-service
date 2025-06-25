package dev.chhaya.customer.config;

import dev.chhaya.customer.client.JsonPlaceholderClient;
import dev.chhaya.customer.client.PlatziFakeStoreClient;
import dev.chhaya.customer.util.HttpInterfaceWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class HttpInterfaceWebClientConfig {

    private final HttpInterfaceWebClient httpInterfaceWebClient;

    @Bean
    public PlatziFakeStoreClient platziFakeStoreClient() {
        return httpInterfaceWebClient
                .createClient(
                        "https://api.escuelajs.co/api/v1",
                        PlatziFakeStoreClient.class
                );
    }

    @Bean
    public JsonPlaceholderClient jsonPlaceholderClient() {
        return httpInterfaceWebClient
                .createClient(
                        "https://jsonplaceholder.typicode.com",
                        JsonPlaceholderClient.class
                );
    }

}
