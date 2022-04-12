
package org.qa.tool.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = {"org.qa.tool.cucumber.steps" },
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class CucumberTest extends AbstractTestNGCucumberTests {

}
