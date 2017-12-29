import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JQueryDropdown {

    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element;
    static String countryFragment = "aus";
    static String countryFull = "Australia";
    static String state = "Colorado";
    static String territory = "guam";
    public Actions action;

    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        action = new Actions(driver);
        driver.navigate().to("http://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
    }

    @Test
    public void dropdownSearch(){
        element = driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default']"));
        element.click();
        element = driver.findElement(By.xpath("//span/input[@class='select2-search__field']"));
        element.sendKeys(countryFragment);
        element.sendKeys(Keys.ENTER);
        element = driver.findElement(By.id("select2-country-container"));

        Assert.assertTrue(element.getAttribute("title").equals(countryFull));
    }

    @Test
    public void selectMultiple(){
        element = driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default' and @style='width: 50%;']"));
        element.click();
        element = driver.findElement(By.xpath("//li[text()='"+state+"']"));
        element.click();

        driver.findElement(By.xpath("//span[@class='select2-selection__choice__remove']")).click();
        element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));

        Assert.assertEquals(element.getAttribute("placeholder"),"Select state(s)");
    }

    @Test
    public void dropdownDisabled(){
        element = driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single' and @aria-labelledby!='select2-country-container']"));
        element.click();
        element = driver.findElement(By.xpath("//span/input[@class='select2-search__field']"));
        element.sendKeys(territory);
        element.sendKeys(Keys.ENTER);

        //check
    }

    @Test
    public void dropdownCategories(){
        element = driver.findElement(By.id("files"));
        element.click();
        driver.findElement(By.xpath("//option[@value='somefile']")).click();
        element.click();
        driver.findElement(By.xpath("//optgroup[@label='Scripting languages']")).click(); //check
    }

    // @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
