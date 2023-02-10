package ppa.lab.spring.springserverclient.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ppa.spring.domain.bean.SimplePerson;

@Configuration
@ComponentScan(basePackages = {
        "ppa.lab.spring.springserverclient.model"
        , "ppa.lab.spring.springserverclient.service"
})
public class AppConfig {
}
