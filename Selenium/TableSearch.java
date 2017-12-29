import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class TableSearch {

    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element;
    static String filterProper = "SEO tags";
    static String filterImproper = "seodfsd";
    static String name = "Zieko";


    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

   @Test
    public void filterSearch(){
        element = driver.findElement(By.id("task-table-filter"));
        element.sendKeys(filterProper);
        element = driver.findElement(By.xpath("//td[text()='"+filterProper+"']"));
        Assert.assertTrue(element.isDisplayed(), filterProper+" not found");

        element = driver.findElement(By.id("task-table-filter"));
        element.sendKeys(filterImproper);

        try {
            driver.findElement(By.xpath("//td[text()='"+filterProper+filterImproper+"']"));
        } catch (NoSuchElementException e) {
            System.out.println("Test successful - no record " + filterProper+filterImproper + " in this table - filter works properly.");
        }
    }

    @Test
    public void filterSearchWithButton(){
        //proper data
        element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        while(element.isEnabled() == false)
        {
            driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs btn-filter']")).click();
            if(element.isEnabled() == false)
            {
                System.out.println("Filter button is not working");
                throw new WebDriverException();

            }
        }

        element.sendKeys(name);
        element = driver.findElement(By.xpath("//td[text()='"+name+"']"));
        Assert.assertTrue(element.isDisplayed(), name+" not found");
    }

    // @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
