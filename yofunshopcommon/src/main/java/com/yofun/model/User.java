package com.yofun.model;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String account;
    private int age;
    private String passwordencrypt;
    private String datebirth;
    private String address;
    private String telephone;
    private String qq;
    private String wechat;
    private String email;
    private String sex;
}
