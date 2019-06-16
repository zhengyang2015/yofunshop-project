package com.yofun.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    private int id;
    private String merchantName;
    private String merchantShopName;
    private String merchantAccount;
    private String merchantPassword;
    private String merchantScope;
    private int auditStatus;
}
