import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class automationTask {

	public static void main(String[] args) throws InterruptedException 
	{
        
       ChromeDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       //accessing amazon.india
       driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_6o3s351fev_e&adgrpid=150668181581&hvpone=&hvptwo=&hvadid=713930224953&hvpos=&hvnetw=g&hvrand=9909904424938598776&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007768&hvtargid=kwd-300061672064&hydadcr=5621_2441766&gad_source=1");
       WebElement element= driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
       //searching wrist watches in search bar
       element.sendKeys("Wrist Watches",Keys.ENTER);
       Thread.sleep(3000);
       //filtering results by selecting leather
       WebElement ele1=driver.findElement(By.xpath("//span[text()='Leather']"));
       Actions act=new Actions(driver);
       act.doubleClick(ele1).perform();
       Thread.sleep(3000);
       //selecting fastract as the watch brand
       WebElement ele2=driver.findElement(By.xpath("(//span[text()='Fastrack'])[5]"));
       act.doubleClick(ele2).perform();
       Thread.sleep(3000);
       //scrolling to the end of the page
       WebElement ele3=driver.findElement(By.xpath("//div[@class=\"a-section a-text-center s-pagination-container\"]"));
       act.scrollToElement(ele3).perform();
       Thread.sleep(3000);
       //navigating to the 2ndpage of the search results
       WebElement ele4=driver.findElement(By.xpath("(//a[@class=\"s-pagination-item s-pagination-button\"])[1]"));
       ele4.click();
       Thread.sleep(3000);
       //selecting 1st product in the 1st row
       WebElement ele5=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
       ele5.click();
       String parentId=driver.getWindowHandle();
       Set<String> allId=driver.getWindowHandles();
       for(String s:allId )
       {
    	   if(!s.contains(parentId))
    	   {
    		   driver.switchTo().window(s);
    	   }
       }
       Thread.sleep(3000);
       //selected item adding into the cart
       WebElement ele6=driver.findElement(By.xpath("//input[@value='Add to Cart']"));
       act.doubleClick(ele6).perform();
	}

}
