package org.restassuredpractice.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\OVI\\IdeaProjects\\RestAssuredPractice\\src\\test\\resources\\features",
        glue = {"org.restassuredpractice.stepdefinition"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        tags = "@specificationBuilder"

)
public class TestRunner {
}
