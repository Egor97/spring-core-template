package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final LinkedList<Item> linkedList;

    public LinkedListItemRepository(LinkedList<Item> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(++initialSequence);
        return holder.add(item);
    }

    void setInitialSequence(int val) {
        this.initialSequence = new Random().nextInt(101);
    }

    void setHolder() {
        this.holder = this.linkedList;
    }
}
