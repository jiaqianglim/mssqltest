package com.visa;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DataSource ds = DataSourceBuilder.create().driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .url("jdbc:sqlserver://DESKTOP-QH3209C;database=ONIPortal;encrypt=false;trustServerCertificate=true")
                .username("MSSQLSERVER")
                .password("MSSQLSERVER").build();
        return new JdbcTemplate(ds);
    }
}
