package github.pageObject;

import org.testng.annotations.Test;

import com.sun.jna.platform.win32.OaIdl.DATE;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class NewTest {

	BaseClass base;
	String repoName, descriptionForRepo = "nice Repository dude", url;
	static Logger log = Logger.getLogger(NewTest.class.getName());

	@Test
	public void launchGithubPage() {
		base.lauchUrl("https://github.com/login");
		base.verifyUserOnHome();

	}

	@Test(dependsOnMethods = { "launchGithubPage" })
	public void loginToGithub() {
		base.gitHomePage.login();
		base.gitHomePage.verifyUserOnLoginPage();
	}

	@Test(dependsOnMethods = { "loginToGithub" })
	public void RepoCreation() {
		base.repo.createRepo();
		base.repo.verifyUserOnRepositoryCreationPage();
	}
	
	@Test(dependsOnMethods = { "RepoCreation" })
	public void CheckIfRepoCreated() {
		base.gitHomePage.verifyRepoCreated(repoName);
		
	}
	
	@Test(dependsOnMethods = { "CheckIfRepoCreated" })
	public void RepositoryFormFill() {

		repoName = base.create.RepoFormFill(repoName, descriptionForRepo);
		base.create.verifyRepositoryCreated();
		url = base.manageRepo.cloning(repoName);
	}

	@Test(dependsOnMethods = { "RepositoryFormFill" })
	public void checkIfCloned() {
		File file = new File("/path/to/directory");
		String[] fileNames = file.list();
		for(int i=0; i<fileNames.length; i++){
			if(fileNames[i].contains(repoName)){
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnMethods = { "checkIfCloned" })
	public void shellScripting() {
		base.shellscript.scripting(url, repoName);
		base.shellscript.conflictChecking();
	}
	
	@Test(dependsOnMethods = { "shellScripting" })
	public void verifyPush() {
		base.shellscript.verifyPushPerformed();
	}
	@Test
	public void ApiUse(){
		base.api.createRepoUsingApi();
	}
	
	@BeforeClass
	public void beforeClass() {
		base = new BaseClass();
	}

	@Test
	public void logs() {
		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
	}
}
