
package org.qa.tool.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.qa.tool.cucumber.base.BaseTest;
import org.qa.tool.cucumber.pages.LoginPage;


import java.net.MalformedURLException;

import static org.assertj.core.api.BDDAssertions.then;

public class LoginSteps extends BaseTest {

    private LoginPage loginPage;

    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @Given("User is in the login page")
    public void goToLogin() {
        loginPage = new LoginPage();
    }

    @When("User logins with valid credential")
    public void validLogin() {
        loginPage.login("qacore","qacore@123");
    }
//    @When("User logins with invalid credential")
//    public void invalidLogin() {
//        loginPage.login("qacore","qacore@1234");
//    }
//    @When("User logins with valid {string} and {string}")
//    public void login(String username, String password){
//        loginPage.login(username,password);
//    }

    @Then("User should be able to login")
    public void verifyLogin() {
        String confirmationText = loginPage.getLoginConfirmation1();
        then(confirmationText).containsIgnoringCase("Logout");
        }


//    @Then("User should not be able to login")
//    public void verifyInvalidLogin() {
//        String confirmationText = loginPage.getInvalidLoginConfirmation();
//        then(confirmationText).containsIgnoringCase("error");
//    }

    @After
    public void after(Scenario scenario){
        super.after(scenario);
    }

}