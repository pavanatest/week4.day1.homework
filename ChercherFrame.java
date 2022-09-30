package week4.day1.homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChercherFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Switch to Frame1
		
		driver.switchTo().frame("frame1");
		WebElement f1 = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));
		f1.sendKeys("Map");
		
		//Switch to Frame3 to click the Checkbox
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		//Switch to parent frame
		driver.switchTo().defaultContent();
		
		//Switch to Frame2 to select the DropDown option
		driver.switchTo().frame("frame2");
		
		WebElement animal = driver.findElement(By.xpath("//select[@id='animals']"));
		Select ani=new Select(animal);
		ani.selectByValue("babycat");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();

	}

}
