package com.project.zoom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import commonFunctions.PrePost;

public class TC002 extends PrePost {

	@Test
	public void PerformAction() throws InterruptedException
	
	{
		
		        //click on search
				driver.findElementByClassName("search").click();
				System.out.println("Inside TC002");
				//send pick up point as Porur - location
		   
				WebElement searchElement = driver.findElementByXPath("//input[@type='text']");
			    searchElement.sendKeys("Porur, Chennai, Tamil Nadu, India");
				Actions builder = new Actions(driver);
				builder.moveToElement(searchElement).click().perform();
				Thread.sleep(3000);
				WebElement moverOver =driver.findElement(By.className("pac-matched"));
				builder.moveToElement(moverOver).click().perform();
				
						
				//click next
				
				driver.switchTo().defaultContent();
				int frameCount = driver.findElements(By.tagName("iframe")).size();
				System.out.println(frameCount);
				int nextButton= driver.findElements(By.xpath("//button[text()='Next']")).size();
				System.out.println(nextButton);
				System.out.println("Element found");
				WebElement ele = driver.findElementByXPath("//button[text()='Next']");
				builder.moveToElement(ele).click().perform();
				System.out.println("Next button is pressed");
				 
				
				//select day
				
				//Work out today and tomorrow
			    LocalDate today = LocalDate.now();
			    LocalDate tomorrow = today.plusDays(1L);
			    System.out.println(today);
			    System.out.println(tomorrow);
			    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		        System.out.println("Today's date: " + todayInt +"\n");
		        int select = todayInt+1;
		        System.out.println("Tomorrow's date: "+select);
		        driver.findElementByClassName("show-more").click();
		        List<WebElement> day=driver.findElements(By.className("active"));
		        int counter = day.size();
		        System.out.println("Size of startday list: "+counter);
		        for(int startday=0;startday<counter-1;startday++)
		        { 
			
		        	String firstDay= day.get(startday).getText();
		        	day.get(startday+1).click();
		        	System.out.println("Start date is selected");
		        	break;

		        }
		        driver.switchTo().defaultContent();
		        builder.moveToElement(ele).click().perform();
		        System.out.println("Next is pressed");
		        driver.findElementByClassName("show-more").click();
		        List<WebElement> end=driver.findElements(By.className("active"));
		        int si = end.size();
		        System.out.println("Size of endday list: "+counter);
		        for(int endDay=0;endDay<si-1;endDay++)
		        { 
		        	String lastDay= end.get(endDay).getText();
		        	end.get(si-1).click();
		        	System.out.println("End date is selected");
		        	break;

		        }
				WebElement element = driver.findElementByXPath("//button[text()='Done']");
			    builder.moveToElement(element).click().perform();
				System.out.println("Done button is pressed");
			    
				//count no of cars

				int carCount = driver.findElements(By.className("car-listing")).size();
				System.out.println("Total No: car displayed: "+carCount);
				
				//find max price
				

				String product_name ;
				String product_price;
				int int_product_price;
				
				//System.out.println("Inside");
				List<WebElement> value =  driver.findElements(By.tagName("h3"));
				List<WebElement> priceList = driver.findElements(By.className("new-price"));
				//System.out.println(value.size());
				
				//driver.manage().timeouts();
				int count = value.size();
				//System.out.println(count);
				HashMap<Integer, String> mapObject = new HashMap<Integer,String>();
				for(int i=0;i<count-1;i++)
				{
					
					product_name = value.get(i).getText();
					product_price=priceList.get(i).getText();
					product_price = product_price.replaceAll("[^0-9]", "");
					int_product_price = Integer.parseInt(product_price);
					System.out.println(product_name +" : "+int_product_price);
					mapObject.put(int_product_price,product_name);
				}
				
				Set<Integer> allkeys = mapObject.keySet();
				ArrayList<Integer> ArrayObject = new ArrayList<Integer>(allkeys);
				Collections.sort(ArrayObject);
				
				
				//Highest Product is
				int high_price = ArrayObject.get(ArrayObject.size()-1);
				System.out.println("Highest Price is:"+high_price);
						
				//Low price is
				int low_price = ArrayObject.get(0);
				System.out.println("Lowest Price is:"+low_price);
				driver.close(); //close browser
					
			}
	    
	}
	
	

