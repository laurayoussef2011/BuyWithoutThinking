package TestNG.TestNGProductService;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.SystemProduct;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.BrandRepository;
import com.SWEProject.repository.ProductRepository;
import com.SWEProject.repository.SystemProductRepository;
import com.SWEProject.repository.UserRepository;
import com.SWEProject.service.BrandService;
import com.SWEProject.service.ProductService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class ProductServiceTest {

    @Mock
    ProductRepository productRep;
    @Mock
    SystemProductRepository systemProductRep;
    @Mock
    UserRepository userRep;

    @InjectMocks
    ProductService productService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testSystemProductCheckAvailableSuccess()
    {
        String productName = "iPhone";
        String model = "4s";
        String brand = "Apple";
        double price = 1000;
        SystemProduct systemProduct = new SystemProduct(productName, model, brand, price);

        when(systemProductRep.save(systemProduct)).thenReturn(systemProduct);
        Assert.assertEquals(true, productService.systemProductCheckAvailable(systemProduct));
    }


    @Test
    public void testSystemProductCheckAvailableFailure()
    {
        String productName = "iPhone";
        String model = "4s";
        String brand = "Apple";
        double price = 1000;
        SystemProduct systemProduct = new SystemProduct(productName, model, brand, price);

        when(systemProductRep.save(systemProduct)).thenReturn(null);
        Assert.assertEquals(false, productService.systemProductCheckAvailable(systemProduct));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void AddProductSuccess()
    {
        String productName = "iPhone";
        String storeName = "tradeline";
        Integer price = 1000;
        String model = "4s";
        String brand = "Apple";
        Integer views = 0;
        Integer quantity = 10;
        boolean available = true;

        Product product = new Product(productName, storeName, price, model, brand, views, quantity, available);
        when(productRep.save(product)).thenReturn(product);
        Assert.assertEquals(true, productService.addProduct(product));
    }
    @Test
    public void AddProductFailure()
    {
        String productName = "iPhone";
        String storeName = "tradeline";
        Integer price = 1000;
        String model = "4s";
        String brand = "Apple";
        Integer views = 0;
        Integer quantity = 10;
        boolean available = true;

        Product product = new Product(productName, storeName, price, model, brand, views, quantity, available);
        when(productRep.save(product)).thenReturn(null);
        Assert.assertEquals(false, productService.addProduct(product));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void GetProductInfoSuccess()
    {
        Integer serialNumber = 1;

        Product product = new Product();
        product.setSerialnumber(serialNumber);
        when(productRep.findOne(serialNumber)).thenReturn(product);
        Assert.assertEquals(product, productService.getProductInfo(serialNumber));
    }

    @Test
    public void GetProductInfoFailure()
    {
        Integer serialNumber = 100; // wrong serial number

        Product product = new Product();
        product.setSerialnumber(serialNumber);
        when(productRep.findOne(serialNumber)).thenReturn(null);
        Assert.assertEquals(null, productService.getProductInfo(serialNumber));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void GetStoreProductListSuccess()
    {
        String storeName = "tradeline";
        List<Product> productList = new ArrayList();
        when(productRep.findAll()).thenReturn(productList);
        Assert.assertEquals(productList, productService.getStoreProductList(storeName));
    }
    @Test
    public void GetStoreProductListFailure()
    {
        String storeName = "tradeline";
        List<Product> productList = new ArrayList();
        when(productRep.findAll()).thenReturn(null);
        Assert.assertEquals(null, productService.getStoreProductList(storeName));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGetProductList()
    {
        List<Product> tempProductList = new ArrayList<>();
        tempProductList = (List<Product>)productRep.findAll();
        Assert.assertEquals(tempProductList, productService.getProductList());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testBuyProduct()
    {
        Integer serialNumber = 1;
        String address = "Dokki";
        Integer quantity = 2;

        User user = new User("laura" , "laura","laura","storeOwner","laura","",100000);
        Product product = new Product("iPhone","", 100, "4s", "Apple",10,10,true);
        when(productRep.findOne(serialNumber)).thenReturn(product);
        when(userRep.findOne(user.getUsername())).thenReturn(user);
        when(userRep.save(user)).thenReturn(user);
        when(productRep.save(product)).thenReturn(product);
        Assert.assertEquals(true, productService.buyProduct(serialNumber, address, quantity, user));
    }
    @Test
    public void testBuyProductFailure()
    {
        Integer serialNumber = 1;
        String address = "Dokki";
        Integer quantity = 2;

        User user = new User("laura" , "laura","laura","storeOwner","laura","",100000);
        Product product = new Product("iPhone","", 100, "4s", "Apple",10,1,true);
        when(productRep.findOne(serialNumber)).thenReturn(product);
        when(userRep.findOne(user.getUsername())).thenReturn(user);
        when(userRep.save(user)).thenReturn(user);
        when(productRep.save(product)).thenReturn(product);
        Assert.assertEquals(false, productService.buyProduct(serialNumber, address, quantity, user));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void RemoveProductSuccess()
    {
        Integer serialNumber = 1;
        Product product = new Product("iPhone","", 100, "4s", "Apple",10,1,true);
        product.setSerialnumber(1);
        when(productRep.exists(product.getSerialnumber())).thenReturn(true);
        when(productRep.findOne(serialNumber)).thenReturn(product);
        when(productRep.save(product)).thenReturn(product);
        Assert.assertEquals(true, productService.removeProduct(product));
    }
    @Test
    public void RemoveProductFailure()
    {
        Product product = new Product("iPhone","", 100, "4s", "Apple",10,1,true);
        product.setSerialnumber(1);
        when(productRep.exists(product.getSerialnumber())).thenReturn(false);

        Assert.assertEquals(false, productService.removeProduct(product));
    }

}