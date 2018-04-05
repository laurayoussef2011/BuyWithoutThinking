package com.SWEProject.controllers;


import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.service.ProductService;
import com.SWEProject.service.storeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeOwnerAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class StoreOwnerController {

    @Autowired
    storeService storeServ;
    @Autowired
    ProductService productServ;

    @PostMapping("/addStore")
    public boolean addStore(@RequestBody Store store)
    {
        return  storeServ.addStore(store);
    }

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody Product product)
    {
        return  productServ.addProduct(product);
    }

    @PostMapping("/incrementView")
    public boolean incrementView(@RequestBody Product product)
    {
          productServ.incrementView(product.getSerialnumber());
          return true;
    }

    @PostMapping("/buyProduct")
    public boolean buyProduct(@RequestBody Product product)
    {
        return productServ.buyProduct(product.getSerialnumber());
    }

    @GetMapping("/getProductList")
    public List<Product> getProductList()
    {
        return  productServ.getProductList();
    }

    @PostMapping("/getProductList/{storeName}")
    public List<Product> getStoreProductList(@PathVariable String storeName)
    {
        return  productServ.getStoreProductList(storeName);
    }

    @GetMapping("/getStoreList")
    public List<Store> getStoreList()
    {
        return  storeServ.getStoreList();
    }

    @PostMapping("/getOwnerStoreList/{storeOwnerName}")
    public List<Store> getOwnerStoreList(@PathVariable String storeOwnerName)
    {
        return  storeServ.getOwnerStoreList(storeOwnerName);
    }


    @PostMapping("/showStat/{Method}")
    public List<Product> showStat(@RequestBody Store store , @PathVariable String Method)
    {
        return storeServ.ShowStat(store ,Method);
    }
}
