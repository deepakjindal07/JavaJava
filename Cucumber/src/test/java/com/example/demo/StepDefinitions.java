package com.example.demo;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private final WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String user, String pass) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("I click the login button")
    public void i_click_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see the products page")
    public void i_should_see_products_page() {
        assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
    }

    @Given("I am logged in with username {string} and password {string}")
    public void i_am_logged_in_with_username_and_password(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Here you'd add Selenium code to open browser, enter credentials, click login, etc.
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        driver.findElement(By.cssSelector("[data-test='product_sort_container']")).click(); // dummy example
    }

    @Then("the product results should include {string}")
    public void results_should_include(String product) {
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains(product));
    }
}
