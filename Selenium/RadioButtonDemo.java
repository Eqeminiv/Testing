import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonDemo {

    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element;

    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
        @Test
        public void oneRadioButton () {
            driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
            element = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
            element.click();
            element = driver.findElement(By.id("buttoncheck"));
            element.click();
            element = driver.findElement(By.xpath("//p[text()=\"Radio button 'Male' is checked\"]"));
        }

        @Test
        public void groupRadioButtons(){
            driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
            element = driver.findElement(By.xpath("//input[@value='Female' and @name='gender']"));
            element.click();
            element = driver.findElement(By.xpath("//input[@value='15 - 50' and @name='ageGroup']"));
            element.click();
            element = driver.findElement(By.xpath("//button[@onclick='getValues();' and @type='button']"));
            element.click();
            element = driver.findElement(By.xpath("//p[text()='Sex : Female']"));
            element = driver.findElement(By.xpath("//p[text()=' Age group: 15 - 50']"));
        }

        @AfterClass
        public void end(){
            if(driver != null)
                driver.close();
    }

}
