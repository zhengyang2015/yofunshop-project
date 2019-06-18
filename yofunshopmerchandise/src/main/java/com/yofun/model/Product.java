package com.yofun.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private int productTypeId;
    private String productTitle;
    private double productPrice;
    private int merchantId;
    private LocalDateTime createdAt;
    private LocalDateTime auditAt;
    private int auditStatus;
    private int stockNumber;
    private int sellNumber;
    private String productImageUrl;
}
