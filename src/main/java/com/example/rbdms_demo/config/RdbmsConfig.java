package com.example.rbdms_demo.config;

import com.example.rdbms.engine.Database;
import com.example.rdbms.parser.SqlParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RdbmsConfig {

    @Bean
    public Database database(){
        return new Database();
    }

    @Bean
    public SqlParser parser(Database database){
        return new SqlParser(database);
    }
}
