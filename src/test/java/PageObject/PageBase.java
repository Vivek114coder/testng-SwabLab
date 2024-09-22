package PageObject;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.properties.configReader;

public class PageBase {
	public  static WebDriver driver; // declare the driver static when you take screenshot
	public  Properties prop;
	public  String browser1;
	public  configReader config;
	public  LoginPage loginpage;
	
	public ExtentTest test;
	public ExtentReports extent = new ExtentReports();;
    public ExtentSparkReporter spark  = new ExtentSparkReporter( "target/extentReport.html");
    
    
    
    @BeforeTest()
	public void StartReporter() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
		
	}
    

	
	@BeforeMethod()
	public void init_driver() {
    	 
    	 
    	
		config= new configReader();
		prop=config.init_Element();
		browser1=prop.getProperty("browser");
		
			
		if(browser1.equals("chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver=new ChromeDriver(); 
			driver.get("https://www.saucedemo.com/");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		
}
	public void takeScreenshot() {
		Date currentdate= new Date();
	    String FilePath= currentdate.toString().replace(" ","-").replace(":", "-");
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile,new File("./Screenshot/"+FilePath+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		}
	}
	
	@AfterMethod()
	public void quitwindow(){
		driver.quit();
	}
	
	@AfterTest()
	public void quitextentReport(){
		extent.flush();
	}
	
}
