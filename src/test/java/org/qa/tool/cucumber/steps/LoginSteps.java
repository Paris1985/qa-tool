
package org.qa.tool.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;

import org.qa.tool.cucumber.base.BaseTest;
import org.qa.tool.cucumber.pages.LoginPage;


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
    public void login() {
        loginPage.login("qacore","qacore@123");
    }

    @And("User user should be able to login")
    public void verifyLogin() {
        String confirmationText = loginPage.getLoginConfirmation1();
        if (confirmationText.equalsIgnoreCase("Logout")){
            markTestStatus("passed","Login Successfully");
        }
        else {
            markTestStatus("failed","Login Unsuccessfully");
        }
    }

    @After
    public void after(Scenario scenario) {
        super.after(scenario);
    }

}