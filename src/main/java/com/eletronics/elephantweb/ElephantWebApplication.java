package com.eletronics.elephantweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.eletronics.elephantweb")
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:/com/eletronics/elephantweb/application.properties")
public class ElephantWebApplication {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(ElephantWebApplication.class, args);
        new SpringApplicationBuilder(ElephantWebApplication.class)
                .headless(true)
                .run();
    }
}
