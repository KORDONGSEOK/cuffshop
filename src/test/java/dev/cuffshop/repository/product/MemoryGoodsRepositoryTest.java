package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryGoodsRepositoryTest {

    MemoryProductRepository goodsRepository = new MemoryProductRepository();
    @AfterEach
    void afterEach() {
        goodsRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Product goods = new Product(
                "바다향 가득! 해산물 씨키트 해물 스파게티 밀키트(2인)",
                16800,
                30,
                1000,
                "5만원 이상 구매시 무료 배송",
                "상품정보입니다."
        );
        //when
        Product saveGoods = goodsRepository.save(goods);
        //then
        Product findGoods = goodsRepository.findById(goods.getId());
        assertThat(findGoods).isEqualTo(saveGoods);
    }

    @Test
    void saveTwo() {
        //given
        Product goods =
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
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티"
                );
        //when
        Product saveGoods = goodsRepository.save(goods);
        //then
        Product findGoods = goodsRepository.findById(goods.getId());
        assertThat(findGoods).isEqualTo(saveGoods);
    }

    @Test
    void saveThird() {
        //given
        Product goods =
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
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티"
                );
        //when
        Product saveGoods = goodsRepository.save(goods);
        //then
        Product findGoods = goodsRepository.findById(goods.getId());
        assertThat(findGoods).isEqualTo(saveGoods);
    }

    @Test
    void findAll() {
        Product goods1 =
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
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티"
                );

        Product goods2 =
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
                                "오늘 메뉴는 아이들이 좋아하는 오징어 토마토 스파게티를 만들어 주세요. 입에서 살살 녹는 Today’s Meal Kit 토마토 오징어 스파케티"
                );

        goodsRepository.save(goods1);
        goodsRepository.save(goods2);

        List<Product> result = goodsRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(goods1, goods2);

    }
}