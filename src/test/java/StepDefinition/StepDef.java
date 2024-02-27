package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {

	public WebDriver driver;
	
	public LoginPage loginpg;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
	 loginpg= new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
	    loginpg.enterEmail(emailadd);
	    loginpg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
	    loginpg.clickOnLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	   String actualTitle=driver.getTitle();
	  
	   if(actualTitle.equals(expectedTitle))
	   {
		   Assert.assertTrue(true);//pass
		
	   }
	   else
	   {
		   Assert.assertTrue(false);//fail
		   
	   }
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	    loginpg.clickOnLogOutButton();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	    driver.quit();
	}
	
}
