package com.SWEProject.service;

import com.SWEProject.Entities.*;
import com.SWEProject.repository.HistoryRepository;
import com.SWEProject.repository.ProductRepository;
import com.SWEProject.repository.StatRepository;
import com.SWEProject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service

public class storeService {

    @Autowired
    StoreRepository storeRep;
    @Autowired
    ProductRepository productRep;
    @Autowired
    HistoryRepository historyRep;
    @Autowired
    StatRepository statRep;
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
        Iterable<Store> storeIterable = storeRep.findAll();
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

        Method = Method.toLowerCase();
        if(Method.equals("max")){
            result.add(statistics.getMaxView(productList));
        }
        else if (Method.equals("min")){
            result.add(statistics.getMinView(productList));
        }
        else if(Method.equals("sort")){
            result = statistics.getProductSorted(productList);
        }
        return result;

    }

    public List<String> showMethods() {
        Iterable<Statistics> methods = statRep.findAll();
        List<String>listOfMethods = new ArrayList<>();
        for (Statistics s: methods)
        {
            listOfMethods.add(s.getMethod());
        }
        return listOfMethods;
    }

    public boolean addToHistory (Product product , String username , String type , String storeName){

        Date date =new Date();
        Integer time = date.getDate();
        History history;

        if(product.getSerialnumber() == -1){
            Product  newProduct = new Product(product.getProductname(), product.getStorename(), product.getPrice(),
                    product.getModel(), product.getBrand(), 0,product.getQuantity(), true);
             productRep.save(newProduct);
             history = new History(newProduct.getSerialnumber(),username,time,type,storeName);
        }
        else
        {
             history = new History(product.getSerialnumber(),username,time,type,storeName);
        }

        historyRep.save(history);

        return true;
    }

    public List<History> showHistory(String collaboratorName , String storeName){

        Iterable<History> historyIterable= historyRep.findAll();
        List<History> historyList =new ArrayList<>();
        for(History history : historyIterable)
        {
            if(history.getCollaborator_name().equals(collaboratorName) && history.getStore_name().equals(storeName)){
                historyList.add(history);
            }
        }
        return historyList;
    }

    public boolean undo(History history){
        if(history.getType().equals("remove")){
            Product product = productRep.findOne(history.getSerial_number());
            product.setAvailable(true);
            productRep.save(product);
            historyRep.delete(history.getCounter());

            return true;
        }
        else if(history.getType().equals("add")){
            productRep.delete(history.getSerial_number());
            historyRep.delete(history.getCounter());

            return true;
        }
        return false;
    }

}
