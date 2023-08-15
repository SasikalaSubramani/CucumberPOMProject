package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.RegisterPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPageSteps {
	
	private RegisterPage registerUsPage = new RegisterPage(DriverFactory.getDriver());

	@Given("user navigates to register page")
	public void user_navigates_to_register_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println(registerUsPage.getRegisterPageTitle());
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\91978\\eclipse-workspace\\CucumberPomProject\\src\\test\\resources\\testdata\\automation.xlsx", sheetName);
		
		String firstName = testData.get(rowNumber).get("firstname");
		String lastName = testData.get(rowNumber).get("lastname");
		String telePhone = testData.get(rowNumber).get("telephone");
		String passWord = testData.get(rowNumber).get("password");
		
		registerUsPage.fillRegisterForm(firstName, lastName, telePhone, passWord);

	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		registerUsPage.clickContinue();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) {
		String actualSuccMessg = registerUsPage.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}

}