package dev.cuffshop.service.order;

import dev.cuffshop.domain.order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
