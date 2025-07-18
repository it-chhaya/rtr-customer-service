package dev.chhaya.customer.config;

import dev.chhaya.customer.config.props.DatabaseProps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DatasourceConfig {

    private final DatabaseProps databaseProps;

    @Bean
    @RefreshScope
    public DataSource pgDataSource() {
        log.info("pgDataSource is configured");
        return DataSourceBuilder
                .create()
                .driverClassName(databaseProps.getDriver())
                .url(databaseProps.getUrl())
                .username(databaseProps.getUsername())
                .password(databaseProps.getPassword())
                .build();
    }

}
