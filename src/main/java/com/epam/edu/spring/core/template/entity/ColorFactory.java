package com.epam.edu.spring.core.template.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ColorFactory implements FactoryBean<Color> {

    public Color getColor() {
        return getObject();
    }

    @Override
    public Color getObject() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
