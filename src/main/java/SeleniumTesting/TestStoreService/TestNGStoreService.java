package SeleniumTesting.TestStoreService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestNGStoreService {

    WebDriver driver;
    TestStoreService testStoreService = new TestStoreService();

    @BeforeTest
    void setUp(){
        System.setProperty("webdriver.chrome.driver","D:/Fadymbt/Documents/Software Engineering 2/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "stores")
    public static Object[][] TestAddBrand()
    {
        return new Object[][]{
                {"kazoza" , "onsite"},
                {"club aldo" , "online"}
        };
    }

    @Test(dataProvider = "stores")
    public void testAddStoreTest(String storeName , String storeType) throws Exception {
        assertEquals(true,testStoreService.addStoreTest(driver , storeName , storeType));
    }

    @Test
    public void testShowCollaboratorTest() throws Exception {
        assertEquals(true,testStoreService.showCollaboratorTest(driver ));
    }

    @AfterTest
    void setDown (){
        driver.close();
    }
}