package com.yofun.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    private int id;
    private String productTypeName;
    private String productTypeDescription;
    private String typeLevel;
    private int parentId;
}
