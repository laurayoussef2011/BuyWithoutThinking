package com.SWEProject.controllers;

import com.SWEProject.Entities.SystemProduct;

import com.SWEProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/systemProductAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class systemProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addSystemProduct")
    public boolean addSystemProduct(@RequestBody SystemProduct systemProduct)
    {
        return productService.systemProductCheckAvailable(systemProduct);
    }

}
