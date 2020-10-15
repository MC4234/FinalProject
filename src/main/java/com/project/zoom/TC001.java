package com.project.zoom;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonFunctions.PrePost;
public class TC001 extends PrePost{
	
	@Test
	public void GetTitle() throws InterruptedException {
		// set the driver path
	    //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// launch the browser
		//ChromeDriver driver = new ChromeDriver();
		// load the url
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://www.zoomcar.com/chennai/");
		//maximize the URL
		System.out.println(driver.getTitle());
		System.out.println("Inside TC001");

}
}
