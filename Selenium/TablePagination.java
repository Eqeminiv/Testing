import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class TablePagination {

    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element, element2;

    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.seleniumeasy.com/test/table-pagination-demo.html");
    }

    @Test
    public void checkButtons(){
        driver.findElement(By.xpath("//a[text()='3']")).click();
        element = driver.findElement(By.xpath("//a[@class='next_link']"));
        element2 = driver.findElement(By.xpath("//a[@class='prev_link']"));
        Assert.assertFalse(element.isDisplayed() && !element2.isDisplayed());
        driver.findElement(By.xpath("//a[text()='2']")).click();
        Assert.assertTrue(element.isDisplayed() && element2.isDisplayed());
        driver.findElement(By.xpath("//a[text()='1']")).click();
        Assert.assertTrue(element.isDisplayed() && !element2.isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='5']")).isDisplayed()
                            && !(driver.findElement(By.xpath("//td[text()='6']")).isDisplayed()));
    }

    @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
