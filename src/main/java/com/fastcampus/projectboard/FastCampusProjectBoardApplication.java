package com.fastcampus.projectboard;

import com.fastcampus.projectboard.config.ThymeleafConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastCampusProjectBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastCampusProjectBoardApplication.class, args);
    }

}
