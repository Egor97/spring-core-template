package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public ArrayListItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository(new ArrayList<>());
    }

    @Bean
    public LinkedListItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository(new LinkedList<>());
    }
}
