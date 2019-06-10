package ch.m1m.app.zampano.zampano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ZampanoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZampanoApplication.class, args);
    }

}

