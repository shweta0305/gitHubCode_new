package github.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Repository extends GeneralFunctions{
	public WebDriver driver;
	String pageTitle="Create a New Repository";

	public Repository(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='btn btn-sm btn-primary']")
	public WebElement repositoryCreate;

	public void createRepo() {
		performClick(repositoryCreate);

	}
	public void verifyUserOnRepositoryCreationPage(){
		Assert.assertEquals(driver.getTitle(),pageTitle ,"Login page Reached");
	}
	
}
