package SeleniumTesting.TestProductService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestNGProductService {
    WebDriver driver;
    TestProductService testProductService = new TestProductService();

    @BeforeTest
    void setUp(){
        System.setProperty("webdriver.chrome.driver","E:/3rd year/2nd term/Software-2/Assignment/Assignment#2/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "systemProduct")
    public static Object[][] TestAddSystemProduct()
    {
        return new Object[][]{
                {"iphone 4" , "iphone" , "apple" , "3000"},
                {"iphone X" , "iphone" , "apple" , "6000"},
        };
    }

    @DataProvider(name = "Product")
    public static Object[][] TestAddProduct()
    {
        return new Object[][]{
                {"iphone 4" , "iphone" , "apple" , "3000" , "3"},
                {"iphone X" , "iphone" , "apple" , "6000" , "2"}
        };
    }

    @Test(dataProvider = "systemProduct")
    public void testAddSystemProductTest(String productName , String brand , String model , String price) throws Exception {
        assertEquals(true,testProductService.addSystemProductTest(driver , productName , brand , model , price));
    }

    @Test(dataProvider = "Product")
    public void testAddProductTest(String productName , String brand , String model , String price ,String quantity) throws Exception {
        assertEquals(true,testProductService.addProductTest(driver , productName , brand , model , price ,quantity));
    }

    @AfterTest
    void setDown (){
        driver.close();
    }


}