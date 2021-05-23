package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class })
public class SimpleItemServiceTest {

    @Autowired
    SimpleItemService simpleItemService;

    @Test
    public void getById() {
        Item itemTest = new Item(11, "shoes", 200, new ColorFactory().getColor());
        simpleItemService.createItem(itemTest);

        assertEquals(itemTest, simpleItemService.getById(11));
    }

    @Test
    public void getByIdShouldNull() {
        Item itemForCreated = new Item(12, "shoes", 1299, new ColorFactory().getColor());

        assertNull(simpleItemService.getById(itemForCreated.getId()));
    }

    @Test
    public void createItem() {
        Item itemForCreated = new Item(12, "shoes", 1200, new ColorFactory().getColor());
        boolean isCreatedItem = simpleItemService.createItem(itemForCreated);

        assertTrue(isCreatedItem);
    }
}