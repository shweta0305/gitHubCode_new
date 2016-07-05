package github.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageRepository
{	public WebDriver driver;
	public String url=null;
	
public ManageRepository(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(css=".form-control.js-git-clone-help-field.url-field.js-zeroclipboard-target")
WebElement URLForCloning;

public String cloning(String repoName)
{
	//url=URLForCloning.getAttribute("value");
//	ShellScript shell=new ShellScript();
//	shell.scripting(url, repoName);
	driver.close();
	return url="https://github.com/shweta0305/"+repoName+".git";
}
public void checkForClone() {
	
}
}
