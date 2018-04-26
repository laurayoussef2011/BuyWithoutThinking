package com.SWEProject.controllers;


import com.SWEProject.Entities.Brand;
import com.SWEProject.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brandAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping("/addBrand")
    public boolean addBrand(@RequestBody Brand brand)
    {
        return brandService.brandCheckAvailable(brand);
    }

}
