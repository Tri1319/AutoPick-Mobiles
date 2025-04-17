package testFlipcart;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import Utilis.all_links;

public class filpcartTest implements all_links{
	static WebDriver driver;
	@BeforeClass

	public static void setUp() {		
		driver = new ChromeDriver();
		driver.get(base_Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(cross_icon).click();
	}
				
		@Test
		public void  buyTheMobile() throws InterruptedException{	
		WebElement ele = driver.findElement(search_icon);
		driver.findElement(search_icon).click();
		ele .sendKeys("Mobile phones under 20000");
		ele.sendKeys(Keys.ENTER);		
		List<WebElement> listOfWebElement = (List<WebElement>) driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		int lenght = listOfWebElement.size();
		System.out.println(lenght);	
		
		if (lenght != 0)
		{
		for(WebElement inputList : listOfWebElement) 		
		{
			String mobileList = inputList.getText();
			System.out.println(mobileList);		
			//Motorola G85 5G (Olive Green, 256 GB)
			boolean status = inputList.getText().contains("Motorola G85 5G (Olive Green, 256 GB)");
			System.out.println("status =" + status);	
			if (status==true)
			{
				inputList.click();
				break;
			}		
			else {
				System.out.println("Status does not match");		
			}
		}
		}
		else {
			System.out.println("Lenght is equal tozero");
		}		
//		driver.findElement(By.xpath("//button[contains(@class, 'QqFHMw')]")).click();
		
	}
      @Test		
		public void addToCart() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//button[@class='QqFHMw vslbG+ In9uk2 JTo6b7'][text()='ADD TO CART']"))));
		addToCart.click();
		}

      @AfterClass
      public void tearDown() {
          if (driver != null) {
              driver.quit();
          }
      }
}