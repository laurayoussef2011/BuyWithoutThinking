package SeleniumTesting.TestBrandService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class TestNGBrandService {

    WebDriver driver;
    TestBrandService testBrandService = new TestBrandService();

    @BeforeTest
    void setUp(){
        System.setProperty("webdriver.chrome.driver","D:/Fadymbt/Documents/Software Engineering 2/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "brands")
    public static Object[][] TestAddBrand()
    {
        return new Object[][]{
                {"apple" },
                {"club aldo"},
                {"apple1" },
                {"club aldo1"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "brands")
    public void testAddBrand(String brandName) throws Exception
    {
        assertEquals(true,testBrandService.addBrandTest(driver , brandName));
    }

    @AfterTest
    void setDown (){
        driver.close();
    }
}