package dev.cuffshop.repository;

import dev.cuffshop.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository {
    Item save(Item item);

    Item findById(Long id);

    List<Item> findAll();

    void update(Long itemId, Item updateParam);
}
