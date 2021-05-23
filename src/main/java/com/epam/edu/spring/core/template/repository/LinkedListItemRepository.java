package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Repository
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public LinkedListItemRepository(LinkedList<Item> linkedList) {
        this.holder = linkedList;
    }

    @Override
    public Item getById(long id) {
        for (Item item : holder) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        if (holder.contains(item)) return false;
        return holder.add(item);
    }

    void setInitialSequence(int val) {
        this.initialSequence = new Random().nextInt(100) + 1;
    }

    void setHolder() {
        this.holder = new LinkedList<>();
    }
}
