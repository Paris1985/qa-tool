
package org.qa.tool.cucumber.Parallel;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.qa.tool.cucumber.base.util.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "classpath:features",
        glue = {"org.qa.tool.cucumber.Parallel"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class CucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
    @BeforeClass
    public static void init(){
        Driver.getInstance().getWebDriver();
    }

    @AfterClass
    public static void cleanup() {
        Driver.getInstance().exit();
    }
}
