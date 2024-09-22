package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class BucketPage {
private static final String xpath = null;
public WebDriver driver;
public BucketPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}

@FindBy(xpath="//*[@id=\"checkout\"]")
WebElement checkoutbutton;

@FindBy(xpath="//*[@id=\"item_4_title_link\"]/div")
WebElement selectedItem;

public ImformationPage click_on_checkoutbutton() {
	checkoutbutton.click();
	return PageFactory.initElements(driver, ImformationPage.class);
}



public void selected_item_is_Clickable() throws InterruptedException {
	Thread.sleep(4000);
	selectedItem.click();
	
}




}