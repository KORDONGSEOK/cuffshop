package dev.cuffshop.web.product;

import dev.cuffshop.domain.product.CategoryType;
import dev.cuffshop.domain.product.Product;
import dev.cuffshop.repository.product.ProductRepository;
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

    private final ProductRepository productRepository;

    @ModelAttribute("categoryTypes")
    public CategoryType[] categoryTypes() {
        return CategoryType.values();
    }

    @Autowired
    public ProductController(ProductRepository goodsRepository) {
        this.productRepository = goodsRepository;
    }

    @GetMapping()
    public String products(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "cuffshop/product/goods-list";
    }

    @GetMapping("/{productId}")
    public String product(@PathVariable long productId, Model model) {

        Product product = productRepository.findById(productId);
        model.addAttribute("product", product);
        return "cuffshop/product/goods-detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "cuffshop/product/goods-addform";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (!StringUtils.hasText(product.getProductName())) {
            bindingResult.addError(new FieldError("product", "productName", "상품이름은 필수입니다."));
        }



        log.info("product.productName={}" , product.getProductName());
        log.info("product.categoryType={}" , product.getCategoryType());
        log.info("product.price={}" ,         product.getPrice());
        log.info("product.discountRate={}" , product.getDiscountRate());
        log.info("product.quantity={}" , product.getQuantity());
        log.info("product.deliveryInfo={}" , product.getDeliveryInfo());
        log.info("product.productInfo={}" , product.getProductInfo());
        log.info("product.discountPrice={}" , product.getDiscountPrice());

        Integer price = product.getPrice();
        Integer discountRate = product.getDiscountRate();
        Integer discountPrice = product.getDiscountPrice();

        if (discountPrice == null) {
            if (price != null && discountRate != null) {
                discountPrice = price * discountRate / 100;
                product.setDiscountPrice(discountPrice);
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "cuffshop/product/goods-addform";
        }

        Product saveProduct = productRepository.save(product);
        redirectAttributes.addAttribute("productId", saveProduct.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/cuffshop/products/{productId}";
    }

    @GetMapping("/{productId}/edit")
    public String editForm(@PathVariable Long productId, Model model) {
        Product product = productRepository.findById(productId);
        model.addAttribute("product", product);
        return "cuffshop/product/goods-editform";
    }

    @PostMapping("/{productId}/edit")
    public String edit(@PathVariable Long productId, @ModelAttribute Product product) {
        productRepository.update(productId, product);
        return "redirect:/cuffshop/products/{productId}";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        productRepository.save(
                new Product(
                        "바다향 가득! 해산물 씨키트 해물 스파게티 밀키트(2인)",
                        16800,
                        30,
                        1000,
                        "5만원 이상 구매시 무료 배송\n" +
                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
                        "제주, 도서, 산간 지역 15,000원 추가",
                        "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
                                "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티")

        );
        productRepository.save(
                new Product(
                        "HACCP 인증을 받은 닭꼬치 밀키트, 굽기만 하면 끝(10개)",
                        23500,
                        20,
                        2000,
                        "5만원 이상 구매시 무료 배송\n" +
                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
                        "제주, 도서, 산간 지역 15,000원 추가",
                        "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
                                "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티")

        );
        productRepository.save(
                new Product(
                        "따뜻하게 먹는 저칼로리, 부드러운 닭 찜 샐러드(1인분, 270g)",
                        12500,
                        10,
                        100,
                        "5만원 이상 구매시 무료 배송\n" +
                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
                        "제주, 도서, 산간 지역 15,000원 추가",
                        "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
                                "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티")

        );
    }

}
