package com.yofun.service;

import com.yofun.dao.MerchantDao;
import com.yofun.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    @Autowired
    private MerchantDao merchantDao;

    public void insertMerchant(Merchant merchant) {
        merchant.setAuditStatus(1);
        merchantDao.insertMerchant(merchant);
    }
}
