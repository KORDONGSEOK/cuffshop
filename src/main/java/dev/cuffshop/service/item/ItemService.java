package dev.cuffshop.service.item;

import dev.cuffshop.domain.item.Item;
import dev.cuffshop.repository.item.ItemSearchCond;
import dev.cuffshop.repository.item.ItemUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ItemService {
    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
