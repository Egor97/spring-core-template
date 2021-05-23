package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {

    final InitializerConfiguration initializerConfiguration;
    final RepositoryConfiguration repositoryConfiguration;

    @Value("${item.repository.implementation}")
    private String impl;

    @Autowired
    public MainConfiguration(InitializerConfiguration initializerConfiguration, RepositoryConfiguration repositoryConfiguration) {
        this.initializerConfiguration = initializerConfiguration;
        this.repositoryConfiguration = repositoryConfiguration;
    }

    @Bean
    public ItemRepository itemRepository() {
        if (impl.equals("linked")) {
            return repositoryConfiguration.linkedListItemRepository();
        }
        return repositoryConfiguration.arrayListItemRepository();
    }

    @Bean
    public ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }

    @Bean
    public ItemService itemService() {
        return new SimpleItemService(itemRepository(), itemValidator());
    }
}
