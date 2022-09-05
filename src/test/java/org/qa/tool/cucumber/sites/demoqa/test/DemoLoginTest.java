package org.qa.tool.cucumber.sites.demoqa.test;

import org.junit.Before;
import org.junit.Test;
import org.qa.tool.cucumber.base.BaseTest;
import org.qa.tool.cucumber.sites.demoqa.page.DemoLoginPage;

import static org.assertj.core.api.BDDAssertions.then;

public class DemoLoginTest extends BaseTest {

    private DemoLoginPage demoLoginPage;

    @Before
    public void init() {
        demoLoginPage = new DemoLoginPage();
    }

    @Test
    public void canLogin() {
        demoLoginPage.login("qacore","qacore@123");
        String confirmationText = demoLoginPage.getLoginConfirmation();
        then(confirmationText).isEqualTo("Logout");
    }
}
