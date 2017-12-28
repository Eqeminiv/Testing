import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class InputFormDemo {
    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element;
    static String firstName = "John";
    static String lastName = "Kentucky";
    static String email = "as@s";
    static String phone = "2313132312";
    static String address = "9/11; Manhattan";
    static String city = "New York";
    static String state = "New York";
    static String zipCode = "1234";
    static String website = "google.com";
    static String projectDescription = "Example description";


    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void properValuesInputForm(){
        driver.navigate().to("http://www.seleniumeasy.com/test/input-form-demo.html");
        inputText(firstName, "first_name");
        inputText(lastName, "last_name");
        inputText(email, "email");
        inputText(phone, "phone");
        inputText(address, "address");
        inputText(city, "city");
        inputText(zipCode, "zip");
        inputText(website,"website");
        inputText(projectDescription, "comment");


        driver.findElement(By.name("state")).click();
        driver.findElement(By.xpath("//option[text()='"+state+"']")).click();
        new WebDriverWait(driver, 5).withMessage("Cannot click button - test failed").until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        element = driver.findElement(By.xpath("//button[@type='submit']"));
        element.click();
        if(element.getAttribute("disabled").equals("disabled"))
        {
            driver.findElement(By.name("state")).click();
            driver.findElement(By.xpath("//option[text()='"+state+"']")).click();
            element.click();
            System.out.print("Test passed");
        }
    }

    public void inputText(String text, String name){
        driver.findElement(By.name(name)).sendKeys(text);
    }

    @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
