import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class SelectListDemo {

    static String driverPath = "C:/chromedriver.exe";
    public WebDriver driver;
    public WebElement element;
    public static String day;
    public static String[] states = {"Ohio","Florida","Washington"};;
    public Actions action;
    Select select;
    @BeforeClass
    public void setUp() {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        day = "Wednesday";


        action = new Actions(driver);
    }

    @Test
    public void selectList(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        element = driver.findElement(By.id("select-demo"));
        element.click();
        element = driver.findElement(By.xpath("//option[@value='"+day+"']"));
        element.click();

        element = driver.findElement(By.xpath("//p[text()='Day selected :- "+day+"']"));
        System.out.println("Test passed");
    }

    @Test
    public void multipleChoiceList(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        //action.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(By.xpath("//option[@value='"+states[0]+"']")))
       //         .click(driver.findElement(By.xpath("//option[@value='"+states[1]+"']")))
       //         .click(driver.findElement(By.xpath("//option[@value='"+states[2]+"']")))
        //        .keyUp(Keys.LEFT_CONTROL);

        element = driver.findElement(By.id("multi-select"));
        select = new Select(element);

        for(int i=0;i<3;i++)
        {
            select.selectByValue(states[i]);
        }

        for(WebElement elem : select.getAllSelectedOptions())
        {
            System.out.println(elem.getText());
        }
        driver.findElement(By.id("printMe")).click();
        element = driver.findElement(By.xpath("//p[text()='First selected option is : "+states[0]+"']")); //nie działa - nie mam pojęcia, czemu nie zapisuje wszystkich zaznaczonych pozycji.

        driver.findElement(By.id("printAll")).click();
        element = driver.findElement(By.xpath("//p[text()='Options selected are : "+states[0]+","+states[1]+","+states[2]+"']")); //także nie działa


    }
   // @AfterClass
    public void end(){
        if(driver != null)
            driver.close();
    }
}
