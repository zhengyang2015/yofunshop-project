package com.yofun.controller;

import com.yofun.model.*;
import com.yofun.service.DisplayOrderService;
import com.yofun.service.DisplayProductService;
import com.yofun.service.DisplayProductTypeService;
import com.yofun.service.DisplayUserService;
import com.yofun.vo.OrderAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private DisplayProductTypeService displayProductTypeService;

    @Autowired
    private DisplayProductService displayProductService;

    @Autowired
    private DisplayUserService displayUserService;

    @Autowired
    private DisplayOrderService displayOrderService;

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    public String listProduct(@RequestParam int productTypeId, Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);

        if(productTypeId == -1) {
            productTypeId = productTypes.get(0).getId();
        }

        List<Product> products = displayProductService.findAllProduct(productTypeId);
        model.addAttribute("products", products);

        return "list";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String userLogin(Model model, String name, String password, HttpServletRequest request) {
        User user = displayUserService.findUserByName(name);
        if(user == null) {
            System.out.println("No User find with name : " + name);
        } else {
            if(password != null && password.equals(user.getPasswordencrypt())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            } else {
                System.out.println("Invalid password");
            }
        }

        return listProduct(-1, model);
    }

    @RequestMapping(value = "/searchProduct",method = RequestMethod.GET)
    public String searchProduct(Model model, String keyword) {
        List<Product> products = displayProductService.searchProduct(keyword);
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping(value = "/toProductDetails",method = RequestMethod.GET)
    public String toProductDetails(int productId, Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);

        Product product = displayProductService.findProductById(productId);
        model.addAttribute("product", product);

        ProductDetails productDetails = displayProductService.findProductDetailsByProductId(productId);
        model.addAttribute("productDetails", productDetails);

        return "productdeatils";
    }

    @RequestMapping(value = "/toBuy",method = RequestMethod.GET)
    public String toBuy(int productId, int num, Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);

        Product product = displayProductService.findProductById(productId);
        model.addAttribute("product", product);

        model.addAttribute("num", num);

        double amount = product.getProductPrice() * num;
        model.addAttribute("amount", amount);

        return "createorder";
    }

    @RequestMapping(value = "/insertOrder",method = RequestMethod.POST)
    public String insertOrder(Model model, HttpServletRequest request, int productId, int merchantId, int num, double paymentAmount, String receiverName, String receiverTelephone, String receiverAddress) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "login";
        } else {
            Order order = new Order();
            order.setUserId(user.getId());
            order.setPaymentAmout(paymentAmount);
            order.setReceiverName(receiverName);
            order.setReceiverTelephone(receiverTelephone);
            order.setReceiverAddress(receiverAddress);

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProductId(productId);
            orderDetails.setMerchantId(merchantId);
            orderDetails.setProductNumber(num);

            OrderAll orderAll = new OrderAll();
            orderAll.setOrder(order);
            orderAll.setOrderDetails(orderDetails);

            displayOrderService.insertOrder(orderAll);

            return "list";
        }
    }
}
