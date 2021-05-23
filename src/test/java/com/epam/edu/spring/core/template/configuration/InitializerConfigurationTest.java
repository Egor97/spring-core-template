package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.ColorFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class})
public class InitializerConfigurationTest {

    @Autowired
    InitializerConfiguration initializerConfiguration;

    @Test
    public void colorFactory() {
        ColorFactory cf = initializerConfiguration.colorFactory();
        assertNotNull(cf);
    }
}