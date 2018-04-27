package SeleniumTesting.TestUserService;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestUserService {
    public boolean loginTest(WebDriver _driver , String userName ,String password ,String type )
    {
        System.setProperty("webdriver.chrome.driver","E:/3rd year/2nd term/Software-2/Assignment/Assignment#2/chromedriver.exe");
        WebDriver driver = _driver;

        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//select[@name='type']")).sendKeys(type);
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        while(driver.getCurrentUrl().equals("http://localhost:4200/login"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(driver.getCurrentUrl().equals("http://localhost:4200/" + type + "Page"))
        {
            return true;
        }
        return false;

    }

    public boolean registerTest(WebDriver _driver , String name, String userName , String email ,String password ,String type )
    {
        System.setProperty("webdriver.chrome.driver","E:/3rd year/2nd term/Software-2/Assignment/Assignment#2/chromedriver.exe");
        WebDriver driver = _driver;

        driver.get("http://localhost:4200/register");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

        driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        driver.findElement(By.xpath("//select[@name='type']")).sendKeys(type);

        driver.findElement(By.xpath("//button[@type='submit']")).click();


        while(driver.getCurrentUrl().equals("http://localhost:4200/register"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(driver.getCurrentUrl().equals("http://localhost:4200/login" ))
        {
            System.out.println("registered successfully");
            return true;
        }
        return false;

    }

    public boolean addCollaboratorTest(WebDriver _driver , String name, String userName , String email ,String password,String type)
    {
        System.setProperty("webdriver.chrome.driver", "E:/3rd year/2nd term/Software-2/Assignment/Assignment#2/chromedriver.exe");
        WebDriver driver = _driver;

        loginTest(_driver, "laura", "laura" , "storeOwner");

        while (!driver.getCurrentUrl().equals("http://localhost:4200/storeOwnerPage"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("//html//tr[1]/td[4]")).click();

        while (!driver.getCurrentUrl().equals("http://localhost:4200/addCollaborator"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

        driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Add')]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();

        if(alert.getText().equals("Add collaborator successfully !"))
        {
            alert.accept();
            return true;
        }
        alert.accept();
        return false;
    }

}
