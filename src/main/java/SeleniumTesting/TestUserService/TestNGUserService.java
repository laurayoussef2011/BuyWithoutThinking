package SeleniumTesting.TestUserService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestNGUserService {
    WebDriver driver;
    TestUserService testUserService = new TestUserService();

    @BeforeTest
    void setUp(){

        System.setProperty("webdriver.chrome.driver","D:/Fadymbt/Documents/Software Engineering 2/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @DataProvider(name = "users")
    public static Object[][] TestLogin()
    {
        return new Object[][]{
                {"fady" , "fady" , "admin"},
                {"laura" , "laura" , "storeOwner"},
                {"ramez" , "anything' or 'x'='x" , "normalUser"}
        };
    }

    @DataProvider(name = "registers")
    public static Object[][] TestRegister()
    {
        return new Object[][]{
               // {"fady" , "fady" ,"fady" , "fady" , "admin"},
                {"koky" , "koky" ,"koky" , "koky" , "admin"}
        };
    }

    @Test(dataProvider = "users")
    public void testLoginTest(String userName ,String password, String type) throws Exception
    {
        assertEquals(true,testUserService.loginTest(driver , userName , password , type));
    }

    @Test(dataProvider = "registers")
    public void testRegisterTest(String name, String userName ,String email,String password, String type) throws Exception
    {
        assertEquals(true,testUserService.registerTest(driver , name , userName ,email , password , type));
    }

    @Test(dataProvider = "registers")
    public void testAddCollaboratorTest(String name, String userName ,String email,String password, String type) throws Exception
    {
        assertEquals(true,testUserService.addCollaboratorTest(driver , name , userName ,email , password , type));
    }

    @AfterTest
    void setDown (){
        driver.close();
    }
}