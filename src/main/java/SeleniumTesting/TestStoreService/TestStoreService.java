package SeleniumTesting.TestStoreService;

import SeleniumTesting.TestUserService.TestUserService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestStoreService {

    TestUserService testUserService =new TestUserService();

    public boolean addStoreTest(WebDriver _driver , String storeName ,String storeType)
    {
        System.setProperty("webdriver.chrome.driver","E:/3rd year/2nd term/Software-2/Assignment/Assignment#2/chromedriver.exe");
        WebDriver driver = _driver;

        testUserService.loginTest(_driver,"laura","laura","storeOwner");

        while(!driver.getCurrentUrl().equals("http://localhost:4200/storeOwnerPage"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/app-root/div/app-store-owner-page/html/body/div[3]/button")).click();

        while(!driver.getCurrentUrl().equals("http://localhost:4200/addStore"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("//input[@name='storename']")).clear();
        driver.findElement(By.xpath("//input[@name='storename']")).sendKeys(storeName);

        driver.findElement(By.xpath("//select[@name='type']")).sendKeys(storeType);

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-store/html/body/div/form/button")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();

        if(alert.getText().equals("Store has been added successfully !"))
        {
            alert.accept();
            return true;
        }
        alert.accept();
        return false;

    }

    public boolean showCollaboratorTest(WebDriver _driver )
    {
        System.setProperty("webdriver.chrome.driver","E:/3rd year/2nd term/Software-2/Assignment/Assignment#2/chromedriver.exe");
        WebDriver driver = _driver;

        testUserService.loginTest(_driver,"laura","laura","storeOwner");

        while(!driver.getCurrentUrl().equals("http://localhost:4200/storeOwnerPage"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/app-root/div/app-store-owner-page/html/body/div[3]/table/tbody/tr[1]/td[5]/button")).click();

        while(!driver.getCurrentUrl().equals("http://localhost:4200/showCollaborators"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(driver.getCurrentUrl().equals("http://localhost:4200/showCollaborators"))
        {
            return true;
        }
        return false;
    }

}