package github.pageObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RepositoryCreation extends GeneralFunctions
{
	public WebDriver driver;
String pageTitle;
	public RepositoryCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "repository_name")
	public WebElement repositoryName;
	
	@FindBy(id="repository_description")
	public WebElement description;
	
	@FindBy(id="repository_public_true")
	public WebElement radiobutton;
	
	@FindBy(css=".btn.btn-primary.first-in-line")
	public WebElement createRepo;

	public String RepoFormFill(String repoName, String descriptionForRepo) {
//		Scanner giveInput=new Scanner(System.in);//input the repository name
//		
//		System.out.println("Enter the name of the repository to be created...");
		
		repoName=System.currentTimeMillis()+"NewRepo";
//		System.out.println("Enter the decription for this repository...");
//		descriptionForRepo=giveInput.nextLine();
		EnterTextInTextbox(repoName, repositoryName);
		
		EnterTextInTextbox(descriptionForRepo, description);
		radiobutton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CheckExistingRepo();
		performClick(createRepo);
		pageTitle="shweta0305/"+repoName;
		return repoName;
	}
	public void verifyRepositoryCreated(){
		Assert.assertEquals(driver.getTitle(),pageTitle ,"Repository Created successfully");
		
	}
	public void CheckExistingRepo()
	{
		String expectedClass="form-control js-repo-name short with-permission-fields is-autocheck-errored";
		String classObtained=repositoryName.getAttribute("class");
		Assert.assertFalse(expectedClass.equals(classObtained));
		
	}
	
}
