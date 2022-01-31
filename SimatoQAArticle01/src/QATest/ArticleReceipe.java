package QATest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ArticleReceipe{
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Navodya Automation\\Mahesha Automation\\SimatoQAArticle01\\Drivers01\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://appmakerstag.otenro.com/app/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("submitbtn"));
		
		email.sendKeys("mahesha@simatosolutions.com");
		password.sendKeys("Decjan@2022");
		login.click();
		Thread.sleep(5000);
		
		WebElement confmessage = driver.findElement(By.className("auto-login-dialog-btn-yes"));
		confmessage.click();
		Thread.sleep(30000);
		
		WebElement newapp = driver.findElement(By.name("Create_New_App"));
		newapp.click();
		Thread.sleep(3000);
		
		WebElement articlbtn = driver.findElement(By.xpath("//md-tab-item[2]/span"));
		articlbtn.click();
		Thread.sleep(3000);
		
		WebElement jobsbtn = driver.findElement(By.xpath("//md-tab-content[@id='tab-content-4']/div/div/div/div[2]/h4/button"));
		jobsbtn.click();
		
		WebElement appname = driver.findElement(By.name("appName"));
		appname.sendKeys("qareceipetest01");
		
		
	
	
}
}