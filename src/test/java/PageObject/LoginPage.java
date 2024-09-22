package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage {
public WebDriver driver;


	
	public  LoginPage  (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@id=\"user-name\"]")
	WebElement txtemail;

	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement textpassword;

	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement button;
    
    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement text;

    
    
	public void setUsername(String username) {
		txtemail.clear();
		txtemail.sendKeys(username);
		
	}
	public void setPassword(String password) {
		textpassword.clear();
		textpassword.sendKeys(password);
   
    }
	
	
	
    public void click_on_button() {
    	button.click();
        
    }
    
	public String getText1() {
		 return text.getText();
	}
	
	public Boolean  remain_on_same_page() {
		 if(button.isDisplayed()) {
			 return true;
		 }
		 return false;
	}
	
	public void doLogin(String un, String pwd) {
		txtemail.sendKeys(un);
		textpassword.sendKeys(pwd);
		
	}
	
	public AccountPage clickbutton() {
	button.click();
	try {
	Thread.sleep(1000);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return PageFactory.initElements(driver, AccountPage.class);
	}
	
	
	
}