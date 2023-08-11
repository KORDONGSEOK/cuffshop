package dev.cuffshop.web;

import dev.cuffshop.domain.item.Item;
import dev.cuffshop.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    private final ItemRepository itemRepository;

    public TestController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/itemlist")
    public String list(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "cuffshop/item/goods-list";
    }
}
