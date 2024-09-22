package PageObject;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountPage {
	
	public WebDriver driver;
	
	String buttonAfterclick;
	
	public AccountPage(WebDriver driver){
		this.driver=driver;
	    PageFactory.initElements(driver, this);	
	}
	
	


	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement button1;

	@FindBy(xpath="//*[@id=\"remove-sauce-labs-backpack\"]")
	WebElement button2;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement bucket;
    
	
	public String  getTitle() {
		return driver.getTitle();
	}
    
	public String button_before_click() {
		return button1.getText();
	}
	public String  button_after_click() {
    
	   button1.click();
	   return button2.getText();
	}

	
	public BucketPage clickonbucket() {
		  bucket.click();
          return PageFactory.initElements(driver, BucketPage.class);
          
	}

	

}
