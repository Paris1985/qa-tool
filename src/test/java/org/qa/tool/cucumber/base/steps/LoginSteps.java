package org.qa.tool.cucumber.base.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.qa.tool.cucumber.base.BaseTest;
import org.qa.tool.cucumber.base.pages.LoginPage;
import static org.assertj.core.api.BDDAssertions.then;

public class LoginSteps extends BaseTest {

    private LoginPage loginPage;

    @Given("User is in the login page")
    public void goToLogin() {
        loginPage = new LoginPage();
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