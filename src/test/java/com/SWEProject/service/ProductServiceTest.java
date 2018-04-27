package com.SWEProject.service;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.SystemProduct;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.ProductRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ProductServiceTest {

    ProductService productService = new ProductService();

    @Autowired
    ProductRepository productRep;

    @DataProvider(name = "systemProductCheckAvailableSuccess")
    public static Object[][] Test_systemProductCheckAvailableSuccess()
    {
        return new Object[][]{
                {"iphone", "iphone", "apple", 5.0},
                {"galaxy", "phone", "samsung", 5.0},
                {"335", "phone", "nokia", 5.0}
        };
    }
    @DataProvider(name = "systemProductCheckAvailableFailure")
    public static Object[][] Test_systemProductCheckAvailableFailure()
    {
        return new Object[][]{
                {"ggsgs", "fffaef", "fafafa", 1100000000},
                {"qwer", "asd", "adf", 50000},
                {"qwerty", "zxc", "ikl", 7895462}
        };
    }
    @DataProvider(name = "systemProductCheckAvailableError")
    public static Object[][] Test_systemProductCheckAvailableError()
    {
        return new Object[][]{
                {" "," "," ",0}
        };
    }



    @DataProvider(name = "addProductSuccess")
    public static Object[][] Test_addProductSuccess()
    {
        return new Object[][]{
                {"iphone","tradeline",130000,"phone","apple",5,100,true},
                {"galaxy","samsungstore",130000,"phone","samsung",6,200,true}
        };
    }
    @DataProvider(name = "addProductFailure")
    public static Object[][] Test_addProductFailure()
    {
        return new Object[][]{
                {"s","s",1,"s","s",0,1000,true},
                {"f","f",96,"p","sams",7,2500,false}
        };
    }
    @DataProvider(name = "addProductError")
    public static Object[][] Test_addProductError()
    {
        return new Object[][]{
                {" "," ",0,"","",0,0,false}
        };
    }



    @DataProvider(name = "getProductInfoSuccess")
    public static Object[][] TestgetProductInfoSuccess()
    {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }
    @DataProvider(name = "getProductInfoFailure")
    public static Object[][] TestgetProductInfoFailure()
    {
        return new Object[][]{
                {100},
                {200},
                {300}
        };
    }
    @DataProvider(name = "getProductInfoError")
    public static Object[][] TestgetProductInfoError()
    {
        return new Object[][]{
                {-1},
                {-2},
                {-3}
        };
    }



    @DataProvider(name = "getStoreProductListSuccess")
    public static Object[][] TestgetStoreProductListSuccess()
    {
        return new Object[][]{
                {"nike"},
                {"addidas"},
                {"tradeline"}
        };
    }
    @DataProvider(name = "getStoreProductListFailure")
    public static Object[][] TestgetStoreProductListFailure()
    {
        return new Object[][]{
                {"h&m"},
                {"active_abo_alaa"},
                {"Hardees"}
        };
    }
    @DataProvider(name = "getStoreProductListError")
    public static Object[][] TestgetStoreProductListError()
    {
        return new Object[][]{
                {""},
                {" "},
        };
    }



    @DataProvider(name = "buyProductSuccess")
    public static Object[][] TestbuyProductSuccess()
    {
        return new Object[][]{
                {1,"haram street",2, "m.samy", 500},
                {1,"faisal street", 3, "shaar", 600}
        };
    }
    @DataProvider(name = "buyProductFailure")
    public static Object[][] TestbuyProductFailure()
    {
        return new Object[][]{
                {1,"haram street",2, "Odin", 500},
                {1,"faisal street", 3, "What", 600}
        };
    }
    @DataProvider(name = "buyProductError")
    public static Object[][] TestbuyProductError()
    {
        return new Object[][]{
                {-9," ",-9, " ", -9},
                {-9," ", 3, " ", -9}
        };
    }



    @DataProvider(name = "removeProductSuccess")
    public static Object[][] TestremoveProduct()
    {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }
    @DataProvider(name = "removeProductFailure")
    public static Object[][] TestremoveProductFailure()
    {
        return new Object[][]{
                {100},
                {200},
                {300}
        };
    }
    @DataProvider(name = "removeProductError")
    public static Object[][] TestremoveProductError()
    {
        return new Object[][]{
                {-1},
                {-2},
                {-3}
        };
    }



    @Test(dataProvider = "systemProductCheckAvailableSuccess")
    public void testSystemProductCheckAvailableSuccess(String productName,String Model, String Brand, double Price)
    {
        SystemProduct tempsystemProduct = new SystemProduct(productName, Model, Brand, Price);
        Assert.assertEquals(true, productService.systemProductCheckAvailable(tempsystemProduct));
    }
    @Test(dataProvider = "systemProductCheckAvailableFailure")
    public void testSystemProductCheckAvailableFailure(String productName,String Model, String Brand, double Price)
    {
        SystemProduct tempsystemProduct = new SystemProduct(productName, Model, Brand, Price);
        Assert.assertEquals(false, productService.systemProductCheckAvailable(tempsystemProduct));
    }
    @Test(dataProvider = "systemProductCheckAvailableError")
    public void testSystemProductCheckAvailableError(String productName,String Model, String Brand, double Price)
    {
        SystemProduct tempsystemProduct = new SystemProduct(productName, Model, Brand, Price);
        Assert.assertEquals(false, productService.systemProductCheckAvailable(tempsystemProduct));
    }



    @Test(dataProvider = "addProductSuccess")
    public void testAddProductSuccess(String productName, String storeName, Integer price, String model, String brand, Integer views ,Integer quantity, boolean available)
    {
        Product tempProduct = new Product(productName, storeName, price, model, brand, views, quantity, available);
        Assert.assertEquals(true, productService.addProduct(tempProduct));
    }
    @Test(dataProvider = "addProductFailure")
    public void testAddProductFailure(String productName, String storeName, Integer price, String model, String brand, Integer views ,Integer quantity, boolean available)
    {
        Product tempProduct = new Product(productName, storeName, price, model, brand, views, quantity, available);
        Assert.assertEquals(false, productService.addProduct(tempProduct));
    }
    @Test(dataProvider = "addProductError")
    public void testAddProductError(String productName, String storeName, Integer price, String model, String brand, Integer views ,Integer quantity, boolean available)
    {
        Product tempProduct = new Product(productName, storeName, price, model, brand, views, quantity, available);
        Assert.assertEquals(false, productService.addProduct(tempProduct));
    }



    @Test(dataProvider = "getProductInfoSuccess")
    public void testGetProductInfoSuccess(Integer serialNumber)
    {
        Product tempProduct = productRep.findOne(serialNumber);
        Assert.assertEquals(tempProduct, productService.getProductInfo(serialNumber));
    }
    @Test(dataProvider = "getProductInfoFailure")
    public void testGetProductInfoFailure(Integer serialNumber)
    {
        Product tempProduct = productRep.findOne(serialNumber);
        Assert.assertEquals(tempProduct, productService.getProductInfo(serialNumber));
    }
    @Test(dataProvider = "getProductInfoError")
    public void testGetProductInfoError(Integer serialNumber)
    {
        Product tempProduct = productRep.findOne(serialNumber);
        Assert.assertEquals(tempProduct, productService.getProductInfo(serialNumber));
    }



    @Test(dataProvider = "getStoreProductListSuccess")
    public void testGetStoreProductListSuccess(String storeName)
    {
        Iterable<Product> productIterable= productRep.findAll();
        List<Product> productList =new ArrayList<Product>();
        for(Product product : productIterable)
        {
            if(product.getStorename().equals(storeName) && product.getAvailable())
            {
                productList.add(product);
            }
        }
        Assert.assertEquals(productList, productService.getStoreProductList(storeName));
    }
    @Test(dataProvider = "getStoreProductListFailure")
    public void testGetStoreProductListFailure(String storeName)
    {
        Iterable<Product> productIterable= productRep.findAll();
        List<Product> productList =new ArrayList<Product>();
        for(Product product : productIterable)
        {
            if(product.getStorename().equals(storeName) && product.getAvailable())
            {
                productList.add(product);
            }
        }
        Assert.assertEquals(productList, productService.getStoreProductList(storeName));
    }
    @Test(dataProvider = "getStoreProductListError")
    public void testGetStoreProductListError(String storeName)
    {
        Iterable<Product> productIterable= productRep.findAll();
        List<Product> productList =new ArrayList<Product>();
        for(Product product : productIterable)
        {
            if(product.getStorename().equals(storeName) && product.getAvailable())
            {
                productList.add(product);
            }
        }
        Assert.assertEquals(productList, productService.getStoreProductList(storeName));
    }

    @Test
    public void testGetProductList()
    {
        List<Product> tempProductList = new ArrayList<>();
        tempProductList = (List<Product>)productRep.findAll();
        Assert.assertEquals(tempProductList, productService.getProductList());
    }

    @Test(dataProvider = "buyProductSuccess")
    public void testBuyProduct(Integer serialNumber ,String address , Integer quantity, String username, Integer credit)
    {
        User tempuser = new User();
        tempuser.setUsername(username);
        tempuser.setCredit(credit);
        Assert.assertEquals(true, productService.buyProduct(serialNumber, address, quantity, tempuser));
    }
    @Test(dataProvider = "buyProductFailure")
    public void testBuyProductFailure(Integer serialNumber ,String address , Integer quantity, String username, Integer credit)
    {
        User tempuser = new User();
        tempuser.setUsername(username);
        tempuser.setCredit(credit);
        Assert.assertEquals(false, productService.buyProduct(serialNumber, address, quantity, tempuser));
    }
    @Test(dataProvider = "buyProductError")
    public void testBuyProductError(Integer serialNumber ,String address , Integer quantity, String username, Integer credit)
    {
        User tempuser = new User();
        tempuser.setUsername(username);
        tempuser.setCredit(credit);
        Assert.assertEquals(false, productService.buyProduct(serialNumber, address, quantity, tempuser));
    }



    @Test(dataProvider = "removeProductSuccess")
    public void testRemoveProduct(Integer serialNumber)
    {
        Product tempProduct = new Product();
        tempProduct.setSerialnumber(serialNumber);
        Assert.assertEquals(true, productService.removeProduct(tempProduct));
    }
    @Test(dataProvider = "removeProductFailure")
    public void testRemoveProductFailure(Integer serialNumber)
    {
        Product tempProduct = new Product();
        tempProduct.setSerialnumber(serialNumber);
        Assert.assertEquals(false, productService.removeProduct(tempProduct));
    }
    @Test(dataProvider = "removeProductError")
    public void testRemoveProductError(Integer serialNumber)
    {
        Product tempProduct = new Product();
        tempProduct.setSerialnumber(serialNumber);
        Assert.assertEquals(false, productService.removeProduct(tempProduct));
    }

}