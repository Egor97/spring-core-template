package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */

@Repository
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public ArrayListItemRepository(ArrayList<Item> arrayList) {
        this.holder = arrayList;
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

    void setInitialSequence(@Value("${initial.sequence}") int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.holder = new ArrayList<>();
    }
}
