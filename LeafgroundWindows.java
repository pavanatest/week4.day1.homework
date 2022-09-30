package week4.day1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindows {

public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		
		// 2. Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		// Get parentwindow
		String primaryWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String title = driver.getTitle();
		if(title.equals("Dashboard"))
			System.out.println("New page title DashBoard is verified");
		else
			System.out.println("Title is not verified");
		driver.close();
		driver.switchTo().window(windows.get(0));
		
		// 3. Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		
		Thread.sleep(6000);
		
		int count=0;
		for (String string : windows1)
		{
			System.out.println("Window id = "+string);
			count++;
		}
		System.out.println("Total number of windows opened ="+count);
		driver.close();
		driver.switchTo().window(windows1.get(0));
		
		// 4.Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		int windowSize = windowHandles2.size();
		System.out.println("Total number of windows including primary :"+windowSize);
		List<String>windows2=new ArrayList<String>(windowHandles2);
		String primaryWindow2 = driver.getWindowHandle();
		
		for (String string : windows2)
		{
			if(!primaryWindow2.equals(string))
			{
				driver.switchTo().window(string);
				Thread.sleep(6000);
				driver.close();
			}
		}
						
		Thread.sleep(6000);
		
		
		// 5. Wait for 2 new tabs to open
		driver.switchTo().window(windows.get(0));
		
		
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']")).click();
	
		Thread.sleep(4000);
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String>windows3=new ArrayList<String>(windowHandles3);
		String primaryWindow3 = driver.getWindowHandle();
		driver.switchTo().window(windows3.get(1));
	
		Thread.sleep(4000);	
		
		for (String string : windows3)
		{
			if(string!=primaryWindow3)
			{
				driver.switchTo().window(string);
				Thread.sleep(6000);
				driver.close();
			}
		}

	}

}
