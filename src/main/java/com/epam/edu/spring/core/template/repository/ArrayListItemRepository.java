package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@PropertySource("classpath:application.properties")
@Repository
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final ArrayList<Item> arrayList;

    public ArrayListItemRepository(ArrayList<Item> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public Item getById(long id) {
        for (Item item : holder) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        if (!holder.contains(item)) {
            item.setId(++initialSequence);
            return holder.add(item);
        }
        return false;
    }

    void setInitialSequence(@Value("${initial.sequence}") int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.holder = this.arrayList;
    }
}
