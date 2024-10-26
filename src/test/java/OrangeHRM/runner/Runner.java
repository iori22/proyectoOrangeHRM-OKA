package OrangeHRM.runner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/Orange/OrangeHRM.feature"
		,glue= {"OrangeHRM.steps"}
//		,tags = {"@Login-CamposVacios"}
		,plugin ={"json:target/cucumber-reports/Cucumber.json"} 
		,monochrome = true 
		)
public class Runner {	

}

