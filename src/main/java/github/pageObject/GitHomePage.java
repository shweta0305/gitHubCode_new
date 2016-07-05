package github.pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GitHomePage {
	WebDriver driver;

	public GitHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login_field")
	public WebElement Username;

	@FindBy(id = "password")
	public WebElement Password;

	@FindBy(css = ".btn.btn-primary.btn-block")
	public WebElement SignIn;
	
	@FindBy(css = ".repo-list-name")
	public List<WebElement> repoList ;
	
	String pageTitle="GitHub";

//	public void gitPageOpened()
//	{
//		driver.get("https://github.com/login");
//		
//	}
	public void login() {
		
//		System.out.println(Keys.chord(Keys.SHIFT,"2"));
		Username.sendKeys("shweta0305");
		Password.sendKeys("ABCabc1994");
		SignIn.click();
	}
	
	public void verifyUserOnLoginPage(){
		Assert.assertEquals(driver.getTitle(),pageTitle ,"Login Page Reached");
		
	}
	public void verifyRepoCreated(String repoName){
	for(WebElement web:repoList)
	{
		if(web.getText().equals(repoName.trim()))
				{
			Assert.assertTrue(true);
				}
		else {
			Assert.assertTrue(false);
		}
	}
		
		
		
	}
	
	
}
