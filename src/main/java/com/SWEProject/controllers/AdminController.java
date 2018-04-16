package com.SWEProject.controllers;

import com.SWEProject.Entities.Brand;
import com.SWEProject.Entities.SystemProduct;
import com.SWEProject.service.BrandService;
import com.SWEProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class AdminController {

    @Autowired
    ProductService ProductService;
    @Autowired
    BrandService BrandService;


    @PostMapping("/addSystemProduct")
    public boolean addSystemProduct(@RequestBody SystemProduct systemProduct)
    {
        return ProductService.systemProductCheckAvailable(systemProduct);
    }

    @PostMapping("/addBrand")
    public boolean addBrand(@RequestBody Brand brand)
    {
        return BrandService.brandCheckAvailable(brand);
    }

}
