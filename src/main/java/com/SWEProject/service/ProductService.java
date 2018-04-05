package com.SWEProject.service;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.SystemProduct;
import com.SWEProject.repository.ProductRepository;
import com.SWEProject.repository.SystemProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {

    @Autowired
    ProductRepository productRep;
    @Autowired
    SystemProductRepository systemProductRep;

    public boolean systemProductCheckAvailable(SystemProduct systemProduct )
    {

        if(systemProduct.getProductname().equals("") || systemProduct.getPrice()==0 ||
                systemProduct.getModel().equals("") || systemProduct.getBrand().equals(""))
        {
            System.out.println("there is missing data" );
            return false;
        }
        if(!systemProductRep.exists(systemProduct.getProductname()))
        {
            systemProductRep.save(systemProduct);

            return true;
        }
        System.out.println("allready exists" );
        return false;
    }

    public boolean addProduct(Product product) {

        if (product.getProductname().equals("") || product.getStorename().equals("") || product.getModel().equals("") ||
                product.getBrand().equals("") || product.getPrice() == 0) {
            return false;
        }
        if(systemProductRep.exists(product.getProductname()))
        {
            Product newProduct = new Product(product.getProductname(), product.getStorename(), product.getPrice(), product.getModel(), product.getBrand(), 0, true);
            productRep.save(newProduct);
            return true;
        }
        return false;
    }

    public void incrementView(Integer serialNumber){
       Product tempProduct = productRep.findOne(serialNumber);
       tempProduct.setViews(productRep.findOne(serialNumber).getViews()+1);
       productRep.delete(serialNumber);
       productRep.save(tempProduct);
    }

    public Product getProductInfo(Integer serialNumber){

        return productRep.findOne(serialNumber);
    }

    public List<Product> getStoreProductList(String storeName){

        Iterable<Product> productIterable= productRep.findAll();
        List<Product> productList =new ArrayList<>();
        for(Product product : productIterable)
        {
            if(product.getStorename().equals(storeName) && product.getAvailable())
            {
                productList.add(product);
            }
        }

        return productList;
    }

    public List<Product> getProductList() {
        return (List<Product>) productRep.findAll();

    }

    public boolean buyProduct(Integer serialNumber){
        Product tempProduct = productRep.findOne(serialNumber);
        if(tempProduct.getAvailable()){

            tempProduct.setAvailable(false);
            productRep.delete(serialNumber);
            productRep.save(tempProduct);
            return true;
        }
        System.out.println("this item is not avail");
        return false;
    }







}
