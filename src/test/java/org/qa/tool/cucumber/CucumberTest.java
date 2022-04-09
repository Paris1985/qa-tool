
package org.qa.tool.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = {"org.qa.tool.cucumber.steps" },
        plugin = {"pretty", "html:target/Destination"})
public class CucumberTest extends AbstractTestNGCucumberTests {

}
