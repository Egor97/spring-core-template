package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MainConfiguration.class })
@PropertySource("classpath:application.properties")
public class ArrayListItemRepositoryTest {

    @Value("${initial.sequence}")
    int val;
    Item testItem = new Item(1, "shoes", 1230, new ColorFactory().getColor());
    Item testCreatedItem = new Item(2, "shoes", 100, new ColorFactory().getColor());

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    @Test
    public void getById() {
        arrayListItemRepository.createItem(testItem);
        assertEquals(testItem, arrayListItemRepository.getById(testItem.getId()));
    }

    @Test
    public void getByIdShouldNull() {
        assertNull(arrayListItemRepository.getById(testItem.getId()));
    }

    @Test
    public void createItem() {
        boolean isItemCreated = arrayListItemRepository.createItem(testCreatedItem);

        assertTrue(isItemCreated);
    }

    @Test
    public void createItemShouldFalse() {
        arrayListItemRepository.createItem(testCreatedItem);
        assertFalse(arrayListItemRepository.createItem(testCreatedItem));
    }

    @Test
    public void setInitialSequence() {
        arrayListItemRepository.setInitialSequence(val);
        assertEquals(val, arrayListItemRepository.initialSequence);
    }

    @Test
    public void setHolder() {
        arrayListItemRepository.setHolder();
        assertEquals(new ArrayList<>(), arrayListItemRepository.holder);
    }
}