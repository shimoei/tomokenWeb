package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@PropertySource({"classpath:env.properties"})
public class TomokenWeb
{
    public static void main( String[] args )
    {
        SpringApplication.run(TomokenWeb.class, args);
    }
}
