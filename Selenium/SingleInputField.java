import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingleInputField {
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
        text = "Example";
        num1 = 2;
        num2 = 3;


    }

    @Test
    public void singleInputField(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
        element = driver.findElement(By.id("user-message")) ;
        element.sendKeys(text);
        element = driver.findElement(By.xpath("//button[@type='button' and @onclick='showInput();']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@id='display']"));
        Assert.assertEquals(element.getText(),text);
    }

    @Test
    public void twoInputFields(){
        driver.navigdate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
        element = driver.findElement(By.id("sum1"));
        element.sendKeys(String.valueOf(num1));
        element = driver.findElement(By.id("sum2"));
        element.sendKeys(String.valueOf(num2));
        element = driver.findElement(By.xpath("//button[@type='button' and @onclick='return total()']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@id='displayvalue']"));
        Assert.assertEquals(element.getText(), String.valueOf(num1+num2));
    }

    @AfterClass
    public void fin(){
        driver.close();
    }


}
