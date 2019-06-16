package com.yofun.controller;

import com.yofun.model.Merchant;
import com.yofun.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/insertMerchant", method = RequestMethod.POST)
    public void insertMerchant(Merchant merchant) {
        merchantService.insertMerchant(merchant);
    }

    @RequestMapping(value = "/toInsertMerchant", method = RequestMethod.GET)
    public String toInsertMerchant() {
        return "merchantregister";
    }

    @RequestMapping(value = "/findMerchantById", method = RequestMethod.GET)
    public String findMerchantById(int id, Model model) {
        Merchant merchant = merchantService.findMerchantById(id);
        if(merchant == null) {
            merchant = new Merchant();
        }
        model.addAttribute("merchant", merchant);
        return "merchantview";
    }

    @RequestMapping(value = "/updateMerchantById", method = RequestMethod.POST)
    public void updateMerchantById(Merchant merchant) {
        merchantService.updateMerchantById(merchant);
    }

    @RequestMapping(value = "/toUpdateMerchantById", method = RequestMethod.GET)
    public String toUpdateMerchantById(int id, Model model) {
        Merchant merchant = merchantService.findMerchantById(id);
        if(merchant == null) {
            throw new RuntimeException("No Merchant find by id : " + id);
        }
        model.addAttribute("merchant", merchant);
        return "merchantupdate";
    }
}
