package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.cucumber.java.en.*;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class LoginPageSteps {

    WebDriver driver;
    String pageTitle;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Setup ChromeDriver (make sure to set correct driver path)
        System.setProperty("webdriver.chrome.driver", "D://Webdriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();

        // Maximize window and open the login page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, pageTitle);
        driver.quit(); // close browser after assertion
    }
}
