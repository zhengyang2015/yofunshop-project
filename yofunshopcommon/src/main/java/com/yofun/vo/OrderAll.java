package com.yofun.vo;

import com.yofun.model.Order;
import com.yofun.model.OrderDetails;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderAll {
    private Order order;
    private OrderDetails orderDetails;
}
