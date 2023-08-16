package dev.cuffshop.repository.item;

import dev.cuffshop.domain.item.Item;
import dev.cuffshop.test.validation.form.ItemUpdateForm;

import java.util.List;
import java.util.Optional;


public interface ItemRepository {
    Item save(Item item);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond cond);

    void update(Long itemId, ItemUpdateDto updateParam);
}
