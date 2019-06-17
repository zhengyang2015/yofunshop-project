package com.yofun.dao;

import com.yofun.mapper.MerchantMapper;
import com.yofun.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchantDao {

    @Autowired
    private MerchantMapper merchantMapper;

    public void insertMerchant(Merchant merchant) {
        merchantMapper.insertMerchant(merchant);
    }

    public Merchant findMerchantById(int id) {
        return merchantMapper.findMerchantById(id);
    }

    public void updateMerchantById(Merchant merchant) {
        merchantMapper.updateMerchantById(merchant);
    }

    public void updateMerchantAuditStatus(Merchant merchant) {
        merchantMapper.updateMerchantAuditStatus(merchant);
    }
}
