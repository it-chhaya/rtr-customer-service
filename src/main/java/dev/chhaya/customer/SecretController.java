package dev.chhaya.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SecretController {

    @Value("${service.info}")
    private String secret;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @GetMapping("/secrets")
    public Map<String, Object> secret() {
        return Map.of("secret", secret,
                "url", dbUrl,
                "username", dbUsername,
                "password", dbPassword);
    }

}
