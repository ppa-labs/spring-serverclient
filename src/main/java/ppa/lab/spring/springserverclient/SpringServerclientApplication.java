package ppa.lab.spring.springserverclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import ppa.lab.spring.springserverclient.configuration.AppConfig;

@SpringBootApplication
@EntityScan(basePackages = {"ppa.spring.domain.bean"})
@Import({ AppConfig.class })
public class SpringServerclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServerclientApplication.class, args);
    }

}
