package com.SWEProject.controllers;


import com.SWEProject.Entities.History;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.HistoryRepository;
import com.SWEProject.service.ProductService;
import com.SWEProject.service.storeService;
import com.SWEProject.service.userService;
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
    @Autowired
    userService userServ;

    @Autowired
    private HistoryRepository historyRep;

    @PostMapping("/addStore")
    public boolean addStore(@RequestBody Store store)
    {
        return  storeServ.addStore(store);
    }

    @PostMapping("/addCollaborator")
    public boolean addCollaborator(@RequestBody User collaborator)
    {
        return  userServ.addCollaborator(collaborator);
    }

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody Product product)
    {
        return  productServ.addProduct(product );
    }

    @PostMapping("/removeProduct")
    public boolean removeProduct(@RequestBody Product product)
    {
        return  productServ.removeProduct(product);
    }


    @PostMapping("/incrementView")
    public boolean incrementView(@RequestBody Product product)
    {
          productServ.incrementView(product.getSerialnumber());
          return true;
    }

    @PostMapping("/buyProduct/{serialNumber}/{address}/{quantity}")
    public boolean buyProduct(@PathVariable Integer serialNumber,@PathVariable String address,@PathVariable Integer quantity ,@RequestBody User user)
    {
        System.out.println(serialNumber + "" + address + "" + quantity  + user.getUsername());
        return productServ.buyProduct(serialNumber,address,quantity , user);
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

    @PostMapping("/addToHistory/{username}/{type}/{storeName}")
    public boolean addToHistory(@PathVariable String username ,@PathVariable String type,@PathVariable String storeName, @RequestBody Product product)
    {
        return storeServ.addToHistory(product, username,type ,storeName);
    }

    @PostMapping("/showHistory/{userName}/{storeName}")
    public List<History> showHistory(@PathVariable String userName,@PathVariable String storeName)
    {
        return storeServ.showHistory(userName,storeName);
    }

    @PostMapping("/undo")
    public boolean undo(@RequestBody History history)
    {
        return storeServ.undo(history);
    }


}
