
package org.qa.tool.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.qa.tool.cucumber.base.util.Driver;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "classpath:features",
        glue = "org.qa.tool.cucumber.steps",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
        tags = ("@SmokeTest1")
)
public class CucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @AfterClass
    public static void cleanup() {
        Driver.getInstance().exit();
    }
}
