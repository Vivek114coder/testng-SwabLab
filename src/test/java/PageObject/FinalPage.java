package PageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalPage {
	WebDriver driver;
	
  public FinalPage( WebDriver driver) {
	  this.driver=driver;
  }
  
  @FindBy(xpath="//*[@id=\"checkout_complete_container\"]/h2")
  WebElement ThankyouOrder;
  
  public void getText() {
	  assertEquals("Thank you for your order!", ThankyouOrder.getText());
  }
}
