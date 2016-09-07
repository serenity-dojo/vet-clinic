package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenLookingForAPetStore {

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
    @Test
    public void should_find_pet_stores() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://duckduckgo.com/");

        WebElement input = driver.findElement(By.id("search_form_input_homepage"));

        input.sendKeys("pet store");

        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();

        assertThat(driver.getTitle(), equalTo("pet store at DuckDuckGo"));

        driver.quit();
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
}

