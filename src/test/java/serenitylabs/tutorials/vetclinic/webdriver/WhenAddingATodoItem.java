package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenAddingATodoItem {
    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void init() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:\\Users\\sapurani\\Desktop\\Chrome Driver\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();

    }


    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {

        System.setProperty("webdriver.chrome.driver", "D:\\Users\\sapurani\\Desktop\\Chrome Driver\\chromedriver.exe");
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }


    @Test
    public void should_add_new_item_to_list() {
        WebDriver webDriver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://todomvc.com/examples/angularjs/#/");

        WebElement inputField = driver.findElement(By.id("new-todo"));
        inputField.sendKeys("Buy some milk");

        inputField.sendKeys(Keys.RETURN);

        WebElement todoListContents = driver.findElement(By.id("todo-list"));
        assertThat(todoListContents.getText(), containsString("Buy some milk"));
    }

}
