
package org.qa.tool.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.qa.tool.cucumber.base.util.Driver;

@CucumberOptions(
        features = "classpath:features",
        glue = {"org.qa.tool.cucumber.base.steps"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}

)
public class CucumberTest extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void cleanup() {
        Driver.getInstance().exit();
    }
}
