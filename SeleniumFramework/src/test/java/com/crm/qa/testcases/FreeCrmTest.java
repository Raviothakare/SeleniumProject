package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.processing.FilerException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class FreeCrmTest {
	
	static WebDriver driver;
	static JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
	}

	@Test
	public void freeCrmTitleTest() throws InterruptedException, IOException {
		
	try
		{
		     //statements that may cause an exception
		
		
		
		
		String title = driver.getTitle();
		System.out.println("title is: " + title);
		getRunTimeInfoMessage("info", title);

		if (title.equals("Free CRM software in the cloud powers sales and customer serviceQQQQ")) {
			getRunTimeInfoMessage("info", "title is correct!! YAY!!!");
			Assert.assertTrue(true);
		} else {
			getRunTimeInfoMessage("error", "title is not correct!! BUG BUG BUG!!!");
			takeScreenshot("freecrmloginpage");
			Assert.assertTrue(false);
	
		}
		
 }catch (Exception e) {
		System.out.println(e);
		takeScreenshot("exceptionscreen");
		//FreeCrmTest screenshot = new FreeCrmTest();
		//screenshot.takeScreenshot("catchfile");	
	}
	
		
		
		}
	public static void getRunTimeInfoMessage(String messageType, String message) throws InterruptedException, IOException {
		
		try {
			
		
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// js.executeScript("$.getScript('/Users/NaveenKhunteta/Documents/workspace/Test/src/testcases/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
		
		if(messageType.equals("error")){
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: '"+message+"' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: '"+message+"' });");
			
		}
		}
		catch (Exception e) {
			System.out.println(e);
			takeScreenshot("getRunTimeInfoMessage");
			//FreeCrmTest screenshot = new FreeCrmTest();
			//screenshot.takeScreenshot("catchfile");	
		}
		

		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'Some exception is coming' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
	}
	
	@AfterMethod
		
	public static void takeScreenshot(String filename) throws IOException{
		// Take screenshot and store as a file format
		//String fielname;
		//takeScreenshot("Success after metthod");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Open the current date and time
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			//Copy the screenshot on the desire location with different name using current date and time
			FileUtils.copyFile(scrFile, new File("D:/Automation/GITautomation/PageObjectModel-master/screenshots/"+ filename +" timestamp  .png" ));			

	}

	
	
}
