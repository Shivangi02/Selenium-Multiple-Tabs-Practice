import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeperateTabPractice {
	public static void main(String[] s) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footerFirstColumn = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		int size = footerFirstColumn.findElements(By.tagName("a")).size();
		System.out.println(size);

		// Stale Element reference example
//	    for(WebElement link:links)
//	    {
//	    	link.click();
//	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	    	System.out.println(link.getText()+"Title:"+driver.getTitle());
//	    	driver.navigate().back();
//	    	
//	    }	
//	    	

//	    //Using for loop and opening tab in the same page
//	    for(int i=0;i<size;i++)
//	    {
//			 footerFirstColumn=driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
//			  links=footerFirstColumn.findElements(By.tagName("a"));
//			  String linkText=links.get(i).getText();
//                links.get(i).click();
//                System.out.println(linkText+"Title: "+driver.getTitle());
//                driver.navigate().back();
//	    }
		// Opening new tab and grabiing title
//	    Actions action=new Actions(driver);
//	    //Opening in new tab
//	    for(int i=1;i<size;i++) 
//	    {	  footerFirstColumn=driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
//	    	List<WebElement> links=footerFirstColumn.findElements(By.tagName("a"));
//
//	        action.moveToElement(links.get(i)).keyDown(Keys.CONTROL).click().build().perform();
//	        Set<String> windows=driver.getWindowHandles();
//	  //      Iterator<String> it=windows.iterator();
//	        String parentWindow=driver.getWindowHandle();
//	        String linkText=links.get(i).getText();
//	        for(String windowHandle: windows)
//	        {
//	        	if(!windowHandle.equals(parentWindow))
//	        	{
//	        		driver.switchTo().window(windowHandle);
//	        	}
//	        }
//	        	System.out.println(linkText+"Title"+driver.getTitle());
//	        	driver.switchTo().window(parentWindow);
//	        
//	    }
		// Open new tab first and then grab title
		List<WebElement> links = footerFirstColumn.findElements(By.tagName("a"));
		for (int i = 1; i < size; i++) {
			String key = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(key);
		}
//	    	String parentWindow=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
//	    for(String window:windows)
//	    {
//	    	if(!window.equals(parentWindow))
//	    	{
//	    		driver.switchTo().window(window);
//	    		System.out.println(driver.getTitle());
//	    		
//	    	}
//	    	
//	    }
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
