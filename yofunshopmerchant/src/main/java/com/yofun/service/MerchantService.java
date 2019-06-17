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
        merchant.setRemoveStatus(1);
        merchantDao.insertMerchant(merchant);
    }

    public Merchant findMerchantById(int id) {
        return merchantDao.findMerchantById(id);
    }

    public void updateMerchantById(Merchant merchant) {
        merchant.setRemoveStatus(1);
        merchantDao.updateMerchantById(merchant);
    }

    public void updateMerchantAuditStatus(int id, int status) {
        Merchant merchant = new Merchant();
        merchant.setId(id);
        merchant.setAuditStatus(status);
        merchantDao.updateMerchantAuditStatus(merchant);
    }

    public void updateMerchantRemoveStatus(int id, int status) {
        Merchant merchant = new Merchant();
        merchant.setId(id);
        merchant.setRemoveStatus(status);
        merchantDao.updateMerchantRemoveStatus(merchant);
    }
}
