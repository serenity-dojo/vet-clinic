package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhenInteractingWithElementsAndForms {
    WebDriver driver;

    @BeforeClass()
    public static void setUpClass(){

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\siddharthk\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void entering_a_field_value() {

        WebElement fromElement = driver.findElement(By.id("display_origin"));
        fromElement.sendKeys("Town Hall");

        String displayedValue = fromElement.getAttribute("value");
        assertThat(displayedValue, equalTo("Town Hall"));
    }


    @Test
    public void click_on_a_button() {
        // TODO: Click on the View Trip button
        driver.findElement(By.id("display_origin")).sendKeys("Town Hall");
        driver.findElement(By.id("display_destination")).sendKeys("Parramatta");

        WebElement btnTripPlannerSubmit = driver.findElement(By.id("btnTripPlannerSubmit"));
        btnTripPlannerSubmit.click();

        assertThat(driver.getTitle(), containsString("Trip results"));
    }

    @Test
    public void click_on_a_checkbox() {
        // TODO: Click on the Remember Me checkbox

        WebElement chkPlannerRemember = driver.findElement(By.id("chkPlannerRemember"));
        chkPlannerRemember.click();
        assertThat(chkPlannerRemember.isSelected(), is(true));
    }

    @Test
    public void click_on_a_radio_button() {

        // TODO: Choose the 'Leave After' option and make sure it is the one selected

        WebElement itdTripDateTimeDep = driver.findElement(By.id("itdTripDateTimeDep"));
       itdTripDateTimeDep.click();

        assertThat(itdTripDateTimeDep.isSelected(), is(true));
        assertThat(itdTripDateTimeDep.getAttribute("value"), is("dep"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm

        Select itdDate = new Select(driver.findElement(By.id("itdTimeHour")));
        itdDate.selectByVisibleText("12");

        String selectedHour = itdDate.getFirstSelectedOption().getText();
        assertThat(selectedHour, is("12"));
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
