package com.yofun.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    private int id;
    private String typeName;
    private String typeDescription;
    private String typeLevel;
    private int parentId;
}
