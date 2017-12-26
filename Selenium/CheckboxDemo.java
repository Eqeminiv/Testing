import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckboxDemo {
    public static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element;
    public String text;
    public String xP;
    public int num1;
    public int num2;

    @BeforeClass
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void singleCheckbox(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        element = driver.findElement(By.id("isAgeSelected"));
        element.click();
        element = driver.findElement(By.xpath("//div[contains(@id,'txtAge') and not(contains(@style,'display: none;'))]"));
    }

    @Test
    public void multipleCheckboxes() {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        element = driver.findElement(By.xpath("//label[text()='Option 1']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 2']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 3']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 4']"));
        element.click();
        element = driver.findElement(By.id("isChkd"));
        Assert.assertTrue(element.getAttribute("value").equals("true"));
        element = driver.findElement(By.xpath("//label[text()='Option 4']"));
        element.click();
        element = driver.findElement(By.id("isChkd"));
        Assert.assertFalse(element.getAttribute("value").equals("true"));

    }


    @AfterClass
    public void fin(){
        driver.close();
    }


}
