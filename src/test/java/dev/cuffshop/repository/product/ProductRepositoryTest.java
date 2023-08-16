package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @AfterEach
    void afterEach() {
        if (productRepository instanceof MemoryProductRepository) {
            ((MemoryProductRepository) productRepository).clearStore();
        }
    }

    @Test
    void save() {
        Product product = new Product(
                "따뜻하게 먹는 저칼로리, 부드러운 닭 찜 샐러드(1인분, 270g)",
                12500,
                10,
                100,
                "5만원 이상 구매시 무료 배송\n" +
                        "8/24(목) 도착 예정(평균 배송 소요 2~3일)\n" +
                        "제주, 도서, 산간 지역 15,000원 추가",
                "입 안에 가득 퍼지는 풍부한 바다 향과 스파케티의 다채로운 2가지 맛의 콤비네이션\n" +
                        "우스터소스, 간장, 꿀, 레드 와인 식초로 맛을 낸 마리네이드 소사는 풍미를 더해줄 뿐만 아니라 오징어의식감을 더욱 부드럽게 만들어줍니다.\n" +
                        "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티",
                11250);


    }


}