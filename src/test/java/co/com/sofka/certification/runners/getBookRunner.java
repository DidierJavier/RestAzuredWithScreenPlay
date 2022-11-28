package co.com.sofka.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/getBook.feature",
                 glue = "co.com.sofka.certification.stepDefinitions",
                 snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class getBookRunner {
}
