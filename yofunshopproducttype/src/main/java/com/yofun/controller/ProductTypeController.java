package com.yofun.controller;

import com.yofun.model.ProductType;
import com.yofun.service.ProductTypeService;
import com.yofun.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@EnableEurekaClient
@Controller
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/insertProducttype", method = RequestMethod.POST)
    public void insertProductType(ProductType productType) {
        productTypeService.insertProductType(productType);
    }

    @RequestMapping(value = "/toAddProductTypeById", method = RequestMethod.GET)
    public String toAddProductTypeById(int id, Model model) {
        ProductType productType = productTypeService.findProductTypeById(id);
        if(productType == null) {
            productType = new ProductType();
            productType.setId(-1);
        }
        model.addAttribute("productType", productType);
        return "producttypeadd";
    }

    @RequestMapping(value = "/findProductTypeById", method = RequestMethod.GET)
    public String findProductTypeById(int id, Model model) {
        ProductType productType = productTypeService.findProductTypeById(id);
        ProductType parentProductType = productTypeService.findProductTypeById(productType.getId());
        if(parentProductType == null) {
            parentProductType = new ProductType();
            parentProductType.setTypeName("");
        }
        model.addAttribute("productType", productType);
        model.addAttribute("parentProductType", parentProductType);
        return "producttypeview";
    }

    @RequestMapping(value = "/toUpdateProductTypeById", method = RequestMethod.GET)
    public String toUpdateProductTypeById(int id, Model model) {
        ProductType productType = productTypeService.findProductTypeById(id);
        model.addAttribute("productType", productType);
        return "producttypeupdate";
    }

    @RequestMapping(value = "/updateProductTypeById", method = RequestMethod.POST)
    public void updateProductTypeById(ProductType productType, Model model) {
        productTypeService.updateProductType(productType);
    }

    @RequestMapping(value = "/queryProductTypeByVo", method = RequestMethod.GET)
    public String queryProductTypeByVo(Model model) {
        ProductTypeVo productTypeVo = new ProductTypeVo();
        List<ProductType> productTypes = productTypeService.queryProductTypeByVo(productTypeVo);
        model.addAttribute("productTypes", productTypes);
        return "producttypes";
    }

    @RequestMapping(value = "/deleteProductTypeById", method = RequestMethod.GET)
    public void deleteProductTypeById(int id) {
        productTypeService.deleteProductTypeById(id);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String testCloud(@RequestParam String name){
        return "Hi " + name + ", I am from port:";
    }
}
