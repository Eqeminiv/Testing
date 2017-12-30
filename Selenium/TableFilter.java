import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TableFilter {

    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element, element2, element3;

    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.seleniumeasy.com/test/table-records-filter-demo.html");
    }

    @Test
    public void filter(){
        driver.findElement(By.xpath("//button[@data-target='pagado']")).click();

        element = driver.findElement(By.xpath("//tr[@data-status='pendiente']"));
        element2 = driver.findElement(By.xpath("//tr[@data-status='pagado']"));
        element3 = driver.findElement(By.xpath("//tr[@data-status='cancelado']"));
        Assert.assertFalse(element.isDisplayed() && !element2.isDisplayed() && element3.isDisplayed());
    }

    @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
