package com.SWEProject.service;

import com.SWEProject.Entities.Brand;
import com.SWEProject.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRep;

    public boolean brandCheckAvailable(Brand brand)
    {

        if( brand.getBrandname().equals("") || brandRep.exists(brand.getBrandname()))
        {
            return false;
        }
        else
        {
            brandRep.save(brand);
            return true;
        }
    }
}
