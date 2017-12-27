import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AjaxFormTests {
    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public static long tolerance;

    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        tolerance = 3000;
    }

    @Test
    public void AjaxFormSubmit(){
        driver.navigate().to("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
        driver.findElement(By.id("btn-submit")).click();

        driver.findElement(By.id("title")).sendKeys("Name");
        driver.findElement(By.id("description")).sendKeys("Comment");

        driver.findElement(By.id("btn-submit")).click();

        try{
            Thread.sleep(tolerance);
        }catch(InterruptedException ie){}
        Assert.assertTrue(driver.findElement(By.id("submit-control")).getText().equals("Form submited Successfully!"));

    }

    @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
