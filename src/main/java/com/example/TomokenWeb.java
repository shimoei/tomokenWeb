package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@PropertySource({"classpath:env.properties"})
public class TomokenWeb extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(TomokenWeb.class, args);
    }
}
