package SeleniumTesting.TestBrandService;

import SeleniumTesting.TestUserService.TestUserService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrandService {

    TestUserService testUserService =new TestUserService();
    public boolean addBrandTest(WebDriver _driver , String brandName )
    {
        System.setProperty("webdriver.chrome.driver","D:/Fadymbt/Documents/Software Engineering 2/chromedriver.exe");
        WebDriver driver =_driver;

        testUserService.loginTest(_driver , "fady" , "fady" ,"admin");

        while(!driver.getCurrentUrl().equals("http://localhost:4200/adminPage"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("/html/body/app-root/div/app-admin-page/body/div[2]/button[1]")).click();

        while(!driver.getCurrentUrl().equals("http://localhost:4200/addBrand"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("//input[@name='brand']")).clear();
        driver.findElement(By.xpath("//input[@name='brand']")).sendKeys(brandName);

        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Add')]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();

        if(alert.getText().equals("Brand has been added successfully !"))
        {
            alert.accept();
            return true;
        }
        alert.accept();
        return false;
    }
}

