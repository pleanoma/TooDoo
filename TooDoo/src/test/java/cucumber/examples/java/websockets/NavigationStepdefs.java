package cucumber.examples.java.websockets;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class NavigationStepdefs {
    private final WebDriver webDriver;

    public NavigationStepdefs(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Given("^I am on the front page$")
    public void i_am_on_the_front_page() {
        //webDriver.get("http://localhost:" + ServerHooks.PORT);
    	webDriver.get("http://localhost:8080/TooDoo/Home.jsp");
    }
}
