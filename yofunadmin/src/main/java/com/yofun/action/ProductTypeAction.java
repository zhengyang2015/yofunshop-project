package com.yofun.action;

import com.yofun.model.ProductType;
import com.yofun.service.ProductTypeDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductTypeAction {

    @Autowired
    ProductTypeDisplayService displayProductTypeService;

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    public String findAllProductType(Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);
        return "producttypes";
    }

    @RequestMapping(value = "/listProductTypeByProduct",method = RequestMethod.GET)
    public String listProductTypeByProduct(Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);
        return "producttypebyproduct";
    }

    @RequestMapping(value = "/insertProducttype",method = RequestMethod.POST)
    public void insertProducttype(ProductType productType) {
        displayProductTypeService.insertProductType(productType);
    }

    @RequestMapping(value = "/toInsertProducttype",method = RequestMethod.GET)
    public String toInsertProducttype(int parentId, String parentLevel, Model model) {
        ProductType productType = new ProductType();
        productType.setParentId(parentId);
        productType.setTypeLevel(String.valueOf(Integer.valueOf(parentLevel) + 1));
        model.addAttribute("productType", productType);
        return "producttypeinsert";
    }

    @RequestMapping(value = "/findProductTypeById", method = RequestMethod.GET)
    public String findProductTypeById(int id, Model model) {
        ProductType productType = displayProductTypeService.findProductTypeById(id);
        model.addAttribute("productType", productType);
        return "producttypeview";
    }

    @RequestMapping(value = "/updateProductTypeById", method = RequestMethod.POST)
    public void updateProductTypeById(ProductType productType) {
        displayProductTypeService.updateProductTypeById(productType);
    }

    @RequestMapping(value = "/toUpdateProductTypeById", method = RequestMethod.GET)
    public String toUpdateProductTypeById(int id, Model model) {
        ProductType productType = displayProductTypeService.findProductTypeById(id);
        model.addAttribute("productType", productType);
        return "producttypeupdate";
    }

}
