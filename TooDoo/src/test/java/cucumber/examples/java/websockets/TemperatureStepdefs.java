package cucumber.examples.java.websockets;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class TemperatureStepdefs {
    private final WebDriver webDriver;

    public TemperatureStepdefs(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    @When("^I enter \"([^\"]*)\" tbxcategory$")
    public void i_enter_tbxcategory(String value) {
       // webDriver.findElement(By.id(unit)).sendKeys(String.valueOf(value));
        webDriver.findElement(By.id("tbxcategory")).sendKeys(String.valueOf(value));
       
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void i_should_see(String value) {
        assertEquals(value, webDriver.findElement(By.id("tbxcategory")).getAttribute("value"));
    }
    
    @When("^I enter \"([^\"]*)\" tbxsubject$")
    public void i_enter_tbxsubject(String value) {
       // webDriver.findElement(By.id(unit)).sendKeys(String.valueOf(value));
        webDriver.findElement(By.id("tbxsubject")).sendKeys(String.valueOf(value));
       
    }

    @Then("^I should see \"([^\"]*)\" in toodoolist$")
    public void i_should_see_toodoo(String value) {
        assertEquals(value, webDriver.findElement(By.id("tbxsubject")).getAttribute("value"));
    }
    }

