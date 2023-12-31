package dev.cuffshop.web.product;

import dev.cuffshop.domain.product.CategoryType;
import dev.cuffshop.domain.product.Product;
import dev.cuffshop.repository.product.ProductRepository;
import dev.cuffshop.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cuffshop/products")
public class ProductController {

    private final ProductService productService;

    @ModelAttribute("categoryTypes")
    public CategoryType[] categoryTypes() {
        return CategoryType.values();
    }

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String products(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "cuffshop/product/goods-list";
    }

    @GetMapping("/{productId}")
    public String product(@PathVariable long productId, Model model) {

        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "cuffshop/product/goods-detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "cuffshop/product/goods-addform";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("product") ProductSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "cuffshop/product/goods-addform";
        }

        log.info("form.getDiscountPrice={}", form.getDiscountPrice());

        int discountPrice = 0;
        //할인가격 계산이 안되고 넘어오는것 처리
        if (form.getDiscountPrice() == null) {
            if (form.getPrice() != null && form.getDiscountRate() != null) {
                discountPrice = form.getPrice() * form.getDiscountRate() / 100;
            }
        }else {
            discountPrice = form.getDiscountPrice();
        }

        Product product = new Product(form.getProductName(),
                                        form.getCategoryType(),
                                        form.getPrice(),
                                        form.getDiscountRate(),
                                        form.getQuantity(),
                                        form.getDeliveryInfo(),
                                        form.getProductInfo(),
                                        discountPrice);

        Product saveProduct = productService.save(product);
        redirectAttributes.addAttribute("productId", saveProduct.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/cuffshop/products/{productId}";
    }

    @GetMapping("/{productId}/edit")
    public String editForm(@PathVariable Long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "cuffshop/product/goods-editform";
    }

    @PostMapping("/{productId}/edit")
    public String edit(@PathVariable Long productId, @Validated @ModelAttribute("product") ProductUpdateForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "cuffshop/product/goods-editform";
        }

        log.info("form.getDiscountPrice={}", form.getDiscountPrice());

        int discountPrice = 0;
        //할인가격 계산이 안되고 넘어오는것 처리
        if (form.getDiscountPrice() == null) {
            if (form.getPrice() != null && form.getDiscountRate() != null) {
                discountPrice = form.getPrice() * form.getDiscountRate() / 100;
            }
        }else {
            discountPrice = form.getDiscountPrice();
        }

        Product productParam = new Product(form.getProductName(),
                                    form.getCategoryType(),
                                    form.getPrice(),
                                    form.getDiscountRate(),
                                    form.getQuantity(),
                                    form.getDeliveryInfo(),
                                    form.getProductInfo(),
                                    discountPrice);

        productService.update(productId, productParam);
        return "redirect:/cuffshop/products/{productId}";
    }

    /**
     * 테스트용 데이터 추가
     */
//    @PostConstruct
//    public void init() {
//        productService.save(
//                new Product(
//                        "바다향 가득! 해산물 씨키트 해물 스파게티 밀키트(2인)",
//                        16800,
//                        30,
//                        1000,
//                        "5만원 이상 구매시 무료 배송\n" +
//                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
//                        "제주, 도서, 산간 지역 15,000원 추가",
//                        "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
//                                "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
//                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티",
//                        11760
//                        )
//
//        );
//        productService.save(
//                new Product(
//                        "HACCP 인증을 받은 닭꼬치 밀키트, 굽기만 하면 끝(10개)",
//                        23500,
//                        20,
//                        2000,
//                        "5만원 이상 구매시 무료 배송\n" +
//                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
//                        "제주, 도서, 산간 지역 15,000원 추가",
//                        "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
//                                "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
//                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티",
//                        18800)
//
//        );
//        productService.save(
//                new Product(
//                        "따뜻하게 먹는 저칼로리, 부드러운 닭 찜 샐러드(1인분, 270g)",
//                        12500,
//                        10,
//                        100,
//                        "5만원 이상 구매시 무료 배송\n" +
//                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
//                        "제주, 도서, 산간 지역 15,000원 추가",
//                        "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
//                                "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
//                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티",
//                        11250)
//
//        );
//    }

}
