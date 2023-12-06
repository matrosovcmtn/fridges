package ru.matrosov.fridges.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource getDataSource() {
        int[] ports = {5432};
        var pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("password");
        pgSimpleDataSource.setURL("jdbc:postgresql://postgres:5432/fridge");
        pgSimpleDataSource.setPortNumbers(ports);
        pgSimpleDataSource.setConnectTimeout(30);
        return pgSimpleDataSource;
    }
}
