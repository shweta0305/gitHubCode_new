package github.pageObject;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class BaseClass {
	WebDriver driver=new FirefoxDriver();
	String pageTitle1="Sign in to GitHub · GitHub";
	GitHomePage gitHomePage=new GitHomePage(driver);
	String url;
	
	RepositoryCreation create=new RepositoryCreation(driver);
	Repository repo=new Repository(driver);
	ManageRepository manageRepo=new ManageRepository(driver);
	ShellScript shellscript=new ShellScript();
	ViaAPI api=new ViaAPI();
	public void repoCreation(){
	repo.createRepo();
	}
		
	public void lauchUrl(String url){
		driver.get(url);
		
	}
	public void verifyUserOnHome(){
		Assert.assertEquals(driver.getTitle(),pageTitle1 ,"Login page Reached");
		
	}

}
