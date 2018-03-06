package com.SWEProject.controller;

import com.SWEProject.Entities.Administrator;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private ProductRepository rep;

    @GetMapping("/AdminView")
    public String ShowAdminView(Model model)
    {
        model.addAttribute("admin", new Administrator());
        return "AdminView";
    }

    @GetMapping("/AddProduct")
    public String ShowAddProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping("/AddProduct")
    public String AddProduct(Model model, @ModelAttribute Product product )
    {
        model.addAttribute("product", new Product());

        if(product.getMyBrand().equals("") || product.getMyModel().equals("") ||
                product.getPrice()==0 || product.getProductID().equals("") || product.getProductName().equals("") ||
                product.getMyBrand().equals(""))
        {
            return "register";
        }
        rep.save(product);
        return "addProduct";
    }

}
