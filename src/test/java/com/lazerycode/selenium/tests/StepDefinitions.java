package com.lazerycode.selenium.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.GoogleHomePage;
import com.lazerycode.selenium.page_objects.GoogleSearchPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StepDefinitions extends DriverBase {

	private RemoteWebDriver driver;
  private GoogleHomePage googleHomePage;
  private GoogleSearchPage googleSearchPage;
  private String searchTerm;

	@Before()
	public void before() throws Exception{
    instantiateDriverObject();
		driver = getDriver();
		googleHomePage = new GoogleHomePage();
	}	

	@Given("I navigate to {string}")
	public void i_navigate_to(String url) throws Exception {
		driver.get(url);
	}

	@Given("type {string} to the search field")
	public void type_to_the_search_field(String searchTerm) throws Exception {
		this.searchTerm = searchTerm;
		googleHomePage.enterSearchTerm(searchTerm);
	}

	@When("I click the I'm lucky button")
	public void i_click_the_i_m_lucky_button()  throws Exception{
		googleSearchPage = googleHomePage.submitSearch();
	}

	@Then("I can see {string} in the page title")
	public void i_can_see_in_the_page_title(String title)  throws Exception{
		googleSearchPage.waitForPageTitleToStartWith(searchTerm);

		assertThat(googleSearchPage.getPageTitle()).contains(title);
    clearCookies();
	}

  @After()
  public void after(){
    closeDriverObjects();
  }

}
