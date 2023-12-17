package com.fastcampus.projectboard.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


@RequiredArgsConstructor
@Getter
@ConfigurationProperties("spring.thymeleaf3")
public class Thymeleaf3Properties {
    /**
     * Use Thymeleaf 3 Decoupled Logic
     */
    private final boolean decoupledLogic;

}