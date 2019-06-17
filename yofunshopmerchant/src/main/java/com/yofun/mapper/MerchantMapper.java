package com.yofun.mapper;

import com.yofun.model.Merchant;

public interface MerchantMapper {
    void insertMerchant(Merchant merchant);
    Merchant findMerchantById(int id);
    void updateMerchantById(Merchant merchant);
    void updateMerchantAuditStatus(Merchant merchant);
    void updateMerchantRemoveStatus(Merchant merchant);
}
