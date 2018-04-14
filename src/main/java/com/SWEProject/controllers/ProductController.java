package com.SWEProject.controllers;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.User;
import com.SWEProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody Product product)
    {

        return  productService.addProduct(product );
    }

    @PostMapping("/removeProduct")
    public boolean removeProduct(@RequestBody Product product)
    {

        return  productService.removeProduct(product);
    }

    @PostMapping("/incrementView")
    public boolean incrementView(@RequestBody Product product)
    {
        productService.incrementView(product.getSerialnumber());
        return true;
    }

    @PostMapping("/buyProduct/{serialNumber}/{address}/{quantity}")
    public boolean buyProduct(@PathVariable Integer serialNumber, @PathVariable String address, @PathVariable Integer quantity , @RequestBody User user)
    {
        System.out.println(serialNumber + "" + address + "" + quantity  + user.getUsername());
        return productService.buyProduct(serialNumber,address,quantity , user);
    }

    @GetMapping("/getProductList")
    public List<Product> getProductList()
    {

        return  productService.getProductList();
    }

    @PostMapping("/getProductList/{storeName}")
    public List<Product> getStoreProductList(@PathVariable String storeName)
    {
        return  productService.getStoreProductList(storeName);
    }}

