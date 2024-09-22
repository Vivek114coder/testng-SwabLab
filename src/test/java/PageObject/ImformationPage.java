package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImformationPage {

public WebDriver driver;	
	


public ImformationPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}  

@FindBy(xpath="//*[@id=\"first-name\"]")
WebElement firstname;


@FindBy(xpath="//*[@id=\"postal-code\"]")
WebElement zip;


@FindBy(xpath="//*[@id=\"last-name\"]")
WebElement Secondname;


@FindBy(xpath="//*[@id=\"continue\"]")
WebElement button;

public void fill_imformtion() {
	firstname.sendKeys("vivek");
	Secondname.sendKeys("kushwwaha");
    zip.sendKeys("222");
}


public OverviewPage click_on_button() {
	button.click();
	return PageFactory.initElements(driver, OverviewPage.class);
	
}
}