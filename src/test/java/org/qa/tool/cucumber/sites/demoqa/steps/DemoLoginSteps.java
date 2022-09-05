package org.qa.tool.cucumber.sites.demoqa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.qa.tool.cucumber.base.BaseTest;
import org.qa.tool.cucumber.sites.demoqa.page.DemoLoginPage;
import static org.assertj.core.api.BDDAssertions.then;

public class DemoLoginSteps extends BaseTest {

    private DemoLoginPage loginPage;

    @Given("User is in the login page")
    public void goToLogin() {
        loginPage = new DemoLoginPage();
    }

    @When("User logins with valid credential")
    public void login() {
        loginPage.login("qacore","qacore@123");
    }

    @And("User user should be able to login")
    public void verifyLogin() {
        String confirmationText = loginPage.getLoginConfirmation();
        then(confirmationText).isEqualTo("Logout");
    }

    @And("^should be able to logout$")
    public void verifyLogout() {
        loginPage.logout();
    }



}