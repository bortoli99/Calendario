package br.goc.ac.sefaz.calendario.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfig {
    
    @Autowired
    Environment env;

    // @Bean
    // @Primary
    // public DataSource springDataSource(){
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
    
    //     dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
    //     dataSource.setUrl(env.getProperty("spring.datasource.url"));
    //     dataSource.setUsername(env.getProperty("spring.datasource.username"));
    //     dataSource.setPassword(env.getProperty("spring.datasource.password"));
        

    //     return dataSource;

    // }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DataSource springDataSource(){       

        return DataSourceBuilder.create().build();

    }
}
