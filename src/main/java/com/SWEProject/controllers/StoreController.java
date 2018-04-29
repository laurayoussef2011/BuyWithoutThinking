package com.SWEProject.controllers;

import com.SWEProject.Entities.History;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.service.storeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")


public class StoreController {

    @Autowired
    storeService storeService;

    @PostMapping("/addStore")
    public boolean addStore(@RequestBody Store store)
    {

        return  storeService.addStore(store);
    }

    @GetMapping("/getStoreList")
    public List<Store> getStoreList()
    {
        return  storeService.getStoreList();
    }

    @PostMapping("/showStat/{Method}")
    public List<Product> showStat(@RequestBody Store store , @PathVariable String Method)
    {
        return storeService.ShowStat(store ,Method);
    }

    @PostMapping("/showMethods")
    public List<String> showStat()
    {
        return storeService.showMethods();
    }

    @PostMapping("/addToHistory/{username}/{type}/{storeName}")
    public boolean addToHistory(@PathVariable String username ,@PathVariable String type,@PathVariable String storeName, @RequestBody Product product)
    {
        return storeService.addToHistory(product, username,type ,storeName);
    }

    @PostMapping("/showHistory/{userName}/{storeName}")
    public List<History> showHistory(@PathVariable String userName, @PathVariable String storeName)
    {
        return storeService.showHistory(userName,storeName);
    }

    @PostMapping("/undo")
    public boolean undo(@RequestBody History history)
    {
        return storeService.undo(history);
    }

    @PostMapping("/getOwnerStoreList/{storeOwnerName}")
    public List<Store> getOwnerStoreList(@PathVariable String storeOwnerName)
    {
        return  storeService.getOwnerStoreList(storeOwnerName);
    }

}
