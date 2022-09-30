package week4.day1.homework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonJ {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		// 1.Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2.search as oneplus 9 pro 
		
		WebElement findElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		findElement.click();
		findElement.sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		//3.Get the price of the first product
		
		WebElement element = driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']//span "));
		String text = element.getText();
		
		String text1 = text.replace(",", "").replaceAll("[^0-9]","").replace(".", ".");
		int priceDouble = Integer.parseInt(text1); 
		System.out.println("Price is = "+priceDouble);
		
		
		//4. Print the number of customer ratings for the first displayed product
		WebElement customer = driver.findElement(By.xpath("//div[@class='a-row a-size-small']/span/following-sibling::span"));
		String cus = customer.getAttribute("aria-label");
		System.out.println("Customer reviews are = "+cus);
		
		//5. Click the first text link of the first image
		Thread.sleep(9000);
		
		WebElement s = driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a"));
		s.click();
		Thread.sleep(5000);
		
		//6. Take a screen shot of the product displayed
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snaps/screenshot1.png");
		FileUtils.copyFile(source, destination);
		 
		
		//7. Click 'Add to Cart' button
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		//8. Get the cart subtotal and verify if it is correct.
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		Thread.sleep(5000);
	
		
		String text2 =driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']//span[2]/span")).getText();
		String text3 = text2.replace(",", "").replaceAll("[^0-9]","").replace(".", ".");
		double price2Double=Double.parseDouble(text3);
		Thread.sleep(5000);
		double price1 = price2Double/100;
		System.out.println("Subtotal is = "+price1);

		
		if(priceDouble==price1)
		
			System.out.println("Subtotal amount is verified");
		else
			System.out.println("Subtotal amount is not correct");
		
		
		String text4 = driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText();
		System.out.println(text4);
		
		//9.close the browser
		//driver.quit();
		

	}

}
