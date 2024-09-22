package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OverviewPage {
	private static final String xpath = null;
	public WebDriver driver;
	public OverviewPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement TitlePage;

	@FindBy(xpath="//*[@id=\"finish\"]")
	WebElement button;

	public void pageText() {
		Assert.assertEquals("Checkout: Overview",TitlePage.getText());
	}
	
	
	public FinalPage click_on_checkoutbutton() {
	    button.click();
		return PageFactory.initElements(driver, FinalPage.class);
	}



}
