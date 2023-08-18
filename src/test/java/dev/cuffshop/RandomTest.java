package dev.cuffshop;

import org.junit.jupiter.api.Test;

public class RandomTest {

    @Test
    void insertQuery() {
        String sql = "insert into product ";
        sql += "(product_name, category_type, price, discount_rate, discount_price, quantity, delivery_info, product_info ";
        sql += "values (?, ?, ?, ?, ?, ?, ?, ? )";
        System.out.print("sql = " + sql);
    }
}
