package github.pageObject;

import org.openqa.selenium.WebElement;

public class GeneralFunctions {
	public void EnterTextInTextbox(String text, WebElement textBox) {
textBox.sendKeys(text);
	}

	public void performClick(WebElement clickableObject) {
		clickableObject.click();
	}
	
}
