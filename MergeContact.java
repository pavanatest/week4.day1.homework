package week4.day1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 
		 //7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		 
		 //8. Click on First Resulting Contact
		//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		Thread.sleep(6000);
		driver.switchTo().window(windows.get(0));
		 
		 //9. Click on Widget of To Contact
		//driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		WebElement findElement = driver.findElement(By.xpath("//input[@name='partyIdTo']/following-sibling::a/img"));
		
		findElement.click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		 
			 
		 // 10. Click on Second Resulting Contact
			
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		Thread.sleep(17000);
		//String match = ele.getText();
		//System.out.println(match);
		driver.switchTo().window(windows.get(0));
		 
		 //11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		 
		//12. Accept the Alert
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(10000);
		 
		//13. Verify the title of the page
		String title = driver.getTitle();
		System.out.println("Title is = "+title);
		
		if(title.contains("View Contact"))
			System.out.println("Title verified");
		else
			System.out.println("Title is not verified");

	}

}
