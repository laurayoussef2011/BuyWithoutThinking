package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Statistics {
    @Id
    private String method;

    public Statistics() {
    }

    public Statistics(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public static List<Product> sort(List<Product> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size()/2;
        return merged(
                sort(list.subList(0, mid)),
                sort(list.subList(mid, list.size())));
    }

    private static List<Product> merged(List<Product> left, List<Product> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Product> merged = new ArrayList<Product>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).getViews() > right.get(rightIndex).getViews()) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }


    public Product getMaxView(List<Product> productList){
        Product Temp=productList.get(0);
        for(int i =1 ; i <productList.size() ; i++)
        {
            if(productList.get(i).getViews() > Temp.getViews())
            {
                Temp=productList.get(i);
            }
        }
        return Temp;
    }

    public Product getMinView(List<Product> productList){
        Product Temp=productList.get(0);
        for(int i =1 ; i <productList.size() ; i++)
        {
            if(productList.get(i).getViews() < Temp.getViews())
            {
                Temp=productList.get(i);
            }
        }
        return Temp;
    }

    public List<Product> getProductSorted(List<Product> productList){
        return sort(productList);
    }

}
