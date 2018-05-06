package SeleniumTesting.TestProductService;

import SeleniumTesting.TestUserService.TestUserService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestProductService {

    TestUserService testUserService =new TestUserService();

    public boolean addSystemProductTest(WebDriver _driver , String productName , String brand , String model , String price )
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

        driver.findElement(By.xpath("//button[@tabindex='0'][contains(text(),'add system Product')]")).click();

        while(!driver.getCurrentUrl().equals("http://localhost:4200/addSystemProduct"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("//input[@name='productName']")).clear();
        driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(productName);

        driver.findElement(By.xpath("//input[@name='model']")).clear();
        driver.findElement(By.xpath("//input[@name='model']")).sendKeys(model);

        driver.findElement(By.xpath("//html[1]/body[1]/div[1]/form[1]/input[3]")).clear();
        driver.findElement(By.xpath("//html[1]/body[1]/div[1]/form[1]/input[3]")).sendKeys(brand);

        driver.findElement(By.xpath("//input[@name='price']")).clear();
        driver.findElement(By.xpath("//input[@name='price']")).sendKeys(price);

        driver.findElement(By.xpath("//html[1]/body[1]/div[1]/form[1]/button[1]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();

        if(alert.getText().equals("System product has been added successfully !"))
        {
            alert.accept();
            return true;
        }
        alert.accept();
        return false;
    }

    public boolean addProductTest(WebDriver _driver , String productName , String brand , String model , String price, String quantity )
    {
        System.setProperty("webdriver.chrome.driver","D:/Fadymbt/Documents/Software Engineering 2/chromedriver.exe");
        WebDriver driver =_driver;

        testUserService.loginTest(_driver , "laura" , "laura" ,"storeOwner");

        while(!driver.getCurrentUrl().equals("http://localhost:4200/storeOwnerPage"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("//html[1]/body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/button[1]")).click();

        while(!driver.getCurrentUrl().equals("http://localhost:4200/addProduct"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[1]")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[1]")).sendKeys(productName);

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[2]")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[2]")).sendKeys(price);

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[3]")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[3]")).sendKeys(model);

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[4]")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[4]")).sendKeys(brand);

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[5]")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/input[5]")).sendKeys(quantity);

        driver.findElement(By.xpath("/html/body/app-root/div/app-add-product/body/div/form/button")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();

        if(alert.getText().equals("Product has been added successfully !"))
        {
            alert.accept();
            return true;
        }
        alert.accept();
        return false;
    }
}
