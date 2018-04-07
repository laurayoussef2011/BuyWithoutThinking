package com.SWEProject.controller;

import com.SWEProject.Entities.Administrator;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.ProductRepository;
import com.SWEProject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

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
       Iterable<Product> productIterable= productRep.findAll();
        List<Product> productList =new ArrayList<>();
        for(Product product : productIterable)
        {
            if(product.getStoreName().equals(store.getStoreName()))
            {
                productList.add(product);
            }
        }
        modelAndView.addObject("product",productList);
        modelAndView.setViewName( "storeDetails" );
        return modelAndView;
    }


    // this function work but we need to edit the href !!

//    @RequestMapping(value = "/StoreDetails/{id}" , method = RequestMethod.GET)
//    public ModelAndView StoreDetails(@PathVariable String id  )
//    {
//        System.out.println("Store Name  " + id );
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("store",storeRep.findOne(id));
//        modelAndView.setViewName( "storeDetails" );
//        return modelAndView;
//    }


}
