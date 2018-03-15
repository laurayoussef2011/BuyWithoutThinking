package com.SWEProject.controller;

import com.SWEProject.Entities.Administrator;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.ProductRepository;
import com.SWEProject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class NormalUserController {

    @Autowired
    private StoreRepository storeRep;
    @Autowired
    private ProductRepository productRep;


    @GetMapping("/NormalUserView")
    public String ShowNormalUserView(Model model)
    {
        model.addAttribute("store", new Store());
        return "normalUserView";
    }


    @RequestMapping("/StoresList" )
    public ModelAndView ShowStoresList(Model model , @ModelAttribute Store store)
    {
        model.addAttribute("stores", new Store());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stores",storeRep.findAll());
        modelAndView.setViewName( "storeList" );
        return  modelAndView;
    }

    @RequestMapping("/ShowProductDetails")
    public ModelAndView ViewStore(@ModelAttribute Product product  )
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",productRep.findOne(product.getSerialNumber()));
        modelAndView.setViewName( "productDetails" );
        return modelAndView;
    }
    @GetMapping("/GetStore")
    public String GetStore(Model model )
    {
        model.addAttribute("store" , new Store());
        return "getStoreForm";
    }

    @GetMapping("/StoreDetails")
    public String StoreDetails( )
    {
        return "storeDetails";
    }

    @RequestMapping("/StoreDetails")
    public ModelAndView StoreDetails(@ModelAttribute Store store  )
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("store",storeRep.findOne(store.getStoreName()));
        modelAndView.setViewName( "storeDetails" );
        return modelAndView;
    }

    @GetMapping("/ShowStoreProducts")
    public String ViewStoreGet(Model model )
    {
        model.addAttribute("stores", new Store());
        return "storeProducts";
    }

    @RequestMapping("/ShowStoreProducts")
    public ModelAndView ViewStore(Model model , @ModelAttribute Store store)
    {
        model.addAttribute("stores", new Store());
        System.out.println(store.getStoreName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",productRep.findAll());
        modelAndView.setViewName( "storeProducts" );
        return modelAndView;
    }


}
