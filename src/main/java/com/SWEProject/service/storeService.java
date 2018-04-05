package com.SWEProject.service;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Statistics;
import com.SWEProject.Entities.Store;
import com.SWEProject.repository.ProductRepository;
import com.SWEProject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class storeService {

    @Autowired
    StoreRepository storeRep;
    @Autowired
    ProductService productServ;

    public boolean addStore ( Store store){

        if (store.getStorename().equals("") || store.getStoreowner().equals("") || store.getType().equals("")) {
            return false;
        }
        if (storeRep.exists(store.getStorename())) {
            return false;
        }
        else {
            storeRep.save(store);
            return true;
        }

    }

    public List<Store> getStoreList(){
        return (List<Store>) storeRep.findAll();
    }

    public List<Store> getOwnerStoreList(String storeOwnerName){
        Iterable<Store> storeIterable= storeRep.findAll();
        List<Store> storeList =new ArrayList<>();
        for(Store store : storeIterable)
        {
            if(store.getStoreowner().equals(storeOwnerName))
            {
                storeList.add(store);
            }
        }
        return storeList;
    }

    public List<Product> ShowStat(Store store , String Method) {

        Statistics statistics =new Statistics();
        List<Product> result = new ArrayList<>();
        List<Product> productList =productServ.getStoreProductList(store.getStorename()) ;

        if(Method.equals("Max")){
            result.add(statistics.getMaxView(productList));
        }
        else if (Method.equals("Min")){
            result.add(statistics.getMinView(productList));
        }
        else if(Method.equals("Sort")){
            result = statistics.getProductSorted(productList);
        }
        return result;

    }



}
