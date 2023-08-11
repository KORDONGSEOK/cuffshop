package dev.cuffshop.service;

import dev.cuffshop.domain.order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
