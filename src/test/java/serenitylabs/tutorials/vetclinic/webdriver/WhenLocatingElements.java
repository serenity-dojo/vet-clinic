package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class WhenLocatingElements {
    WebDriver driver;
    @Before
    public void setup() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("file:///Users/Alena/Documents/_SERENITY_DOJO/Documents/elements.html");

    }
    @Test
    //Exercise 1 - Locate an element by id
    public void locateAnElementByID() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        assertThat(firstName.getAttribute("placeholder")).isEqualTo("Enter the first name here");
    }
    @Test
    //Exercise 2 - Locate an element by name
    public void locateAnElementByName() {
        WebElement lastName = driver.findElement(By.name("last-name"));
        assertThat(lastName.getAttribute("placeholder")).isEqualTo("Enter the last name here");
    }

    //Exercise 3 - Write a test that locates the blockquote section at the top of the page.
    //The <blockquote> tag specifies a section that is quoted from another source.
    @Test
    public void finding_an_element_by_tag() {
        WebElement blockquote = driver.findElement(By.tagName("blockquote"));
        assertThat(blockquote.getText()).contains("locating and manipulating elements on a page");

    }
    @Test
    //Exercise 4 - Locate an element by link text
    //Write a test that locates the blockquote section at the top of the page.
    public void locateAnElementByLinkText() {
        WebElement nextSection = driver.findElement(By.linkText("Next Section"));
        assertThat(nextSection.getText()).isEqualTo("Next Section");
    }

    @Test
    //Exercise 5 - Locate an element by css
    //Write a test that locates the Country of Origin dropdown using a CSS selector
    public void locateAnElementByCss() {
        WebElement countryDropdown = driver.findElement(By.cssSelector(".country-of-origin select"));
        List<WebElement> dropDownOptions = new Select(countryDropdown).getOptions();
        assertThat(dropDownOptions).hasSize(6);
    }

    //Exercise 6 - Enter values into a text field
    //Write a test that enters "Sarah-Jane" and "Smith" into the first and last names respectively.
    @Test
    public void enterValuesIntoATextField() {
        WebElement firstNameInputField = driver.findElement(By.id("first-name"));
        firstNameInputField.sendKeys("Sarah-Jane");
        assertThat(firstNameInputField.getAttribute("value")).isEqualTo("Sarah-Jane");

        WebElement secondNameInputField = driver.findElement(By.name("last-name"));
        secondNameInputField.sendKeys("Smith");
        assertThat(secondNameInputField.getAttribute("value")).isEqualTo("Smith");

    }

    //Exercise 7 - Checkboxes
    //Write a test that checks the 'VIP' checkbox.
    @Test
    public void shouldCheckTheVIPCheckbox(){
        WebElement checkbox = driver.findElement(By.id("vip"));
        assertThat(checkbox.isSelected()).isFalse();

        checkbox.click();
        assertThat(checkbox.isSelected()).isTrue();

    }
    //Exercise 8 - Radio buttons
    //Write a test that selects the 'Courrier Pigeon' option in the notifications radio buttons.
    @Test
    public void selectPigeonOption() {
        //WebElement pigeon = driver.findElement(By.name("notifications-by"));
        WebElement pigeon = driver.findElement(By.cssSelector("input[value='Courrier Pigeon']"));
        pigeon.click();
        assertThat(driver.findElement(By.id("notifications-preference")).getText()).isEqualTo("Pigeon");

    }




    @After
    public void shutDown() {
        driver.quit();
    }

}
