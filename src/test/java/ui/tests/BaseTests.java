package ui.tests;

import ui.tools.ConfProperties;
import ui.tools.TestHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    public static WebDriver driver;


    @BeforeSuite
    public void setUp(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(TestHelper.class);
        }
    }



    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("addressPage"));
    }


//
//    @AfterClass
//    public static void Stop() {
//        driver.quit();
//    }
}
