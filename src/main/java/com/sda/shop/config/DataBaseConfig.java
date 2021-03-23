package com.sda.shop.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.sda.shop.entities")
@EnableJpaRepositories("com.sda.shop.repository")
public class DataBaseConfig {
}
