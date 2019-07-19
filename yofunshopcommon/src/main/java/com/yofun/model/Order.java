package com.yofun.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private double paymentAmout;
    private LocalDateTime createAt;
    private int userId;
    private LocalDateTime payAt;
    private int paymentStatus;
    private String receiverName;
    private String receiverTelephone;
    private String receiverAddress;
    private String tradeNumber;
    private int paymentType;
    private int orderStatus;
}
