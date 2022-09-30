package week4.day1.homework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 1. Total number of iframes
		List<WebElement> sizeFrame = driver.findElements(By.xpath("//iframe"));
	
		
		// 2.Switch to Frame 1 to click the button 'Click Me'
		driver.switchTo().frame(driver.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe")));
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		driver.switchTo().defaultContent();
		
		// 3. Switch to Frame 2 to click 'Count Frames'
	
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
		
		driver.switchTo().defaultContent();
		
		// 4. Inside Nested Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe")));
		Thread.sleep(2000);
		
		List<WebElement> elements1 = driver.findElements(By.tagName("iframe"));
		int numberOfTags1 = elements1.size();
		System.out.println("No. of nested Iframes on this Web Page is : " +numberOfTags1);
		
		driver.switchTo().frame("frame2");
	
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

	}

}
