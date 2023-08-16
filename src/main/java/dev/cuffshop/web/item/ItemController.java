package dev.cuffshop.web.item;

import dev.cuffshop.domain.delivery.DeliveryCode;
import dev.cuffshop.domain.item.Item;
import dev.cuffshop.domain.item.ItemType;
import dev.cuffshop.repository.item.ItemRepository;
import dev.cuffshop.repository.item.ItemSearchCond;
import dev.cuffshop.repository.item.ItemUpdateDto;
import dev.cuffshop.service.item.ItemService;
import dev.cuffshop.test.validation.ItemValidator;
import dev.cuffshop.test.validation.form.ItemSaveForm;
import dev.cuffshop.test.validation.form.ItemUpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
//    private final ItemValidator itemValidator;

//    @InitBinder
//    public void init(WebDataBinder dataBinder) {
//        dataBinder.addValidators(itemValidator);
//    }

    @ModelAttribute("regions") //모델에 담기는것이 항상 보장된다.
    public Map<String, String> regions() {
        Map<String, String> regions = new LinkedHashMap<>(); //순서보장
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");
        return regions;
    }

    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values();
    }

    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes() {
        List<DeliveryCode> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
        deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
        deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
        return deliveryCodes;
    }

    @GetMapping
    public String items(@ModelAttribute("itemSearch")ItemSearchCond itemSearch, Model model) {
        List<Item> items = itemService.findItems(itemSearch);
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemService.findById(itemId).get();
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        //특정 필드 예외가 아닌 전체 예외
        if (form.getPrice() != null && form.getQuantity() != null) {
            int resultPrice = form.getPrice() * form.getQuantity();
            if (resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

//        itemValidator.validate(item, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "basic/addForm";
        }

        //성공 로직

        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setPrice(form.getPrice());
        item.setQuantity(form.getQuantity());

        Item saveItem = itemService.save(item);
        redirectAttributes.addAttribute("itemId", saveItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemService.findById(itemId).get();
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated @ModelAttribute("item") ItemUpdateDto updateParam, BindingResult bindingResult) {

        //특정 필드 예외가 아닌 전체 예외
        if (updateParam.getPrice() != null && updateParam.getQuantity() != null) {
            int resultPrice = updateParam.getPrice() * updateParam.getQuantity();
            if (resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("erros={}", bindingResult);
            return "basic/editForm";
        }

        Item itemParam = new Item();
        itemParam.setItemName(updateParam.getItemName());
        itemParam.setPrice(updateParam.getPrice());
        itemParam.setQuantity(updateParam.getQuantity());

        itemService.update(itemId, updateParam);
        return "redirect:/basic/items/{itemId}";
    }


    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemService.save(new Item("itemA", 10000, 10));
        itemService.save(new Item("itemB", 20000, 20));
        itemService.save(new Item("itemC", 30000, 30));
        itemService.save(new Item("itemD", 40000, 40));
        itemService.save(new Item("itemE", 50000, 50));
    }

}
