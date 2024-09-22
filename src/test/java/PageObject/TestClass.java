package PageObject;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.properties.configReader;

public class TestClass extends PageBase{

	
	
	@Test(priority=0,dataProvider = "data-provider")
    public void login_with_valid_credentials(String username, String password){
	    test=extent.createTest("Login with valid crendentials");
		loginpage=new LoginPage(driver);
		test.info("enter username");
		loginpage.setUsername(username);
		test.log(Status.PASS, "user enter username successfully");
		loginpage.setPassword(password);
		test.log(Status.PASS, "user enter password successfully");
		loginpage.click_on_button();
		test.log(Status.PASS, "  button clicked successfully");
    	
    }
    
    @Test(priority=1,dataProvider="data-provider1")
    public void login_with_invalid_crendentials(String username, String password) {
    	ExtentTest test=extent.createTest("Login with  invalid increndentials");
    	loginpage=new LoginPage(driver);
    	test.info("enter username");
    	test.log(Status.PASS, "user enter username successfully");
    	loginpage.setUsername(username);
    	test.log(Status.PASS, "user enter password successfully");
    	loginpage.setPassword(password);
    	test.log(Status.PASS, "buttton is not clickable");
    }
    
    
    @Test(priority=2)
    public void check_BucketPage() {
    	loginpage=new LoginPage(driver);
    	ExtentTest test=extent.createTest("check Bucket Page Functionality");
    	loginpage.setUsername("standard_user");
    	test.log(Status.PASS, "user enter username successfully");
        Assert.assertTrue(false);
    	loginpage.setPassword("secret_sauce");
    	test.log(Status.FAIL, "user enter password successfully");
    	AccountPage accountpage=loginpage.clickbutton();
    	System.out.println(accountpage.getTitle());
    	Assert.assertEquals("Swag Labs", accountpage.getTitle());
    	test.log(Status.PASS, "get  title successfully");
    	Assert.assertEquals("Add to cart",accountpage.button_before_click());
    	test.log(Status.PASS, "Add to cart button is  displayed");
    	Assert.assertEquals("Remove",accountpage.button_after_click());
    	test.log(Status.PASS, "Remove button is  displayed");
    }
    
    @Test(priority=3)
    public void  bucket_selectedItem() throws InterruptedException {
    	loginpage=new LoginPage(driver);
    	ExtentTest test=extent.createTest("Bucket Selected Item");
    	loginpage.setUsername("standard_user");
    	test.log(Status.PASS, "user enter username successfully");
    	loginpage.setPassword("secret_sauce");
    	test.log(Status.PASS, "user enter password successfully");
    	AccountPage accountpage=loginpage.clickbutton();
    	test.log(Status.PASS, "login button is clickable");
    	accountpage.button_after_click();
    	test.log(Status.PASS, "Remove button is  displayed");
        BucketPage bucketpage=accountpage.clickonbucket();
        test.log(Status.PASS, "bucket button is click  successfully");
        bucketpage.selected_item_is_Clickable();
        test.log(Status.PASS,"selected item is clickable");
    }
    
    
    
    @Test(priority=4)
    public void  bucket_checkoutbutton() {
    	loginpage=new LoginPage(driver);
    	ExtentTest test=extent.createTest("Bucket check  out  button");
    	loginpage.setUsername("standard_user");
    	test.log(Status.PASS, "user enter username successfully");
    	loginpage.setPassword("secret_sauce");
    	test.log(Status.PASS, "user enter password successfully");
    	AccountPage accountpage=loginpage.clickbutton();
    	test.log(Status.PASS, "Login button click successfully");
    	accountpage.button_after_click();
    	test.log(Status.PASS, "button is clickable");
        BucketPage bucketpage=accountpage.clickonbucket();
        test.log(Status.PASS, "button button is clickable");
        bucketpage.click_on_checkoutbutton();
        test.log(Status.PASS, "checkout button is clickable");
    }
    
    
    @Test(priority=5)
    public void  imformationPage() {
    	loginpage=new LoginPage(driver);
    	ExtentTest test=extent.createTest("Imformation Page");
    	loginpage.setUsername("standard_user");
    	test.log(Status.PASS, "user enter username successfully");
    	loginpage.setPassword("secret_sauce");
    	test.log(Status.PASS, "user enter password successfully");
    	AccountPage accountpage=loginpage.clickbutton();
    	test.log(Status.PASS, "Login button click successfully");
    	accountpage.button_after_click();
    	test.log(Status.PASS, "button is clickable");
        BucketPage bucketpage=accountpage.clickonbucket();
        test.log(Status.PASS, "button button is clickable");
        ImformationPage ip=bucketpage.click_on_checkoutbutton();
        test.log(Status.PASS, "checkout button is clickable");
        ip.fill_imformtion();
        test.log(Status.PASS, "fill the imformation");
        ip.click_on_button();
        test.log(Status.PASS, "button clicks successfully");
        
    }
    
    @Test(priority=6)
    public void  overviewPage() {
    	loginpage=new LoginPage(driver);
    	ExtentTest test=extent.createTest("Imformation Page");
    	loginpage.setUsername("standard_user");
    	test.log(Status.PASS, "user enter username successfully");
    	loginpage.setPassword("secret_sauce");
    	test.log(Status.PASS, "user enter password successfully");
    	AccountPage accountpage=loginpage.clickbutton();
    	test.log(Status.PASS, "Login button click successfully");
    	accountpage.button_after_click();
    	test.log(Status.PASS, "button is clickable");
        BucketPage bucketpage=accountpage.clickonbucket();
        test.log(Status.PASS, "button button is clickable");
        ImformationPage ip=bucketpage.click_on_checkoutbutton();
        test.log(Status.PASS, "checkout button is clickable");
        ip.fill_imformtion();
        test.log(Status.PASS, "fill the imformation");
        OverviewPage overview=ip.click_on_button();
        test.log(Status.PASS, "button clicks successfully");
        overview.pageText();
        test.log(Status.PASS, "text sucessfully displayed");
        overview.click_on_checkoutbutton();
        test.log(Status.PASS, "button clicks successfully");
        
    }
    
    @Test(priority=6)
    public void  FinalPage1() {
    	loginpage=new LoginPage(driver);
    	ExtentTest test=extent.createTest("Imformation Page");
    	loginpage.setUsername("standard_user");
    	test.log(Status.PASS, "user enter username successfully");
    	loginpage.setPassword("secret_sauce");
    	test.log(Status.PASS, "user enter password successfully");
    	AccountPage accountpage=loginpage.clickbutton();
    	test.log(Status.PASS, "Login button click successfully");
    	accountpage.button_after_click();
    	test.log(Status.PASS, "button is clickable");
        BucketPage bucketpage=accountpage.clickonbucket();
        test.log(Status.PASS, "button button is clickable");
        ImformationPage ip=bucketpage.click_on_checkoutbutton();
        test.log(Status.PASS, "checkout button is clickable");
        ip.fill_imformtion();
        test.log(Status.PASS, "fill the imformation");
        OverviewPage overview=ip.click_on_button();
        test.log(Status.PASS, "button clicks successfully");
        FinalPage finalpage=overview.click_on_checkoutbutton();
        test.log(Status.PASS, "button clicks successfully");
        finalpage.getText();
        test.log(Status.PASS, "text sucessfully display");
        
    }
    
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
    	
		return new Object[][] {{"standard_user","secret_sauce"},{"problem_user","secret_sauce"}};
	
    }
    
    
    @DataProvider (name = "data-provider1")
    public Object[][] dpMethod1(){
    	
		return new Object[][] {{"standard_user","123"},{"123","scrret_sauce"}};
	
    }
	
	
     
}
