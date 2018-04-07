package com.SWEProject.controller;

import com.SWEProject.Entities.*;
import com.SWEProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreOwnerController {

    @Autowired
    private StoreRepository storeRep;
    @Autowired
    private ProductRepository productRep;
    @Autowired
    private SystemProductRepository sysProductRep;
    @Autowired
    private ModelRepository modelRep;
    @Autowired
    private BrandRepository brandRep;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/StoreOwnerView")
    public String DefaultPage() {
        return "storeOwnerView";
    }

    @GetMapping("/AddStore")
    public String ShowStore(Model model) {
        model.addAttribute("store", new Store());
        return "addStore";
    }

    @RequestMapping("/AddStore")
    public String AddStore(Model model, @ModelAttribute Store store) {
        model.addAttribute("store", new Store());
        if (store.getStoreName().equals("") || store.getStoreOwner().equals("") || store.getType().equals("")) {
            return "addStore";
        }
        if (storeRep.exists(store.getStoreName())) {
            return "addStore";
        }
        storeRep.save(store);
        return "StoreOwnerView";
    }

    @GetMapping("/AddProductToStore")
    public String ShowAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping("/AddProductToStore")
    public String AddProductInStore(Model model, @ModelAttribute Product product) {
        model.addAttribute("product", new Product());

        if (product.getProductName().equals("") || product.getModel().equals("") ||
                product.getPrice() == 0 || product.getProductName().equals("") ||
                product.getBrand().equals("")) {
            return "addProduct";
        }
        if (sysProductRep.exists(product.getProductName())) {
            if (productRep.exists(product.getSerialNumber()))
            {
                return "addProduct";
            }
            else
            {
                productRep.save(product);
                ProductModel tempModel = new ProductModel();
                tempModel.setName(product.getModel());
                modelRep.save(tempModel);
                Brand tempBrand = new Brand();
                tempBrand.setBrandName(product.getBrand());
                brandRep.save(tempBrand);
                return "StoreOwnerView";
            }
        }
        return "StoreOwnerView";
    }

    @GetMapping("/StatDetails")
    public String StatDetails(Model model) {
        model.addAttribute("store" , new Store());
        return "getStatForm";
    }

    @GetMapping("/ShowStat")
    public String ShowStat(Model model) {
       return "showStat";
    }

    @RequestMapping("/ShowStat")
    public ModelAndView ShowStat(Model model, @ModelAttribute Store store) {

        ModelAndView modelAndView = new ModelAndView();

        Iterable<Product> productIterable= productRep.findAll();
        List<Product> productList =new ArrayList<>();

        Product Temp=new Product();
        for(Product product : productIterable)
        {
            if(product.getStoreName().equals(store.getStoreName()))
            {
                productList.add(product);
                if(product.getViews()>Temp.getViews())
                {
                    Temp=product;
                }
            }

        }
        modelAndView.addObject("product",productList);
        modelAndView.addObject("MaxViewedProd",Temp);
        if(productList.size() <= 0)
        {
            modelAndView.setViewName("getStatForm");
        }
        else
        {
            modelAndView.setViewName("showStat");
        }

        return modelAndView;
    }
}
