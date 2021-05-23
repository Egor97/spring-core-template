package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MainConfiguration.class })
public class LinkedListItemRepositoryTest {

    @Autowired
    LinkedListItemRepository linkedListItemRepository;
    Item testItem = new Item(1, "shoes", 1000, new ColorFactory().getColor());
    Item testItem2 = new Item(2, "shoes", 1000, new ColorFactory().getColor());

    @Test
    public void getById() {
        linkedListItemRepository.createItem(testItem2);
        assertEquals(testItem2, linkedListItemRepository.getById(testItem2.getId()));
    }

    @Test
    public void getByIdShouldNull() {
        assertNull(linkedListItemRepository.getById(testItem2.getId()));
    }

    @Test
    public void createItem() {
        assertTrue(linkedListItemRepository.createItem(testItem));
    }

    @Test
    public void createItemShouldFalse() {
        Item testCreatedItem = testItem;

        linkedListItemRepository.createItem(testCreatedItem);
        assertFalse(linkedListItemRepository.createItem(testCreatedItem));
    }

    @Test
    public void setInitialSequence() {
        linkedListItemRepository.setInitialSequence(0);
        assertTrue(100 >= linkedListItemRepository.initialSequence &&
                                   linkedListItemRepository.initialSequence >= 0);
    }

    @Test
    public void setHolder() {
        linkedListItemRepository.setHolder();
        assertEquals(new LinkedList<>(), linkedListItemRepository.holder);
    }
}