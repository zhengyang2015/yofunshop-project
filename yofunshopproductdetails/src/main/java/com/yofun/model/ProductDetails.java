package com.yofun.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    private int id;
    private int productId;
    private String productPlace;
    private String productTitle;
    private String productBrand;
    private double productWeight;
    private String productSpecification;
    private String productDetailsImageUrl;
}
