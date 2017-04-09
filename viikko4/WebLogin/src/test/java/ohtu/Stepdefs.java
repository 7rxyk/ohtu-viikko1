package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^noexistent username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void noexistent_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_ok_and_password_ok_are_given(String username, String password) throws Throwable {
        createUserWith(username, password);
    }

    @When("^too short username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_short_and_password_ok_are_given(String username, String password) throws Throwable {
        assertTrue(username.length() < 3);
        createUserWith(username, password);
    }

    @When("^username \"([^\"]*)\" and too short password \"([^\"]*)\" are given$")
    public void username_ok_and_password_short_are_given(String username, String password) throws Throwable {
        assertTrue(password.length() < 8);
        createUserWith(username, password);
    }

    @When("^username \"([^\"]*)\" and password consisting of only letters \"([^\"]*)\" are given$")
    public void username_ok_and_password_only_letters_are_given(String username, String password) throws Throwable {
        createUserWith(username, password);
    }

    @When("^taken username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_taken_and_password_ok_are_given(String username, String password) throws Throwable {
        createUserWith(username, password);
    }

    @When("^username \"([^\"]*)\" and ok password \"([^\"]*)\" and confirmation \"([^\"]*)\" are given$")
    public void username_ok_and_password_ok_and_confirmation_are_given(String username, String password, String confirmation) throws Throwable {
        createUserWith(username, password, confirmation);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("^user is created and 'welcome'-screen is shown$")
    public void user_created_welcome_screen_shown() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_not_created_error_reported(String error) throws Throwable {
        pageHasContent(error);
        pageHasContent("Create username and give password");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void createUserWith(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void createUserWith(String username, String password) {
        createUserWith(username, password, password);
    }
}
