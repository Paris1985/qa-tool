package org.qa.tool.cucumber.base.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.qa.tool.cucumber.base.BaseTest;

public class PreSteps extends BaseTest {


    @Before("@UI")
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @After("@UI")
    public void after(Scenario scenario) {
        super.after(scenario);
    }
}
