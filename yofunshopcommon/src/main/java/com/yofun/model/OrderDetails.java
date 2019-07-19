package com.yofun.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private int id;
    private int orderId;
    private int productId;
    private int merchantId;
    private LocalDateTime createAt;
    private int productNumber;
}
