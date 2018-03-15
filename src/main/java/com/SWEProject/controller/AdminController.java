package com.SWEProject.controller;

import com.SWEProject.Entities.Administrator;
import com.SWEProject.Entities.Brand;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.SystemProduct;
import com.SWEProject.repository.BrandRepository;
import com.SWEProject.repository.SystemProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private SystemProductRepository systemProductRep;
    @Autowired
    private BrandRepository BrandRep;

    @GetMapping("/AdminView")
    public String ShowAdminView(Model model)
    {
        model.addAttribute("admin", new Administrator());
        return "adminView";
    }

    @GetMapping("/AddProductToSystem")
    public String ShowAddProduct(Model model)
    {
        model.addAttribute("systemProduct", new SystemProduct());
        return "addProductToSystem";
    }

    @RequestMapping("/AddProductToSystem")
    public String AddProductToSystem(Model model, @ModelAttribute SystemProduct systemProduct )
    {
        model.addAttribute("systemProduct", new SystemProduct());

        if(systemProduct.getProductName().equals("") || systemProduct.getPrice()==0.0 ||
                 systemProduct.getModel().equals("") || systemProduct.getBrand().equals(""))
        {
            return "addProductToSystem";
        }
        if(!systemProductRep.exists(systemProduct.getProductName()))
        {
            systemProductRep.save(systemProduct);
        }
        return "addProductToSystem";
    }

    @GetMapping("/AddBrand")
    public String ShowAddBrand(Model model)
    {
        model.addAttribute("brand", new Brand());
        return "addBrand";
    }

    @RequestMapping("/AddBrand")
    public String AddBrand(Model model, @ModelAttribute Brand brand )
    {
        model.addAttribute("brand", new Brand());
        if(brand.getBrandID().equals("") || brand.getBrandName().equals(""))
        {
            return "register";
        }
        BrandRep.save(brand);
        return "addBrand";
    }

}
