package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {
}
