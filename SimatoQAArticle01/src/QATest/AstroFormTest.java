package QATest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AstroFormTest {
	
		public String baseURL ="https://appmakerstag.otenro.com/app/login";
		String driverPath = "C:\\\\Appmaker Automation\\\\Article Fullround Testing Process(Staging)Paid Apps\\\\Chrome_Driver\\\\chromedriver.exe";
		public WebDriver driver;
		public String Appname;
		JavascriptExecutor js;
		String File;
		

		/*
		 * Login to the CMS Create new app Add new Category Add new page Add logo Change
		 * background color Font color Engage full section after app installation
		 * publish full section test
		 */

		@BeforeTest
		public void VerifyFrames() throws Exception {
			

			System.out.println("Launching Chrome Browser ");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			System.out.println("Browser launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		// Test case TC01 = Log in to the system with correct credentials
		@Test(priority = 1)
		public void VerifyLoginPage() throws Exception {
	
			driver.get(baseURL);

			//driver.findElement(By.name("Login_btn")).click();
			//Thread.sleep(2000);
			//System.out.println("Login button clicked = Passed");


		/*	driver.findElement(By.name("email")).sendKeys("saakunthalan1fm@gmail.com");
			Thread.sleep(2000);
			System.out.println("Terminated Email entered = Passed");

			driver.findElement(By.name("password")).sendKeys("Saku@12345");
			System.out.println("Password entered = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("submitbtn")).click();
			System.out.println("Login button clicked = Passed");
			Thread.sleep(2000);

			String actual_msg = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect = "Access denied. Your trying to login from an account that has been terminated";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Test Case Failed = " + actual_msg);
			}*/
			
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("mahesha@simatosolutions.com");
			Thread.sleep(2000);
			System.out.println("Email entered = Passed");

			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("Decjan@2022");
			System.out.println("Password entered = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("submitbtn")).click();
			System.out.println("Login button clicked = Passed");
			Thread.sleep(2000);
			
			List<WebElement> x = driver.findElements(By.className("auto-login-dialog-btn-yes"));

			if (x.size() > 0)
			{
			    x.get(0).click();
			} 

			String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1 = "Login Successful";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Test Case Failed = " + actual_msg1);
			}

			Thread.sleep(4000);

			/*List<WebElement> activeColumns = driver.findElements(By.name("Created_Apps"));
			Thread.sleep(1000);
			activeColumns.get(activeColumns.size() - 1).click();
			Thread.sleep(4000);
*/
			
		}

		// Create new App
		
		//-------------------------------------*********************************************************--------------------------------------------------

		@Test(priority = 2) // (priority=2)
		public void CreateNewApp() throws Exception {

		

			driver.findElement(By.name("Create_New_App")).click();
			System.out.println("Select a app button clicked");
			Thread.sleep(9000);
			
		//	driver.manage().deleteAllCookies();
		//	System.out.println("All cookies Deleted");
		//	Thread.sleep(5000);
			
		//	driver.navigate().refresh();
		//	driver.navigate().refresh();
		//	Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement astro = driver.findElement(By.className("auto-btn-select-Astro"));
			js.executeScript("arguments[0].scrollIntoView();", astro);
			Thread.sleep(4000);
		
			WebElement element = driver.findElement(By.className("auto-btn-select-Astro"));
			JavascriptExecutor js1= (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", element); 
			Thread.sleep(5000);

			
	//Check app naming window validation -----------------------------------------------------------------------------------------------------------
			
			driver.findElement(By.name("appName")).sendKeys("Astro123");
			System.out.println("App name entered");
			Thread.sleep(5000);
			
			driver.findElement(By.name("GetStarted_Btn")).click();
			System.out.println("Get Started button clicked");
			Thread.sleep(2000);
			
			String actual_msg21 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect21 = "App name already exists!";

			if (actual_msg21.contains(expect21)) {
				System.out.println("Validation passed = " + actual_msg21);
			} else {
				System.out.println("Test Case Failed = " + actual_msg21);
			}
			Thread.sleep(7000);
			
			driver.findElement(By.name("appName")).sendKeys("@#@%%@#%$_-/)?/");
			System.out.println("App name entered with special characters");
			Thread.sleep(5000);
			
			String actual_msg1 = driver.findElement(By.xpath("/html/body/div[1]/ui-view/form/div[2]/fieldset[3]/span")).getAttribute("innerHTML");
			String expect1 = "You can only add english characters and numbers";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Test Case Failed = " + actual_msg1);
			}
			Thread.sleep(7000);
			
			driver.findElement(By.name("appName")).clear();
			System.out.println("App naming window cleared");
			Thread.sleep(5000);
			
			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			Random random = new Random();
			StringBuilder buffer = new StringBuilder(targetStringLength);
			for (int i = 0; i < targetStringLength; i++) {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
			String generatedString = buffer.toString();

			WebElement App = driver.findElement(By.name("appName"));
			App.sendKeys(generatedString +" Astro");
			Thread.sleep(2000);

			WebElement Appname = driver.findElement(By.name("appName"));
			Appname.sendKeys(Keys.CONTROL + "a");

			Thread.sleep(1000);
			System.out.println("App name = " + Appname.getAttribute("value"));
			System.out.println("App name entered");

			String copiedText = driver.findElement(By.name("appName")).getAttribute("value").toString();
			Thread.sleep(1000);

			File file = new File("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\src\\Article_Test\\textWrite.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(copiedText);
			writer.close();

			Thread.sleep(10000);

			driver.findElement(By.name("GetStarted_Btn")).click();
			System.out.println("Get Started button clicked");
			Thread.sleep(7000);
			
			driver.findElement(By.cssSelector(".me-default-button:nth-child(2) > .ng-scope")).click();
			System.out.println("Please note that app name cannot be changed after this step. Confirm to proceed with the current app name - Confirm clicked");
			Thread.sleep(5000);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			WebElement yesb = driver.findElement(By.name("yes_btn"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", yesb); 
			
			System.out.println("Deleting demo data yes button clicked");
			Thread.sleep(2000);

			String actual_msg2 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2 = "Successfully Removed";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}
			Thread.sleep(7000);
			
			driver.findElement(By.className("automation-auto-refresh")).click();
			System.out.println("Auto Refesh slider button clicked");
			Thread.sleep(4000);
			
			driver.findElement(By.name("refresh")).click();
			System.out.println("Refresh button clicked");
			Thread.sleep(4000);
			


		}

		// Create new Category
		//------------------------------------------------------------------***************************************************-----------------------

		@Test(priority = 3) // (priority=3)
		public void AddNewCategory() throws Exception {
			

			driver.findElement(By.name("Pages")).click();
			System.out.println("----Pages button clicked---->>");
			Thread.sleep(3000);

			List<WebElement> b = driver.findElements(By.name("Inner_Pages"));
			Thread.sleep(1000);
			b.get(2).click(); // can change inside page inner pages
			System.out.println("----Categories button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("add_new_category")).click();
			System.out.println("----Add new Categories button clicked---->>");
			Thread.sleep(2000);

			driver.findElement(By.name("name")).sendKeys("Test003");
			System.out.println("----Category title entered---->>");
			Thread.sleep(2000);

			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("paid")).click();
			System.out.println("----Paid app radio button clicked---->>");
			Thread.sleep(2000);
			

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.name("browse_img"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(2000);
	// Below code for uploading image

			Robot robot = new Robot();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

	//Below code is for capturing image validation part, image should be less than 5 mb------------------------------------------------------------
			
			StringSelection stringselecton1 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\5mbimage.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton1, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");
			
			String actual_msg21 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect21 = "Image should be less than 5MB";

			if (actual_msg21.contains(expect21)) {
				System.out.println("Validation passed = " + actual_msg21);
			} else {
				System.out.println("Test Case Failed = " + actual_msg21);
			}
			Thread.sleep(7000);
			
			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("paid")).click();
			System.out.println("----Paid app radio button clicked---->>");
			Thread.sleep(2000);

	// Uploading correct image size image and saving -------------------------------------------------------------------------------
			
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

			StringSelection stringselecton = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic12.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");
			Thread.sleep(2000);
			// Scrolling to specific location

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			WebElement Element4 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js3.executeScript("arguments[0].scrollIntoView();", Element4);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element); 
			Thread.sleep(5000);
	// Validation capturing

			String actual_msg2 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2 = "New Category Added";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}
			Thread.sleep(7000);
			
	// Add another category to capture category name validation --------------------------------------------------------------------------------------
			
			driver.findElement(By.name("add_new_category")).click();
			System.out.println("----Add new Categories button clicked---->>");
			Thread.sleep(2000);

			driver.findElement(By.name("name")).sendKeys("Test003");
			System.out.println("----Category title entered---->>");
			Thread.sleep(2000);

			// Some times this id can be changed

			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("paid")).click();
			System.out.println("----Paid app radio button clicked---->>");
			Thread.sleep(2000);
			
			JavascriptExecutor js100 = (JavascriptExecutor) driver;
			WebElement Element100 = driver.findElement(By.name("browse_img"));
			js100.executeScript("arguments[0].scrollIntoView();", Element100);
			Thread.sleep(2000);
			
			JavascriptExecutor js101 = (JavascriptExecutor) driver;
			js101.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

			StringSelection stringselecton0 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic18.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton0, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).clickAndHold().perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).release().perform();

			}
			System.out.println("------Image croped---->>");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");
			Thread.sleep(2000);
			// Scrolling to specific location

			JavascriptExecutor js03 = (JavascriptExecutor) driver;
			WebElement Element04 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js03.executeScript("arguments[0].scrollIntoView();", Element04);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element0 = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor0 = (JavascriptExecutor)driver;
			executor0.executeScript("arguments[0].click();", element0); 
			Thread.sleep(5000);
			
	// Validation capturing

			String actual_msg20 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect20 = "Category name already exists";

			if (actual_msg20.contains(expect20)) {
				System.out.println("Validation passed = " + actual_msg20);
			} else {
				System.out.println("Test Case Failed = " + actual_msg20);
			}
			
			driver.findElement(By.name("name")).clear();
			System.out.println("----Category title cleared---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("name")).sendKeys("Test004");
			System.out.println("----Category title entered---->>");
			Thread.sleep(2000);
			
			JavascriptExecutor js023 = (JavascriptExecutor) driver;
			WebElement Element024 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js023.executeScript("arguments[0].scrollIntoView();", Element024);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element20 = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor20 = (JavascriptExecutor)driver;
			executor20.executeScript("arguments[0].click();", element20); 
			Thread.sleep(5000);
			
			String actual_msg240 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect240 = "New Category Added";

			if (actual_msg240.contains(expect240)) {
				System.out.println("Validation passed = " + actual_msg240);
			} else {
				System.out.println("Test Case Failed = " + actual_msg240);
			}
			
		
		
		}
		
		//-----------------------------------------------------------**************************************************--------------------------------
		
		@Test(priority = 4) // (priority=4)
		public void Edit_Category() throws Exception {
			
			driver.findElement(By.name("edit_btn")).click();
			System.out.println("----Category edit clicked---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("name")).clear();
			System.out.println("----Category name cleared---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("name")).sendKeys("Main Cat 1");
			System.out.println("----Category title entered---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("paid")).click();
			System.out.println("----Paid app radio button clicked---->>");
			Thread.sleep(2000);
			
			Robot robot = new Robot();
			
			JavascriptExecutor js100 = (JavascriptExecutor) driver;
			WebElement Element100 = driver.findElement(By.name("browse_img"));
			js100.executeScript("arguments[0].scrollIntoView();", Element100);
			Thread.sleep(2000);
			
			JavascriptExecutor js101 = (JavascriptExecutor) driver;
			js101.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

			StringSelection stringselecton0 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic4.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton0, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).clickAndHold().perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).release().perform();

			}
			System.out.println("------Image croped---->>");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");
			Thread.sleep(2000);
			// Scrolling to specific location

			JavascriptExecutor js03 = (JavascriptExecutor) driver;
			WebElement Element04 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js03.executeScript("arguments[0].scrollIntoView();", Element04);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element0 = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor0 = (JavascriptExecutor)driver;
			executor0.executeScript("arguments[0].click();", element0); 
			Thread.sleep(5000);
			
	// Validation capturing

			String actual_msg20 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect20 = "Updated Category!";

			if (actual_msg20.contains(expect20)) {
				System.out.println("Validation passed = " + actual_msg20);
			} else {
				System.out.println("Test Case Failed = " + actual_msg20);
			}
			Thread.sleep(5000);
			
		}
	//-----------------------------------------------------------Category order change and check---------------------------------------------------------
		
		@Test(priority = 5) // (priority=5)
		public void Category_Order() throws Exception {
			
			driver.findElement(By.className("automation-manage-cat-down-active")).click();
			System.out.println("----category order chaning arrow clicked---->>");
			Thread.sleep(6000);
			
			driver.findElement(By.name("ok_btn")).click();
			System.out.println("----ok_btn button clicked---->>");
			Thread.sleep(7000);
			
			List<WebElement> b = driver.findElements(By.name("Inner_Pages"));
			Thread.sleep(3000);
			b.get(2).click(); // can change inside page inner pages
			System.out.println("----Categories button clicked---->>");
			Thread.sleep(5000);
		}
		
		//----------------------------------------------------******************************************************************************************
		
		@Test(priority = 6) // (priority=6)
		public void Delete_Category() throws Exception {
			
			List<WebElement> b = driver.findElements(By.name("delete_btn"));
			Thread.sleep(1000);
			b.get(1).click();
			System.out.println("----Delete icon cliked---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.className("automation-del-cat-dialog-yes")).click();
			System.out.println("----Yes button cliked---->>");
			Thread.sleep(4000);
			
		}
		
		//--------------------------------------------------------------*****************************************************-------------------------

		@Test(priority = 7) // (priority=7)
		public void AddSubCategory() throws Exception {
			

			List<WebElement> b = driver.findElements(By.name("sub_cate_add_btn"));
			Thread.sleep(1000);
			b.get(0).click(); // can change inside page inner pages
			System.out.println("----Sub Categories button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("name")).sendKeys("Sub Cat 1");
			System.out.println("----Category title entered---->>");
			Thread.sleep(4000);

			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.name("browse_img"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(2000);

	// Below code for uploading image

			Robot robot = new Robot();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

	//Below code is for capturing image validation part, image should be less than 5 mb---------------------------------------------------------------
			
			StringSelection stringselecton1 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\5mbimage.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton1, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");
			
			String actual_msg21 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect21 = "Image should be less than 5MB";

			if (actual_msg21.contains(expect21)) {
				System.out.println("Validation passed = " + actual_msg21);
			} else {
				System.out.println("Test Case Failed = " + actual_msg21);
			}
			Thread.sleep(7000);
			
			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("paid")).click();
			System.out.println("----Paid app radio button clicked---->>");
			Thread.sleep(2000);

	// Uploading correct image and saving --------------------------------------------------------------------------------------------------------------------------------------
			
			JavascriptExecutor js10 = (JavascriptExecutor) driver;
			js10.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));

			robot.setAutoDelay(1000);

			StringSelection stringselecton = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic19.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");
			Thread.sleep(2000);

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			WebElement Element4 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js3.executeScript("arguments[0].scrollIntoView();", Element4);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element); 
			Thread.sleep(5000);
			// Validation capturing

			String actual_msg2 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2 = "New Category Added";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}
			Thread.sleep(5000);
			
	// Add another sub category with same name and get the validation message ------------------------------------------------------------------------
			
			List<WebElement> bb = driver.findElements(By.name("sub_cate_add_btn"));
			Thread.sleep(1000);
			bb.get(0).click(); // can change inside page inner pages
			System.out.println("----Sub Categories button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("name")).sendKeys("Sub Cat 1");
			System.out.println("----Category title entered---->>");
			Thread.sleep(4000);

			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("paid")).click();
			System.out.println("----Paid app radio button clicked---->>");
			Thread.sleep(2000);

	// Uploading correct image and saving -------------------------------------------------------------------------------------------------------------
			
			JavascriptExecutor js12 = (JavascriptExecutor) driver;
			js12.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));

			robot.setAutoDelay(1000);

			StringSelection stringselecton11 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic19.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton11, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).clickAndHold().perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).release().perform();

			}
			System.out.println("------Image croped---->>");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");
			Thread.sleep(2000);

			JavascriptExecutor js31 = (JavascriptExecutor) driver;
			WebElement Element41 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js31.executeScript("arguments[0].scrollIntoView();", Element41);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element1 = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", element1); 
			Thread.sleep(5000);
			// Validation capturing

			String actual_msg221 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect221 = "Category name already exists";

			if (actual_msg221.contains(expect221)) {
				System.out.println("Validation passed = " + actual_msg221);
			} else {
				System.out.println("Test Case Failed = " + actual_msg221);
			}
			Thread.sleep(5000);
			
			driver.findElement(By.name("name")).clear();
			System.out.println("----Category title removed---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("name")).sendKeys("Sub Cat 2");
			System.out.println("----Category title entered---->>");
			Thread.sleep(4000);
			
			JavascriptExecutor js01 = (JavascriptExecutor) driver;
			WebElement Element01 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js01.executeScript("arguments[0].scrollIntoView();", Element01);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element10 = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor10 = (JavascriptExecutor)driver;
			executor10.executeScript("arguments[0].click();", element10); 
			Thread.sleep(5000);
			// Validation capturing

			String actual_msg01 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect01 = "New Category Added";

			if (actual_msg01.contains(expect01)) {
				System.out.println("Validation passed = " + actual_msg01);
			} else {
				System.out.println("Test Case Failed = " + actual_msg01);
			}
			
			


		}
		
		//------------------------------------------------------------------------********************************************************************

		

		@Test(priority = 8) // (priority=8)
		public void EditSubCategory() throws Exception {
			
			List<WebElement> b = driver.findElements(By.name("edit_btn"));
			Thread.sleep(1000);
			b.get(1).click();
			System.out.println("----Sub Category edit button clicked---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.name("name")).clear();
			System.out.println("----Category title removed---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("name")).sendKeys("Sub Cat 3");
			System.out.println("----Category title entered---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("free")).click();
			System.out.println("----Free app radio button clicked---->>");
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.name("browse_img"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(2000);

	// Below code for uploading image

			Robot robot = new Robot();
			
			JavascriptExecutor js12 = (JavascriptExecutor) driver;
			js12.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));

			robot.setAutoDelay(1000);

			StringSelection stringselecton11 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic6.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton11, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).clickAndHold().perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).perform();

			}
			{
				WebElement element1 = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).release().perform();

			}
			System.out.println("------Image croped---->>");
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");
			Thread.sleep(2000);

			JavascriptExecutor js31 = (JavascriptExecutor) driver;
			WebElement Element41 = driver.findElement(By.xpath("//*[@id=\"fileInput\"]"));
			js31.executeScript("arguments[0].scrollIntoView();", Element41);
			Thread.sleep(7000);

			//driver.findElement(By.name("save_btn")).click();
			WebElement element1 = driver.findElement(By.name("save_btn"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", element1); 
			Thread.sleep(5000);
			// Validation capturing

			String actual_msg221 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect221 = "Updated Category!";

			if (actual_msg221.contains(expect221)) {
				System.out.println("Validation passed = " + actual_msg221);
			} else {
				System.out.println("Test Case Failed = " + actual_msg221);
			}
			Thread.sleep(5000);
			
			
		}
	//-----------------------------------------------------------------------------------***************************************************************
		
		@Test(priority = 9) // (priority=9)
		public void DeleteSubCategory() throws Exception {
			
			List<WebElement> b = driver.findElements(By.name("delete_btn"));
			Thread.sleep(1000);
			b.get(2).click();
			System.out.println("----Sub Category delete button clicked---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.className("automation-del-cat-dialog-yes")).click();
			System.out.println("---- delete yes button clicked---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.name("close_btn")).click();
			Thread.sleep(2000);
			
		}
		
		//------------------------------------------------------------------------**********************************************************************
		// Create new page

		@Test(priority = 10) // (priority=10)
		public void AddNewPage() throws Exception {

			

			List<WebElement> b = driver.findElements(By.name("Inner_Pages"));
			Thread.sleep(1000);
			b.get(0).click(); // can change inside page inner pages
			System.out.println("----Create page button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("title")).sendKeys("Testing1236");
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);

	///////////////////////////////---------------------Calander validation testing -----------------------------////////////////////////////////////
			
			 WebElement selectCalender =driver.findElement(By.className("iconContainer")); selectCalender.click();
			 System.out.println("----Calendar clicked---->>"); Thread.sleep(2000);
			 
			  driver.findElement(By.cssSelector(".ng-scope > .today")).click();
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(".timeSelectIcon")).click();
			  Thread.sleep(2000);
			 
			 for (int i = 0; i < 2; i++) {
			 driver.findElement(By.cssSelector(".dtpIcon:nth-child(1) use")).click();
			 
			 Thread.sleep(300); } for (int i = 0; i < 15; i++) {
			 driver.findElement(By.cssSelector(".dtpIcon:nth-child(3) use")).click();
			 
			 Thread.sleep(300); }
			 
			 Thread.sleep(2000); WebElement selectCalender1 =
			 driver.findElement(By.className("iconContainer")); selectCalender1.click();
			 Thread.sleep(2000);
			 System.out.println("----PUBLISH DATE AND TIME Entered---->>");
			 
			 String ClassNameOfSameElements="iconContainer"; List<WebElement>
			 c=driver.findElements(By.className(ClassNameOfSameElements)) ;
			 c.get(1).click(); Thread.sleep(2000);
			
			 driver.findElement(By.cssSelector(".yearMonth")).click(); Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".yearContainer > .ng-binding")).click();
			 Thread.sleep(2000); 
			 driver.findElement(By.cssSelector(".monthContainer > .ng-scope:nth-child(17) > .ng-binding")).click(); 
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".ng-scope:nth-child(31) > .ng-binding")).click(); Thread.sleep(4000);
			 
			 driver.findElement(By.cssSelector(".open .closeIcon")).click();
			 Thread.sleep(2000);
			 
			 System.out.println("----EXPIRY DATE AND TIME Entered---->>");
			 Thread.sleep(2000);
			 
		//----------------------Going to select category ----------------------------------------------

			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement Element = driver.findElement(By.name("search_categ"));
			 js.executeScript("arguments[0].scrollIntoView();", Element);
			 Thread.sleep(4000);
			 
			 List<WebElement> b1 = driver.findElements(By.name("mainsub_cat"));
			 b1.get(0).click();
			 System.out.println("------main_category clicked---->>");
			 Thread.sleep(2000);

			 driver.findElement(By.name("Enable_Comments_chekbox")).click();
			 Thread.sleep(2000);
			 System.out.println("------Enable Comments checkbox ticked ---->>");

			 driver.findElement(By.name("Enable_Messaging_chekbox")).click();
			 Thread.sleep(4000);
			 System.out.println("------Enable Messaging checkbox ticked---->>");

			 driver.findElement(By.name("next_btn")).click();
			 Thread.sleep(4000);
			 System.out.println("------Next button clicked---->>");
			 
		//-----------------------Going to add banner images ----------------------------------------------
			 

			// Image uploading

			Robot robot = new Robot();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

	//Below code is for capturing image validation part, image should be less than 5 mb
			
			StringSelection stringselecton12 = new StringSelection("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\Comic imges\\5mbimage.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton12, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");
			
			String actual_msg21 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect21 = "Image should be less than 5MB";

			if (actual_msg21.contains(expect21)) {
				System.out.println("Validation passed = " + actual_msg21);
			} else {
				System.out.println("Test Case Failed = " + actual_msg21);
			}
			Thread.sleep(4000);

	// Uploading correct image and saving 
			

			WebElement imag = driver.findElement(By.id("fileInput"));
			Actions actions = new Actions(driver);
			actions.moveToElement(imag).click().build().perform();

			robot.setAutoDelay(2000);

			StringSelection stringselecton = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic14.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

	// Catch validation message

			String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1 = "Image has been uploaded successfully";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Test Case Failed = " + actual_msg1);
			}

			Thread.sleep(5000);

			driver.findElement(By.name("chk_videoUrl1")).click();
			Thread.sleep(2000);
			System.out.println("------ Youtub video checkbox ticked---->>");

			driver.findElement(By.cssSelector("#videoUrl2")).sendKeys("https://www.youtube.com/watch?v=XAh2FujZ-0g");
			Thread.sleep(2000);
			System.out.println("------Youtube video url entered---->>");
			
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].click();", driver.findElement(By.name("Select_Img_btn")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton1 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic7.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton1, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

			// Catch validation message

			String actual_msg3 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect3 = "Image has been uploaded successfully";

			if (actual_msg1.contains(expect3)) {
				System.out.println("Validation passed = " + actual_msg3);
			} else {
				System.out.println("Test Case Failed = " + actual_msg3);
			}
			Thread.sleep(9000);
			
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------Next button clicked ---->>");
			Thread.sleep(3000);
			
	//---------------------------------- Going to add text editor section -------------------*******************************************************************-------------------------------
			

			WebElement Pagedescription = driver.findElement(By.cssSelector(".ql-editor"));
			Pagedescription.click();
			Pagedescription.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
			Thread.sleep(4000);
			Pagedescription.sendKeys(Keys.CONTROL,"a");
			Thread.sleep(2000);
			
			driver.findElement(By.className("ql-bold")).click();
			System.out.println("------Bold button clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.className("ql-italic")).click();
			System.out.println("------Italic button clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.className("ql-underline")).click();
			System.out.println("------Under line button clicked ---->>");
			Thread.sleep(3000);
			
			Pagedescription.click();
			
			
	//For the page description image has been added from below code --------------------------------------------------------------------------------
			
			JavascriptExecutor js21 = (JavascriptExecutor) driver;
			js21.executeScript("arguments[0].click();", driver.findElement(By.className("ql-image")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton122 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic12.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton122, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			Thread.sleep(4000);
			
	// From below code Video is added for the page description ----------------------------------------------------------------------------------
		
			driver.findElement(By.cssSelector("ng-quill-editor[name='editorText'] .ql-video")).click();
			System.out.println("------Add video url icon clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector("ng-quill-editor[name='editorText'] .ql-tooltip input[type='text']")).sendKeys("https://www.youtube.com/watch?v=49RZx5tUKM4");
			System.out.println("------video url entered ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector("ng-quill-editor[name='editorText'] .ql-action")).click();
			System.out.println("------Save button clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.className("automation-create-page-btn-publish")).click();
			System.out.println("------Publish button clicked---->>");
			Thread.sleep(2000);
			
	//--------------/////////////////////////////////////////////////------Testing date time validation ---------------////////////////////////////////

			
			String actual_msg33 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect33 = "Publish date and time is not valid!";

			if (actual_msg33.contains(expect33)) {
				System.out.println("Validation passed = " + actual_msg33);
			} else {
				System.out.println("Test Case Failed = " + actual_msg33);
			}

			Thread.sleep(5000);
			
			driver.findElement(By.name("save_btn")).click();
			System.out.println("------Back button clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("save_btn")).click();
			System.out.println("------Back button clicked---->>");
			Thread.sleep(2000);
			
			WebElement selectCalender12 =driver.findElement(By.className("iconContainer")); selectCalender12.click();
			 System.out.println("----Calendar clicked---->>"); Thread.sleep(2000);
			 
			  driver.findElement(By.cssSelector(".ng-scope > .today")).click();
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(".timeSelectIcon")).click();
			  Thread.sleep(2000);
			
			for (int i = 0; i < 20; i++) {
				 driver.findElement(By.cssSelector(".dtpIcon:nth-child(1) use")).click();
				 
				 Thread.sleep(300); } for (int i = 0; i < 15; i++) {
				 driver.findElement(By.cssSelector(".dtpIcon:nth-child(3) use")).click();
				 
				 Thread.sleep(300); }
				 
				 Thread.sleep(2000); WebElement selectCalender11 =
				 driver.findElement(By.className("iconContainer")); selectCalender11.click();
				 Thread.sleep(2000);
				 System.out.println("----PUBLISH DATE AND TIME Entered---->>");
				 
				 String ClassNameOfSameElements1="iconContainer"; List<WebElement>
				 c1=driver.findElements(By.className(ClassNameOfSameElements1)) ;
				 c1.get(1).click(); Thread.sleep(2000);
				
				 driver.findElement(By.cssSelector(".yearMonth")).click(); Thread.sleep(2000);
				 driver.findElement(By.cssSelector(".yearContainer > .ng-binding")).click();
				 Thread.sleep(2000); driver.findElement(By.
				 cssSelector(".monthContainer > .ng-scope:nth-child(17) > .ng-binding")).click(); 
				 Thread.sleep(2000);
				 driver.findElement(By.cssSelector(".ng-scope:nth-child(31) > .ng-binding")).click(); Thread.sleep(4000);
				 
				 driver.findElement(By.cssSelector(".open .closeIcon")).click();
				 Thread.sleep(2000);
				 
				 System.out.println("----EXPIRY DATE AND TIME Entered---->>");
				 Thread.sleep(4000);
				 
			
			driver.findElement(By.className("automation-create-page-btn-publish")).click();
			Thread.sleep(2000);
			System.out.println("------Publish button clicked---->>");
			
			String actual_msg2 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2 = "Your article has successfully been published ";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}

			Thread.sleep(4000);
			
			
		}
		@Test(priority = 11) //priority = 11
		public void addpdf_withLoad_PDF_Download_disabled() throws AWTException, InterruptedException {
			
	// --------***********************************--------------------- Add new page with PDF-----------------------------------------***************************************---------------------------------------
			
			driver.findElement(By.name("Create_page_btn")).click();
			Thread.sleep(4000);
			System.out.println("----Create page button clicked---->>");
			
			driver.findElement(By.name("title")).sendKeys("Testing PDF");
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);
			
	// ---------------------------------------Going to select category ------------------------------------------
			
			 JavascriptExecutor js11 = (JavascriptExecutor) driver;
			 WebElement Element1 = driver.findElement(By.name("search_categ"));
			 js11.executeScript("arguments[0].scrollIntoView();", Element1);
			 Thread.sleep(4000);
			
			List<WebElement> b3 = driver.findElements(By.name("mainsub_cat"));
			b3.get(0).click();
			System.out.println("------main_category clicked---->>");
			Thread.sleep(4000);
			
	//---------------------Going to upload PDF -------------------------------------------------------------
			Robot robot = new Robot();
			driver.findElement(By.name("checkb_Load_PDF_01")).click();
			Thread.sleep(4000);
			System.out.println("----PDF checkbox clicked---->>");
			
			JavascriptExecutor js81 = (JavascriptExecutor) driver;
			js81.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div:nth-child(1) > .btn")));
			
			robot.setAutoDelay(2000);

			StringSelection stringselecton41 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\6mbpdf.pdf");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton41, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----pdf uploaded---->>");
			

			String actual_msg7 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect7 = "Try Again  Maximum PDF file size allowed is 5MB !";

			if (actual_msg7.contains(expect7)) {
				System.out.println("Validation passed = " + actual_msg7);
			} else {
				System.out.println("Test Case Failed = " + actual_msg7);
			}
			
			driver.findElement(By.name("checkb_Load_PDF_01")).click();
			Thread.sleep(2000);
			System.out.println("----PDF check box clicked---->>");
			
			driver.findElement(By.name("checkb_Load_PDF_01")).click();
			Thread.sleep(4000);
			System.out.println("----PDF check box clicked---->>");
			
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div:nth-child(1) > .btn")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton5 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\file-example_PDF_1MB.pdf");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton5, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----pdf uploaded---->>");
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------Next button clicked---->>");
			Thread.sleep(4000);
			
		
	//----------------Going to upload image -----------------------------------------------------------
			
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton4 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic14.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton4, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

			// Catch validation message

			String actual_msg15 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect15 = "Image has been uploaded successfully";

			if (actual_msg15.contains(expect15)) {
				System.out.println("Validation passed = " + actual_msg15);
			} else {
				System.out.println("Test Case Failed = " + actual_msg15);
			}

			
			driver.findElement(By.className("automation-create-page-btn-publish")).click();
			Thread.sleep(2000);
			System.out.println("------Publish button clicked---->>");

			String actual_msg4 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]"))
					.getAttribute("innerHTML");
			String expect4 = "Your article has successfully been published ";

			if (actual_msg4.contains(expect4)) {
				System.out.println("Validation passed = " + actual_msg4);
			} else {
				System.out.println("Test Case Failed = " + actual_msg4);
			}
			Thread.sleep(3000);
			
			driver.findElement(By.name("name")).sendKeys("Testing PDF");
			Thread.sleep(4000);
			
			driver.findElement(By.name("name")).clear();
			Thread.sleep(4000);
			
			System.out.println("------Entred text to search---->>");
		
		//-----------------------------------------------***********************************************************--------------------------------	
			
		}
		
		
		@Test(priority = 12)//priority = 12
		public void addpdf_with_Download_enable() throws AWTException, InterruptedException {
			
			
	// --------***********************************--------------------- Add new page with PDF-----------------------------------------***************************************---------------------------------------
			
			driver.findElement(By.name("Create_page_btn")).click();
			Thread.sleep(4000);
			System.out.println("----Create page button clicked---->>");
			
			driver.findElement(By.name("title")).sendKeys("Testing PDF 2");
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);
			
	// ---------------------------------------Going to select category ------------------------------------------
			
			 JavascriptExecutor js11 = (JavascriptExecutor) driver;
			 WebElement Element1 = driver.findElement(By.name("search_categ"));
			 js11.executeScript("arguments[0].scrollIntoView();", Element1);
			 Thread.sleep(4000);
			
			List<WebElement> b3 = driver.findElements(By.name("mainsub_cat"));
			b3.get(0).click();
			System.out.println("------main_category clicked---->>");
			Thread.sleep(4000);
			
	//---------------------Going to upload PDF -------------------------------------------------------------
			Robot robot = new Robot();
			driver.findElement(By.name("checkb_Load_PDF_02")).click();
			Thread.sleep(4000);
			System.out.println("----PDF checkbox clicked---->>");
			
			JavascriptExecutor js81 = (JavascriptExecutor) driver;
			js81.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div:nth-child(2) > .btn")));
			
			robot.setAutoDelay(2000);

			StringSelection stringselecton41 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\6mbpdf.pdf");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton41, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----pdf uploaded---->>");
			

			String actual_msg7 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect7 = "Try Again  Maximum PDF file size allowed is 5MB !";

			if (actual_msg7.contains(expect7)) {
				System.out.println("Validation passed = " + actual_msg7);
			} else {
				System.out.println("Test Case Failed = " + actual_msg7);
			}
			
			driver.findElement(By.name("checkb_Load_PDF_02")).click();
			Thread.sleep(2000);
			System.out.println("----PDF check box clicked---->>");
			
			driver.findElement(By.name("checkb_Load_PDF_02")).click();
			Thread.sleep(4000);
			System.out.println("----PDF check box clicked---->>");
			
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div:nth-child(2) > .btn")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton5 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\file-example_PDF_1MB.pdf");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton5, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----pdf uploaded---->>");
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------Next button clicked---->>");
			Thread.sleep(4000);
			
		
	//----------------Going to upload image -----------------------------------------------------------
			
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton4 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic14.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton4, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

			// Catch validation message

			String actual_msg15 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect15 = "Image has been uploaded successfully";

			if (actual_msg15.contains(expect15)) {
				System.out.println("Validation passed = " + actual_msg15);
			} else {
				System.out.println("Test Case Failed = " + actual_msg15);
			}

			
			driver.findElement(By.className("automation-create-page-btn-publish")).click();
			Thread.sleep(2000);
			System.out.println("------Publish button clicked---->>");

			String actual_msg4 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]"))
					.getAttribute("innerHTML");
			String expect4 = "Your article has successfully been published ";

			if (actual_msg4.contains(expect4)) {
				System.out.println("Validation passed = " + actual_msg4);
			} else {
				System.out.println("Test Case Failed = " + actual_msg4);
			}
			Thread.sleep(8000);
		
		//-----------------------------------------------***********************************************************--------------------------------	
			
		}
		
		
		@Test(priority = 13)//priority = 13
		public void Edit_PDF() throws AWTException, InterruptedException {

			
	// --------***********************************--------------------- Add new page with PDF-----------------------------------------***************************************---------------------------------------
			
			List<WebElement> b3 = driver.findElements(By.className("auto-link-page-edit"));
			b3.get(0).click();
			System.out.println("------Edit page clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("title")).clear();
			driver.findElement(By.name("title")).sendKeys("Edited Testing PDF 2");
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);
			
			Robot robot = new Robot();
			
			driver.findElement(By.name("checkb_Load_PDF_01")).click();
			Thread.sleep(2000);
			System.out.println("----PDF check box clicked---->>");
			
			driver.findElement(By.name("checkb_Load_PDF_02")).click();
			Thread.sleep(4000);
			System.out.println("----PDF check box clicked---->>");
			
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div:nth-child(1) > .btn")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton5 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\file-example_PDF_1MB.pdf");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton5, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----pdf uploaded---->>");
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------Next button clicked---->>");
			Thread.sleep(4000);
			
		
	//----------------Going to upload image -----------------------------------------------------------
			
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton4 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic14.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton4, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

			// Catch validation message

			String actual_msg15 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect15 = "Image has been uploaded successfully";

			if (actual_msg15.contains(expect15)) {
				System.out.println("Validation passed = " + actual_msg15);
			} else {
				System.out.println("Test Case Failed = " + actual_msg15);
			}

			
			driver.findElement(By.className("utomation-create-page-btn-update")).click();
			Thread.sleep(2000);
			System.out.println("------Publish button clicked---->>");

			String actual_msg4 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]"))
					.getAttribute("innerHTML");
			String expect4 = "Your article has successfully been published ";

			if (actual_msg4.contains(expect4)) {
				System.out.println("Validation passed = " + actual_msg4);
			} else {
				System.out.println("Test Case Failed = " + actual_msg4);
			}
			Thread.sleep(3000);
		
		//-----------------------------------------------***********************************************************--------------------------------	
			
		}
		
		@Test(priority = 14 ) // (priority=6)
		public void Edit_Page() throws Exception {

			
			List<WebElement> b3 = driver.findElements(By.name("edit_article"));
			b3.get(0).click();
			System.out.println("------Edit page clicked---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("title")).clear();
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("title")).sendKeys("Page 1");
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------Next button clickeds---->>");
			Thread.sleep(4000);
			
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			
			Robot robot = new Robot();

			robot.setAutoDelay(2000);

			StringSelection stringselecton4 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic14.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton4, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

			// Catch validation message

			String actual_msg15 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect15 = "Image has been uploaded successfully";

			if (actual_msg15.contains(expect15)) {
				System.out.println("Validation passed = " + actual_msg15);
			} else {
				System.out.println("Test Case Failed = " + actual_msg15);
			}
			
			driver.findElement(By.name("chk_videoUrl2")).click();
			Thread.sleep(2000);
			System.out.println("------ Youtub video checkbox ticked---->>");

			driver.findElement(By.name("videoUrl3")).sendKeys("https://www.youtube.com/watch?v=XAh2FujZ-0g");
			Thread.sleep(2000);
			System.out.println("------Youtube video url entered---->>");		
			
			driver.findElement(By.name("update_btn")).click();
			Thread.sleep(8000);
			System.out.println("------Update button clicked---->>");

			String actual_msg4 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect4 = "Your article has successfully been published ";

			if (actual_msg4.contains(expect4)) {
				System.out.println("Validation passed = " + actual_msg4);
			} else {
				System.out.println("Test Case Failed = " + actual_msg4);
			}
			Thread.sleep(3000);
		


		}
		//-------------------------------------------------------------*******Add_Page_From_MangePages*****------------------------------------------\
		
		@Test(priority = 15) // (priority=6)
		public void Add_Page_From_MangePages() throws Exception {
			
			driver.findElement(By.name("Pages")).click();
			System.out.println("----Pages button clicked---->>");
			Thread.sleep(3000);
			
			List<WebElement> b = driver.findElements(By.name("Inner_Pages"));
			Thread.sleep(1000);
			b.get(1).click(); // can change inside page inner pages
			System.out.println("----Manage Pages button clicked---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.name("Create_page_btn")).click();
			Thread.sleep(2000);
			System.out.println("------ Create_page_btn clicked---->>");
			
			WebElement pagetitle = driver.findElement(By.name("title"));
			pagetitle.sendKeys("Page 01");
			pagetitle.sendKeys(Keys.CONTROL + "a");
			System.out.println("----Title Entered---->>");
			Thread.sleep(2000);
			
			String copiedText1 = driver.findElement(By.name("title")).getAttribute("value").toString();
			Thread.sleep(1000);
			
			File file = new File("C:\\Navodya Automation\\Mahesha Automation\\SimatoQAArticle01\\src\\QATest\\testdata.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(copiedText1);
			writer.close();

			
			
			 /*WebElement selectCalender =driver.findElement(By.className("iconContainer")); 
			 selectCalender.click();
			 System.out.println("----Calendar clicked---->>"); 
			 Thread.sleep(2000);
			 
			  driver.findElement(By.cssSelector(".ng-scope > .today")).click();
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(".timeSelectIcon")).click();
			  Thread.sleep(2000);
			 
			 for (int i = 0; i < 14; i++) {
			 driver.findElement(By.cssSelector(".dtpIcon:nth-child(1) use")).click();
			 Thread.sleep(300); 
			 } 
			 for (int i = 0; i <40; i++)
			 {
			 driver.findElement(By.cssSelector(".dtpIcon:nth-child(3) use")).click();
			 Thread.sleep(300); 
			 }
			 
			 WebElement selectCalender1 = driver.findElement(By.className("iconContainer")); 
			 selectCalender1.click();
			 Thread.sleep(2000);
			 System.out.println("----PUBLISH DATE AND TIME Entered---->>");
			 
			 String ClassNameOfSameElements="iconContainer"; 
			 List<WebElement> c=driver.findElements(By.className(ClassNameOfSameElements)) ;
			 c.get(1).click(); 
			 Thread.sleep(2000);
			
			 driver.findElement(By.cssSelector(".yearMonth")).click(); Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".yearContainer > .ng-binding")).click();
			 Thread.sleep(2000); 
			 driver.findElement(By.cssSelector(".monthContainer > .ng-scope:nth-child(17) > .ng-binding")).click(); 
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".ng-scope:nth-child(31) > .ng-binding")).click(); Thread.sleep(4000);
			 
			 driver.findElement(By.cssSelector(".open .closeIcon")).click();
			 Thread.sleep(2000);
			 
			 System.out.println("----EXPIRY DATE AND TIME Entered---->>");
			 Thread.sleep(2000);
			 */
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement Element = driver.findElement(By.name("search_categ"));
			 js.executeScript("arguments[0].scrollIntoView();", Element);
			 Thread.sleep(4000);
			 
			 List<WebElement> b1 = driver.findElements(By.name("main_category"));
			 b1.get(0).click();
			 System.out.println("------main_category clicked---->>");
			 Thread.sleep(2000);
			
			
			Robot robot = new Robot();
			
			driver.findElement(By.name("Enable_Forms_chekbox")).click();
			Thread.sleep(2000);
			System.out.println("------Enable Forms checkbox ticked ---->>");

			
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------next_btn ticked---->>");
			Thread.sleep(4000);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", driver.findElement(By.id("fileInput")));
			robot.setAutoDelay(1000);

	//Below code is for capturing image validation part, image should be less than 5 mb
			
			/*StringSelection stringselecton12 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\5mbimage.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton12, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");
			
			String actual_msg21 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect21 = "Image should be less than 5MB";

			if (actual_msg21.contains(expect21)) {
				System.out.println("Validation passed = " + actual_msg21);
			} else {
				System.out.println("Test Case Failed = " + actual_msg21);
			}


			robot.setAutoDelay(4000);*/
			
			WebElement imag = driver.findElement(By.id("fileInput"));
			Actions actions = new Actions(driver);
			actions.moveToElement(imag).click().build().perform();

			robot.setAutoDelay(2000);

			StringSelection stringselecton = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic13.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");

			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).clickAndHold().perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();

			}
			{
				WebElement element = driver.findElement(By.cssSelector(".upper-canvas"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).release().perform();

			}
			System.out.println("------Image croped---->>");

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".upper-canvas")).click();
			driver.findElement(By.name("Crop_&_Save_btn")).click();
			System.out.println("------Crop & Save button clicked---->>");

			Thread.sleep(4000);

	// Catch validation message

			String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1 = "Image has been uploaded successfully";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Test Case Failed = " + actual_msg1);
			}

			Thread.sleep(5000);

			
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------Next button clicked ---->>");
			Thread.sleep(4000);
		 
	// Form Details section
			
			driver.findElement(By.name("Form_Title")).sendKeys("Form 01");
			System.out.println("----Form title Entered---->>");
			Thread.sleep(2000);
			
			
			//C:\Appmaker Automation\Article Fullround_With_page_creation_changes\Images\Comic imges\Comic7.jpg
			
			
			
			/*driver.findElement(By.name("check_availability_period")).click();
			System.out.println("----Enable availability period checked-tttttttttttt---->>");
			Thread.sleep(9000);
			
			WebElement selectCalender12 =driver.findElement(By.className("iconContaine"));
			selectCalender12.sendKeys(Keys.RETURN);
	
			System.out.println("----Calendar clicked---->>"); 
			Thread.sleep(2000);
			 
			driver.findElement(By.cssSelector(".ng-scope > .today")).click();
			Thread.sleep(2000);
			 
			driver.findElement(By.cssSelector(".timeSelectIcon")).click();
			Thread.sleep(2000);
			
			for (int i = 0; i < 20; i++) {
				 driver.findElement(By.cssSelector(".dtpIcon:nth-child(1) use")).click();
				 
				 Thread.sleep(300); 
				 } 
			for (int i = 0; i < 15; i++) {
				 driver.findElement(By.cssSelector(".dtpIcon:nth-child(3) use")).click();
				 
				 Thread.sleep(300); 
				 }
				 
			Thread.sleep(2000); WebElement selectCalender11 =
			driver.findElement(By.className("iconContainer")); selectCalender11.click();
			Thread.sleep(2000);
			System.out.println("----PUBLISH DATE AND TIME Entered---->>");
				 
			String ClassNameOfSameElements1="iconContainer"; List<WebElement>
			c1=driver.findElements(By.className(ClassNameOfSameElements1)) ;
			c1.get(1).click(); Thread.sleep(2000);
				
				 driver.findElement(By.cssSelector(".yearMonth")).click(); Thread.sleep(2000);
				 driver.findElement(By.cssSelector(".yearContainer > .ng-binding")).click();
				 Thread.sleep(2000); driver.findElement(By.
				 cssSelector(".monthContainer > .ng-scope:nth-child(17) > .ng-binding")).click(); 
				 Thread.sleep(2000);
				 driver.findElement(By.cssSelector(".ng-scope:nth-child(31) > .ng-binding")).click(); Thread.sleep(4000);
				 
				 driver.findElement(By.cssSelector(".open .closeIcon")).click();
				 Thread.sleep(2000);
				 
				 System.out.println("----EXPIRY DATE AND TIME Entered---->>");
				 Thread.sleep(4000);*/
			
			/*JavascriptExecutor js5 = (JavascriptExecutor) driver;
			WebElement findcalendar = driver.findElement(By.className("iconContainer"));
			js5.executeScript("arguments[0].scrollIntoView();", findcalendar);
			Thread.sleep(4000);
		
			WebElement selectcalendar = driver.findElement(By.className("iconContainer"));
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("arguments[0].click();", selectcalendar); 
			Thread.sleep(5000);
			
			WebElement selectCalenderForm1 = driver.findElement(By.cssSelector("body.md-dialog-is-showing:nth-child(2) div.md-dialog-container.ng-scope:nth-child(30) md-dialog._md.md-transition-in:nth-child(2) form.ng-invalid.ng-invalid-required.ng-dirty.ng-valid-parse md-tabs.ng-isolate-scope.md-dynamic-height md-tabs-content-wrapper._md:nth-child(2) md-tab-content._md.ng-scope.md-no-scroll.md-active:nth-child(3) div.ng-scope.ng-isolate-scope div.ng-scope div.md-dialog-main.clearfix fieldset.date-select-elem:nth-child(2) div.clearfix.publish-article-publish-date-time-form-Start:nth-child(2) div.ADMdtp-container.ng-isolate-scope.ng-empty.ng-dirty.ng-valid div.clickOutContainer.ng-isolate-scope:nth-child(1) div.masterInput.ng-scope > div.iconContainer"));
			selectCalenderForm1.click();
			System.out.println("----Calendar clicked---->>"); 
			Thread.sleep(5000);
			 
			 driver.findElement(By.cssSelector(".ng-scope > .today")).click();
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(".timeSelectIcon")).click();
			 Thread.sleep(2000);
			 
			 for (int i = 0; i < 7; i++) {
			 driver.findElement(By.cssSelector(".dtpIcon:nth-child(1) use")).click();
			 
			 Thread.sleep(300); } for (int i = 0; i < 2; i++) {
			 driver.findElement(By.cssSelector(".dtpIcon:nth-child(3) use")).click();
			 Thread.sleep(300); }
			 
			 Thread.sleep(8000); 
			 driver.findElement(By.id("addedQsTable")).click();
			 Thread.sleep(2000);
			 System.out.println("----PUBLISH DATE AND TIME Entered---->>");
			 Thread.sleep(4000);
			 
			 JavascriptExecutor js14 = (JavascriptExecutor) driver;
				WebElement findcalendar1 = driver.findElement(By.className("iconContainer"));
				js14.executeScript("arguments[0].scrollIntoView();", findcalendar1);
				Thread.sleep(4000);
			
				WebElement selectcalendar1 = driver.findElement(By.className("iconContainer"));
				JavascriptExecutor js13 = (JavascriptExecutor) driver;
				js13.executeScript("arguments[0].click();", selectcalendar1); 
				Thread.sleep(5000);
				
			 String ClassNameOfSameElements="iconContainer"; 
			 List<WebElement> c=driver.findElements(By.className(ClassNameOfSameElements)) ;
			 c.get(1).click(); 
			 Thread.sleep(2000);
			
			 driver.findElement(By.cssSelector(".yearMonth")).click(); 
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".yearContainer > .ng-binding")).click();
			 Thread.sleep(2000); 
			 driver.findElement(By.cssSelector(".monthContainer > .ng-scope:nth-child(17) > .ng-binding")).click(); 
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".ng-scope:nth-child(31) > .ng-binding")).click(); Thread.sleep(4000);
			 
			 driver.findElement(By.cssSelector(".open .closeIcon")).click();
			 Thread.sleep(2000);
			 
			 System.out.println("----EXPIRY DATE AND TIME Entered---->>");
			 Thread.sleep(2000);*/

				driver.findElement(By.name("limit_responses")).click();
				System.out.println("----Limit one responce clicked---");
				Thread.sleep(2000);
				
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
				WebElement addquestion = driver.findElement(By.name("add_question_btn"));
				js3.executeScript("arguments[0].scrollIntoView();", addquestion);
				Thread.sleep(4000);
			
				WebElement addquestion1 = driver.findElement(By.name("add_question_btn"));
				JavascriptExecutor js4 = (JavascriptExecutor) driver;
				js4.executeScript("arguments[0].click();", addquestion1); 
				Thread.sleep(5000);
				
				
				driver.findElement(By.name("Response_Type")).click();
				System.out.println("------ResponeType dropdown selected  ---->>");
				Thread.sleep(2000);
				
				List<WebElement> responsevalue1 = driver.findElements(By.className("auto-sel-opt-response-type"));
				 responsevalue1.get(0).click();
				 System.out.println("------Type clicked---->>");
				 Thread.sleep(2000);
				
			
				
	// Page description section -------------------*******************************************************************-------------------------------
			
	
			WebElement Pagedescription = driver.findElement(By.cssSelector(".ql-editor"));
			Pagedescription.click();
			Pagedescription.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
			Thread.sleep(4000);
			Pagedescription.sendKeys(Keys.CONTROL,"a");
			Thread.sleep(2000);
		
			driver.findElement(By.className("ql-bold")).click();
			System.out.println("------Bold button clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.className("ql-italic")).click();
			System.out.println("------Italic button clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.className("ql-underline")).click();
			System.out.println("------Under line button clicked ---->>");
			Thread.sleep(3000);
			
			Pagedescription.click();
			Thread.sleep(3000);
		
			JavascriptExecutor js21 = (JavascriptExecutor) driver;
			js21.executeScript("arguments[0].click();", driver.findElement(By.className("ql-image")));

			robot.setAutoDelay(2000);

			StringSelection stringselecton122 = new StringSelection("C:\\Appmaker Automation\\Article Fullround_With_page_creation_changes\\Images\\Comic imges\\Comic7.jpg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton122, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----Browse Image button clicked and image uploaded---->>");
			Thread.sleep(4000);
			
	// From below code Video is added for the page description ----------------------------------------------------------------------------------
			
			driver.findElement(By.cssSelector("ng-quill-editor[name='editorText'] .ql-video")).click();
			System.out.println("------Add video url icon clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector("ng-quill-editor[name='editorText'] .ql-tooltip input[type='text']")).sendKeys("https://www.youtube.com/watch?v=49RZx5tUKM4");
			System.out.println("------video url entered ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.id("make_compulsory_question")).click();
			System.out.println("-----Compulsary Question selected ---->>");
			
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector(".automation-create-page-btn-cancel:nth-child(2) > .ng-scope")).click();
			System.out.println("------Save button clicked ---->>");
			Thread.sleep(3000);
			
			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			WebElement addquestion01 = driver.findElement(By.name("add_question_btn"));
			js7.executeScript("arguments[0].scrollIntoView();", addquestion01);
			Thread.sleep(4000);
		
			WebElement addquestion2 = driver.findElement(By.name("add_question_btn"));
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", addquestion2); 
			Thread.sleep(5000);
			
		// verify questions in form delete function
			
			driver.findElement(By.name("Response_Type")).click();
			System.out.println("------ResponeType dropdown selected  ---->>");
			Thread.sleep(6000);
			
			List<WebElement> responsevalue2 = driver.findElements(By.className("auto-sel-opt-response-type"));
			 responsevalue2.get(0).click();
			 System.out.println("------Type clicked---->>");
			 Thread.sleep(2000);
			
			
			WebElement formquestion = driver.findElement(By.cssSelector(".ql-editor"));
			formquestion.click();
			formquestion.sendKeys("Which is the most appropriate action for obtaining consent?");
			System.out.println("-----Second question added ---->>");
			Thread.sleep(4000);
		
			driver.findElement(By.id("make_compulsory_question")).click();
			System.out.println("-----Compulsary Question selected ---->>");
			
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector(".automation-create-page-btn-cancel:nth-child(2) > .ng-scope")).click();
			System.out.println("------Save button clicked ---->>");
			Thread.sleep(3000);
			
			JavascriptExecutor js9 = (JavascriptExecutor) driver;
			WebElement addquestion02 = driver.findElement(By.name("add_question_btn"));
			js9.executeScript("arguments[0].scrollIntoView();", addquestion02);
			Thread.sleep(4000);
		
			WebElement addquestion3 = driver.findElement(By.name("add_question_btn"));
			JavascriptExecutor js10 = (JavascriptExecutor) driver;
			js10.executeScript("arguments[0].click();", addquestion3); 
			Thread.sleep(5000);
			
		// verify questions in form delete function
			
			driver.findElement(By.name("Response_Type")).click();
			System.out.println("------ResponeType dropdown selected  ---->>");
			Thread.sleep(6000);
			
			List<WebElement> responsevalue = driver.findElements(By.className("auto-sel-opt-response-type"));
			 responsevalue.get(1).click();
			 System.out.println("------MCQ clicked---->>");
			 Thread.sleep(2000);
			
			 WebElement formquestion1 = driver.findElement(By.cssSelector(".ql-editor"));
			formquestion1.click();
			formquestion1.sendKeys("How often do you conduct surveys?");
			System.out.println("-----Third question added ---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.id("make_compulsory_question")).click();
			System.out.println("-----Compulsary Question selected ---->>");
			Thread.sleep(3000);
			
			WebElement addoption = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[2]/textarea[1]"));
			addoption.click();
			addoption.sendKeys("Daily");
			System.out.println("-----Option 1 added ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.name("add_new_option_btn")).click();
			System.out.println("-----Add new option selected ---->>");
			Thread.sleep(3000);
			
			WebElement addoption1 = driver.findElement(By.xpath("//tbody/tr[2]/td[1]/div[2]/textarea[1]"));
			addoption1.click();
			addoption1.sendKeys("Weekly");
			System.out.println("-----Option 2 added ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector(".automation-create-page-btn-cancel:nth-child(2) > .ng-scope")).click();
			System.out.println("------Save button clicked ---->>");
			Thread.sleep(3000);
			
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			WebElement addquestion04 = driver.findElement(By.name("add_question_btn"));
			js11.executeScript("arguments[0].scrollIntoView();", addquestion04);
			Thread.sleep(4000);
		
			WebElement addquestion5 = driver.findElement(By.name("add_question_btn"));
			JavascriptExecutor js12 = (JavascriptExecutor) driver;
			js12.executeScript("arguments[0].click();", addquestion5); 
			Thread.sleep(5000);
			
			driver.findElement(By.name("Response_Type")).click();
			System.out.println("------ResponeType dropdown selected  ---->>");
			Thread.sleep(6000);
			
			List<WebElement> responsevalue3 = driver.findElements(By.className("auto-sel-opt-response-type"));
			 responsevalue3.get(2).click();
			 System.out.println("-----Date/Time clicked---->>");
			 Thread.sleep(2000);
			
			
			
			 driver.findElement(By.name("resultsType")).click();
			 System.out.println("------Result Type clicked---->>");
			 Thread.sleep(2000);
			 
			 List<WebElement> resulttype1 = driver.findElements(By.className("md-select-menu-container"));
			 resulttype1.get(1).click();
			 System.out.println("------Date Only selected---->>");
			 Thread.sleep(2000);
			
			 WebElement formquestion3 = driver.findElement(By.cssSelector(".ql-editor"));
				formquestion3.click();
				formquestion3.sendKeys("How many bones are fractured in the hand x-ray shown?");
				System.out.println("-----Fourth question added ---->>");
				Thread.sleep(4000);
				
				driver.findElement(By.id("make_compulsory_question")).click();
				System.out.println("-----Compulsary Question selected ---->>");
				Thread.sleep(3000);
			 
				driver.findElement(By.cssSelector(".automation-create-page-btn-cancel:nth-child(2) > .ng-scope")).click();
				System.out.println("------Save button clicked ---->>");
				Thread.sleep(3000);
				
			driver.findElement(By.className("automation-create-page-btn-publish")).click();
			Thread.sleep(2000);
			System.out.println("------Publish button clicked---->>");

			String actual_msg2 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2 = "Your article has successfully been published ";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}

			Thread.sleep(4000);
		
		}
		
		@Test(priority = 16)//priority = 16
		public void EditForms() throws InterruptedException, FileNotFoundException {
			
			driver.findElement(By.className("auto-link-page-edit")).click();
			System.out.println("------Edit link selected ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------next_btn ticked---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("next_btn")).click();
			System.out.println("------next_btn ticked---->>");
			Thread.sleep(4000);
			
			WebElement formtitle = driver.findElement(By.className("md-dialog-header"));
			String text = formtitle.getText();
			System.out.println(text);
			
			driver.findElement(By.name("Form_Title")).clear();
			System.out.println("----Form name cleared---->>");
			Thread.sleep(4000);
			
			driver.findElement(By.name("Form_Title")).sendKeys("Form Edited 02");
			System.out.println("----Form name cleared---->>");
			Thread.sleep(4000);		
	
			driver.findElement(By.className("auto-cb-qsel")).click();
			System.out.println("------Checkbox selected ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.name("delete_question_btn")).click();
			System.out.println("------Delete button selected ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.name("add_question_btn")).click();
			System.out.println("------Add Question selected  ---->>");
			
			
			driver.findElement(By.name("Response_Type")).click();
			System.out.println("------ResponeType dropdown selected  ---->>");
			Thread.sleep(6000);
			
			List<WebElement> responsevalue3 = driver.findElements(By.className("auto-sel-opt-response-type"));
			responsevalue3.get(2).click();
			System.out.println("-----Date/Time clicked---->>");
			Thread.sleep(2000);
			
			 driver.findElement(By.name("resultsType")).click();
			 System.out.println("------Result Type clicked---->>");
			 Thread.sleep(2000);
			 
			 List<WebElement> resulttype1 = driver.findElements(By.className("md-select-menu-container"));
			 resulttype1.get(1).click();
			 System.out.println("------Time Only selected---->>");
			 Thread.sleep(2000);
			 
			 WebElement formquestion3 = driver.findElement(By.cssSelector(".ql-editor"));
			formquestion3.click();
			formquestion3.sendKeys("How did you hear about this position?");
			System.out.println("-----Fourth question added ---->>");
			Thread.sleep(4000);
				
			driver.findElement(By.id("make_compulsory_question")).click();
			System.out.println("-----Compulsary Question selected ---->>");
			Thread.sleep(3000);
			 
			driver.findElement(By.cssSelector(".automation-create-page-btn-cancel:nth-child(2) > .ng-scope")).click();
			System.out.println("------Save button clicked ---->>");
			Thread.sleep(3000);
			
			driver.findElement(By.name("update_btn")).click();
			Thread.sleep(2000);
			System.out.println("------Update button clicked---->>");
		}
		
		


		@Test(priority = 17 ) // (priority=6)
		public void From_Manage_pages_Duplcate_pages() throws Exception {
			
			List<WebElement> b3 = driver.findElements(By.name("articleselect"));
			b3.get(1).click();
			System.out.println("------article selected---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.name("Duplicate_btn")).click();
			Thread.sleep(2000);
			System.out.println("------Duplicate_btn clicked---->>");
			
		}
		
		//-----------------------------------------------------------------************************************************-----------------------
		@Test(priority = 18 ) // (priority=6)
		public void Delete_Page() throws Exception {
			
			List<WebElement> b3 = driver.findElements(By.name("articleselect"));
			b3.get(2).click();
			System.out.println("------article selected---->>");
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector(".auto-btn-managepage-delete")).click();
			Thread.sleep(4000);
			System.out.println("------delete button clicked---->>");
			
			List<WebElement> confirm = driver.findElements(By.className("me-default-button"));
			confirm.get(1).click();
			Thread.sleep(2000);
			System.out.println("------confirm button clicked---->>");
			
			Select dropdown = new Select(driver.findElement(By.className("automation-manage-pages-sel-status")));
			dropdown.selectByVisibleText("To be published");
			System.out.println("------Search from status ---->>");
			Thread.sleep(3000);

			driver.findElement(By.cssSelector(".auto-btn-managepage-cancel")).click();
			Thread.sleep(2000);
			System.out.println("------Cancel_btn clicked---->>");

			Thread.sleep(6000);
			
		}
		
		//-------------------------------------------------------------------------*********************************************888-------------


		@Test(priority = 19 ) // (priority=6)
		public void VerifyAppDetailsPages() throws Exception {
			

			List<WebElement> b = driver.findElements(By.name("Inner_Pages"));
			Thread.sleep(1000);
			b.get(4).click(); // can change inside page inner pages
			System.out.println("----App details button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("address")).clear();
			driver.findElement(By.name("address")).sendKeys("213/1 kurunegala");
			Thread.sleep(2000);
			System.out.println("----ADDRESS entered---->>");

			driver.findElement(By.name("telPhone")).clear();
			driver.findElement(By.name("telPhone")).sendKeys("0776567766767");
			Thread.sleep(2000);
			System.out.println("----TELEPHONE entered---->>");

			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("saku@gmail.com");
			Thread.sleep(2000);
			System.out.println("----EMAIL entered---->>");

			driver.findElement(By.name("website")).clear();
			driver.findElement(By.name("website")).sendKeys("http/www.test.com");
			Thread.sleep(2000);
			System.out.println("----Website entered---->>");

			driver.findElement(By.name("next_btn")).click();
			System.out.println("----Next button clicked---->>");
			Thread.sleep(2000);

			String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect = "Contact us updated successfully";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Test Case Failed = " + actual_msg);
			}

			Thread.sleep(5000);

			driver.findElement(By.name("termsAndCondition")).clear();
			driver.findElement(By.name("termsAndCondition")).sendKeys("In these Website Standard Terms and Conditions, ?Your Content? shall mean any audio, video text, images or other material you choose to display on this Website. By displaying Your Content, you grant Company Name a non-exclusive, worldwide irrevocable, sub licensable license to use, reproduce, adapt, publish, translate and distribute it in any and all media.\r\n"
							+ "\r\n"
							+ "Your Content must be your own and must not be invading any third-party's rights. Company Name reserves the right to remove any of Your Content from this Website at any time without notice.");
			Thread.sleep(2000);
			System.out.println("----TERMS AND CONDITIONS entered---->>");

			driver.findElement(By.name("privacyPolicy")).clear();
			driver.findElement(By.name("privacyPolicy")).sendKeys("Third-party ad servers or ad networks uses technologies like cookies, JavaScript, or Web Beacons that are used in their respective advertisements and links that appear on Website Name, which are sent directly to users' browser. They automatically receive your IP address when this occurs. These technologies are used to measure the effectiveness of their advertising campaigns and/or to personalize the advertising content that you see on websites that you visit.");
			System.out.println("----PRIVACY POLICY entered---->>");
			Thread.sleep(2000);

			driver.findElement(By.name("next_btn1")).click();
			System.out.println("----Next button clicked---->>");
			Thread.sleep(2000);

			String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1 = "Policies and Terms successfully updated.";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Test Case Failed = " + actual_msg1);
			}

			Thread.sleep(5000);

			driver.findElement(By.name("header")).clear();
			driver.findElement(By.name("header")).sendKeys("Testing now");
			System.out.println("----HEADING entered---->>");
			Thread.sleep(2000);

			driver.findElement(By.name("content")).clear();
			driver.findElement(By.name("content")).sendKeys("One small touch to take away from Toyota is considering putting people front and center, rather than products, on these pages (they?re about the people that make up your company, as much as they?re about what you make or sell, after all).\r\n"
							+ "\r\n"
							+ "Plus, the simple navigation bar works well to make it easy to move around the page, too:");
			Thread.sleep(2000);
			System.out.println("----Content entered---->>");

			driver.findElement(By.name("finish_btn")).click();
			Thread.sleep(2000);
			System.out.println("----Finish button clicked---->>");

			String actual_msg2 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2 = "About us updated";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}

			Thread.sleep(7000);

			driver.findElement(By.name("back_arrow")).click();
			Thread.sleep(5000);
		
		}

		
		@Test(priority = 20 ) // (priority=7)
		public void AddLogo() throws Exception {

			driver.findElement(By.name("design_btn")).click();
			System.out.println("----Design button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("Add_logo_btn")).click();
			System.out.println("----Logo button clicked---->>");
			Thread.sleep(5000);
			
	//Check Logo validation -----------------------------------------------------------------------
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("angular.element(document.getElementById('fileInput')).scope().uploadLogoToArea();"); 
			System.out.println("----Call JS function uploadLogoToArea---->>");
			Thread.sleep(5000);

			driver.findElement(By.id("fileInput")).sendKeys("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\Comic imges\\Comic12.png");

			Thread.sleep(2000);

			String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1 = "Image should be less than 250x150 px";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Test Case Failed = " + actual_msg1);
			}
				Thread.sleep(4000);

	// Image correct uploading

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("angular.element(document.getElementById('fileInput')).scope().uploadLogoToArea();"); 
			System.out.println("----Call JS function uploadLogoToArea---->>");
			Thread.sleep(5000);

			driver.findElement(By.id("fileInput")).sendKeys("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\LOGO IMAGE\\LOGOIMAGE3.png");

			Thread.sleep(10000);

			driver.findElement(By.name("Upload_img")).click();
			System.out.println("------upload image button clicked---->>");

			String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect = "Logo has been uploaded successfully";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Test Case Failed = " + actual_msg);
			}

			Thread.sleep(7000);

			driver.findElement(By.name("close_btn")).click();
			Thread.sleep(2000);
			
		}

		@Test(priority = 21 ) // (priority=8)
		public void AddFAVIcon() throws Exception {
		
			
			driver.findElement(By.name("Add_fav_icon_btn")).click();
			System.out.println("----Add FAV Icon button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("delete_fav")).click();
			System.out.println("----Uploaded FAV Icon removed---->>");
			Thread.sleep(5000);
			
	//Check fav icon validations 
			
			driver.findElement(By.name("Upload_fav")).sendKeys("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\LOGO_IMAGE\\LOGOIMAGE16.png");
			System.out.println("----FAV Icon upoaded---->>");
			Thread.sleep(5000);

			String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1 = "Icon should be 32x32 pixel ico file";

			if (actual_msg1.contains(expect1)) {
				System.out.println("Validation passed = " + actual_msg1);
			} else {
				System.out.println("Validation message is incorrect = " + actual_msg1);
			}

			Thread.sleep(7000);
			
	//Upload correct Fav Icon 		
		

			driver.findElement(By.name("Upload_fav")).sendKeys("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\UPLOAD_FAV_ICON\\FAVICON2.ico");
			System.out.println("----FAV Icon upoaded---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("save_btn")).click();
			System.out.println("----Save button clicked---->>");
			Thread.sleep(5000);

			String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect = "FAV Icon uploaded Successfully!";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Validation message is incorrect = " + actual_msg);
			}

			Thread.sleep(7000);

			driver.findElement(By.name("cancel_btn")).click();
			System.out.println("----Cancel button clicked and Pop up closed---->>");
			Thread.sleep(4000);
			

		}

		@Test(priority = 22 ) // (priority=9)
		public void ChangeLookAndFeel() throws Exception {
			

			driver.findElement(By.name("Look_And_feel_btn")).click();
			System.out.println("----Look & Feel button clicked---->>");
			Thread.sleep(5000);

			// App Background color changing process

			driver.findElement(By.name("background_color")).clear();
			Thread.sleep(2000);

			driver.findElement(By.name("background_color")).sendKeys("rgba(80,216,26,1)");
			Thread.sleep(2000);

			driver.findElement(By.name("background_color")).click();
			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			System.out.println("----Color name entered for App Background---->>");

			String actual_msg = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect = "Background Color Successfully Updated";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Test Case Failed = " + actual_msg);
			}

			Thread.sleep(5000);

			// App Navigation color changing process

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/ui-view/div/div[1]/obl-framework/div/obl-menu/div/ul/obl-menu-group[1]/div/ul/obl-menu-group/div/ul/div/div/div[3]/div[2]/h2"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(3000);

			driver.findElement(By.name("Navigationbackcolor")).clear();
			Thread.sleep(2000);

			driver.findElement(By.name("Navigationbackcolor")).sendKeys("rgba(171,216,228,1)");
			Thread.sleep(2000);
			System.out.println("---Navigation color name entered---->>");

			driver.findElement(By.name("Navigationbackcolor")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			Thread.sleep(2000);

	////////////////////////////////////////---------------- Navigation Font Color process-----------------------//////////////////////////////////////////////

			driver.findElement(By.name("navigationFontcolor")).clear();
			Thread.sleep(2000);

			driver.findElement(By.name("navigationFontcolor")).sendKeys("rgba(237,17,62,1)");
			Thread.sleep(2000);
			System.out.println("----Color name entered for Navigation Font Color---->>");

			driver.findElement(By.name("navigationFontcolor")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			System.out.println("----Navigation font color menu closed---->>");

			String actual_msg2 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect2 = "Navigation Font Color Successfully Updated";

			if (actual_msg2.contains(expect2)) {
				System.out.println("Validation passed = " + actual_msg2);
			} else {
				System.out.println("Test Case Failed = " + actual_msg2);
			}

			Thread.sleep(5000);
			
	//////////////////////////////////////////////////-----------------Header Font ----------------------/////////////////////////////////////////////////

			Select dropdown = new Select(driver.findElement(By.className("automation-looknfeel-select-header-font")));
			dropdown.selectByVisibleText("Alfaslab One");
			System.out.println("------Header Font dropdown clicked ---->>");
			Thread.sleep(3000);
			
			String actual_msg3 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect3 = "Header Font Successfully Updated";

			if (actual_msg3.contains(expect3)) {
				System.out.println("Validation passed = " + actual_msg3);
			} else {
				System.out.println("Test Case Failed = " + actual_msg3);
			}
			
			Thread.sleep(4000);
			
	//////////////////////////////////////////////////-----------------Header Font Weight ----------------------/////////////////////////////////////////////////

			
			Select dropdown1 = new Select(driver.findElement(By.className("automation-looknfeel-select-header-font-weight")));
			dropdown1.selectByVisibleText("bold");
			System.out.println("----Header Font Weight dropdown clicked---->>");
			Thread.sleep(4000);
			
			String actual_msg4 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect4 = "Header Font Weight Successfully Updated";

			if (actual_msg4.contains(expect4)) {
				System.out.println("Validation passed = " + actual_msg4);
			} else {
				System.out.println("Test Case Failed = " + actual_msg4);
			}
			
			Thread.sleep(4000);
			
	//////////////////////////////////////////////////-----------------Header Font----------------------/////////////////////////////////////////////////

			
			driver.findElement(By.className("automation-looknfeel-text-header-font-color")).clear();
			Thread.sleep(2000);

			driver.findElement(By.className("automation-looknfeel-text-header-font-color")).sendKeys("rgba(34,33,236,1)");
			Thread.sleep(2000);
			System.out.println("----Header Font Color entered---->>");

			driver.findElement(By.className("automation-looknfeel-text-header-font-color")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			System.out.println("----Header Font Color menu closed---->>");

			String actual_msg5 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect5 = "Header Font Color Successfully Updated";

			if (actual_msg5.contains(expect5)) {
				System.out.println("Validation passed = " + actual_msg5);
			} else {
				System.out.println("Test Case Failed = " + actual_msg5);
			}
			
			Thread.sleep(4000);
			
	//////////////////////////////////////////////////-----------------Content Font----------------------/////////////////////////////////////////////////
			
			Select dropdown2 = new Select(driver.findElement(By.className("automation-looknfeel-select-content-font")));
			dropdown2.selectByVisibleText("Poppins");
			System.out.println("----Content Font dropdown clicked---->>");
			Thread.sleep(4000);	

			String actual_msg6 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect6 = "Content Font Successfully Updated";

			if (actual_msg6.contains(expect6)) {
				System.out.println("Validation passed = " + actual_msg6);
			} else {
				System.out.println("Test Case Failed = " + actual_msg6);
			}
			
			Thread.sleep(4000);
			
	//////////////////////////////////////////////////-----------------Content Font Weight----------------------/////////////////////////////////////////////////

			Select dropdown3 = new Select(driver.findElement(By.className("automation-looknfeel-select-content-font-weight")));
			dropdown3.selectByVisibleText("bolder");
			System.out.println("----Content Font Weight dropdown clicked---->>");
			Thread.sleep(4000);

			String actual_msg7 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect7 = "Content Font Weight Successfully Updated";

			if (actual_msg7.contains(expect7)) {
				System.out.println("Validation passed = " + actual_msg7);
			} else {
				System.out.println("Test Case Failed = " + actual_msg7);
			}
			
			Thread.sleep(4000);
			
	//////////////////////////////////////////////////-----------------Content Font Color----------------------/////////////////////////////////////////////////
		
			driver.findElement(By.name("content_font")).clear();
			Thread.sleep(2000);

			driver.findElement(By.name("content_font")).sendKeys("rgba(39,177,228,1)");
			Thread.sleep(2000);
			System.out.println("----Content Font Color entered---->>");

			driver.findElement(By.name("content_font")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			System.out.println("----Header Font Color menu closed---->>");

			String actual_msg8 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect8 = "Content Font Color Successfully Updated";

			if (actual_msg8.contains(expect8)) {
				System.out.println("Validation passed = " + actual_msg8);
			} else {
				System.out.println("Test Case Failed = " + actual_msg8);
			}
			
			Thread.sleep(4000);
			
			
	//////////////////////////////////////////////////-----------------Footer Background Color----------------------/////////////////////////////////////////////////

			driver.findElement(By.name("footer_back_color")).clear();
			Thread.sleep(2000);

			driver.findElement(By.name("footer_back_color")).sendKeys("rgba(67,42,42,1)");
			Thread.sleep(2000);
			System.out.println("----Footer Background Color entered---->>");

			driver.findElement(By.name("footer_back_color")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			System.out.println("----Footer Background Color menu closed---->>");

			String actual_msg9 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect9 = "Footer Background Color Successfully Updated";

			if (actual_msg9.contains(expect9)) {
				System.out.println("Validation passed = " + actual_msg9);
			} else {
				System.out.println("Test Case Failed = " + actual_msg9);
			}
			
			Thread.sleep(4000);
			
	//////////////////////////////////////////////////-----------------Footer header/icon Color----------------------/////////////////////////////////////////////////
			

			driver.findElement(By.name("footer_header_color")).clear();
			Thread.sleep(2000);

			driver.findElement(By.name("footer_header_color")).sendKeys("rgba(238,252,53,1)");
			Thread.sleep(2000);
			System.out.println("----footer_header_color entered---->>");

			driver.findElement(By.name("footer_header_color")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".colorpicker-visible .close")).click();
			System.out.println("----footer_header_color menu closed---->>");

			String actual_msg10 = driver.findElement(By.className("toast-message")).getAttribute("innerHTML");
			String expect10 = "Footer Header Font Color Successfully Updated";

			if (actual_msg10.contains(expect10)) {
				System.out.println("Validation passed = " + actual_msg10);
			} else {
				System.out.println("Test Case Failed = " + actual_msg10);
			}
			
			Thread.sleep(5000);
		
			driver.findElement(By.cssSelector(".md-sub-menu:nth-child(3) img")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .obl-subitem-section > .obl-menu-back > img")).click();
		    Thread.sleep(3000);
		    
			
		}
		

		@Test(priority = 23 ) // (priority=10)
		public void Report_A_Bug() throws Exception {
			
			driver.findElement(By.name("report_bug_btn")).click();
			System.out.println("Report a bug cliked ");
			Thread.sleep(2000);
			
			driver.findElement(By.name("description")).sendKeys("This is a test please ignore");
			System.out.println("description entered ");
			Thread.sleep(2000);
			
			driver.findElement(By.name("img1")).sendKeys("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\HI-RES_ICON\\HI-RESICON14.png");
			System.out.println("Image uploaded");
			Thread.sleep(2000);
			

			driver.findElement(By.name("report_btn")).click();
			System.out.println("Report button clicked");
			Thread.sleep(5000);
			
		}

		@Test(priority = 24 ) // (priority=10)
		public void VerifyPublishSection() throws Exception {

			// For this if we are creating free app we need to make all the Categories free
			// other wise it will be a paid app and you can't select "FREE APP (NOTE : APP
			// CREATOR WILL BE CHARGED )" checkbox
			// below process is for free app publishing process

			


			driver.findElement(By.name("publish_btn")).click();
			System.out.println("----Publish button clicked---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("submit_for_approvals")).click();
			System.out.println("----Submit for Approvals clicked---->>");
			Thread.sleep(5000);

			//driver.findElement(By.name("Free_app_Checkbox")).click();
			//System.out.println("----FREE APP (NOTE : APP CREATOR WILL BE CHARGED ) check box clicked---->>");
			//Thread.sleep(5000);

			driver.findElement(By.name("shortDescription")).sendKeys("Test 123");
			System.out.println("----Short description entered---->>");
			Thread.sleep(5000);

			driver.findElement(By.name("fullDescription")).sendKeys("Dilini");
			System.out.println("----Full description entered---->>");
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.name("thumbPic1"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(7000);

			Robot robot = new Robot();

			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.name("thumbPic1"));
			action.moveToElement(we).moveToElement(driver.findElement(By.name("hI-rES_ICON_btn"))).click().build().perform();

			robot.setAutoDelay(2000);
			StringSelection stringselecton = new StringSelection("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\HI-RES_ICON\\HI-RESICON8.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);

			System.out.println("----HI-RES ICON entered---->>");
			Thread.sleep(7000);

			Actions action1 = new Actions(driver);
			WebElement we1 = driver.findElement(By.name("thumbPic2"));
			action1.moveToElement(we1).moveToElement(driver.findElement(By.name("FEATURE_GRAPHIC_btn"))).click().build().perform();

			robot.setAutoDelay(1000);

			StringSelection stringselecton1 = new StringSelection("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\FEATURE_GRAPHIC\\FEATUREGRAPHIC12.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton1, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----FEATURE GRAPHIC image entered---->>");
			Thread.sleep(7000);

			Actions action2 = new Actions(driver);

			WebElement a1 = driver.findElement(By.name("thumbPic3"));
			action2.moveToElement(a1).moveToElement(driver.findElement(By.name("SPLASH_SCREEN_btn"))).click().build().perform();

			robot.setAutoDelay(2000);

			StringSelection stringselecton2 = new StringSelection("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\Images\\Splash_screen\\SPLASHSCREEN6.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselecton2, null);
			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.setAutoDelay(2000);
			System.out.println("----SPLASH SCREEN image entered---->>");
			Thread.sleep(7000);
			
			int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
			
			String generatedString = buffer.toString();
			
			WebElement App = driver.findElement(By.name("keyword"));
			App.sendKeys(generatedString);
			System.out.println("----keyword entered---->>");
			Thread.sleep(4000);	 
				
			driver.findElement(By.name("select_port")).click();
			System.out.println("----select_port clicked---->>");
			Thread.sleep(4000);	 
										
			driver.findElement(By.name("port_no")).click();
			System.out.println("----port_no clicked---->>");
				Thread.sleep(4000);	

			driver.findElement(By.name("PREVENT_SCREENSHOTS_checkbox")).click();
			System.out.println("----PREVENT SCREENSHOTS check box checked---->>");
			Thread.sleep(4000);

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebElement Element1 = driver.findElement(By.name("PREVENT_SCREENSHOTS_checkbox"));
			js1.executeScript("arguments[0].scrollIntoView();", Element1);
			Thread.sleep(2000);

			driver.findElement(By.name("next_btn")).click();
			System.out.println("----Next button entered---->>");
					Thread.sleep(4000);	
					
			String actual_msg=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect="General information has been added successfully";
				
			if(actual_msg.contains(expect))
			{
				System.out.println("Validation passed = "+ actual_msg );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg);
			}
					
			Thread.sleep(5000);
			
			
		}

			@Test(priority = 25 ) // (priority=10)
			public void VerifyConfigurationSection() throws Exception {
			
			List<WebElement> A = driver.findElements(By.className("automation-op-config-cb-op-enabled"));
			A.get(0).click();
			System.out.println("----Enabled checkbox Clicked for dialog---->>");
			Thread.sleep(4000);	
			
			List<WebElement> b = driver.findElements(By.name("txtAccountNumber"));
			b.get(0).sendKeys("1");
					
			Thread.sleep(2000);
			
			Select RenewalD = new Select(driver.findElement(By.className("op-config-select")));
			Thread.sleep(2000);
			RenewalD.selectByVisibleText("DAILY");
			System.out.println("----Daily Clicked---->>");
			Thread.sleep(2000);	

			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(2000);	
			
			String actual_msg1=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect1="Please enter a price between 3 and 10 for DIALOG";
				
			if(actual_msg1.contains(expect1))
			{
				System.out.println("Validation passed = "+ actual_msg1 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg1);
			}

			Thread.sleep(4000);
			
			Select RenewalM = new Select(driver.findElement(By.className("op-config-select")));
			Thread.sleep(2000);
			RenewalM.selectByVisibleText("MONTHLY");
			System.out.println("----MONTHLY Clicked---->>");
			Thread.sleep(2000);		
			
			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(2000);
			

			String actual_msg2=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect2="Please enter a price between 60 and 500 for DIALOG";
				
			if(actual_msg2.contains(expect2))
			{
				System.out.println("Validation passed = "+ actual_msg2 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg2);
			}

			Thread.sleep(4000);
			
			Select RenewalW = new Select(driver.findElement(By.className("op-config-select")));
			Thread.sleep(2000);
			RenewalW.selectByVisibleText("WEEKLY");
			System.out.println("----WEEKLY Clicked---->>");
			Thread.sleep(2000);	
			
			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(2000);

			String actual_msg3=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect3="Please enter a price between 15 and 250 for DIALOG";
				
			if(actual_msg3.contains(expect3))
			{
				System.out.println("Validation passed = "+ actual_msg3 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg3);
			}

			Thread.sleep(4000);
			
			List<WebElement> a = driver.findElements(By.name("txtAccountNumber"));
			a.get(0).clear();
			
			Thread.sleep(2000);
			
			List<WebElement> d = driver.findElements(By.name("txtAccountNumber"));
			d.get(0).sendKeys("15");
			
			Thread.sleep(4000);
			
	//----------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------		
			
			List<WebElement> B = driver.findElements(By.className("automation-op-config-cb-op-enabled"));
			B.get(1).click();
			System.out.println("----Enabled checkbox Clicked for hutch---->>");
			Thread.sleep(4000);	

			
			List<WebElement> c = driver.findElements(By.name("txtAccountNumber"));
			c.get(1).sendKeys("1");
					
			Thread.sleep(2000);

			Select RenewalDd = new Select(driver.findElement(By.cssSelector(".auto-op-HUTCH .op-config-select")));
			Thread.sleep(2000);
			RenewalDd.selectByVisibleText("DAILY");
			System.out.println("----Daily Clicked---->>");
			Thread.sleep(2000);		

			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(4000);	
			
			String actual_msg4=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect4="Please enter a price between 3 and 10 for HUTCH";
				
			if(actual_msg4.contains(expect4))
			{
				System.out.println("Validation passed = "+ actual_msg4 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg4);
			}

			Thread.sleep(4000);
			

			Select RenewalDm = new Select(driver.findElement(By.cssSelector(".auto-op-HUTCH .op-config-select")));
			Thread.sleep(2000);
			RenewalDm.selectByVisibleText("MONTHLY");
			System.out.println("----Monthly Clicked---->>");
			Thread.sleep(2000);		

			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(4000);	
			
			String actual_msg6=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect6="Please enter a price between 60 and 500 for HUTCH";
				
			if(actual_msg6.contains(expect6))
			{
				System.out.println("Validation passed = "+ actual_msg6 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg6);
			}

			Thread.sleep(4000);
			
			
			Select RenewalWw = new Select(driver.findElement(By.cssSelector(".auto-op-HUTCH .op-config-select")));
			Thread.sleep(2000);
			RenewalWw.selectByVisibleText("WEEKLY");
			System.out.println("----WEEKLY Clicked---->>");
			Thread.sleep(2000);	

			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(4000);	
			
			String actual_msg7=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect7="Please enter a price between 15 and 250 for HUTCH";
				
			if(actual_msg7.contains(expect7))
			{
				System.out.println("Validation passed = "+ actual_msg7 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg7);
			}

			Thread.sleep(4000);
			
			

			List<WebElement> cc = driver.findElements(By.name("txtAccountNumber"));
			cc.get(1).clear();
			
			Thread.sleep(2000);
			
			List<WebElement> ccc = driver.findElements(By.name("txtAccountNumber"));
			ccc.get(1).sendKeys("15");
			
			/*
			
			driver.findElement(By.xpath("//*[@id=\"tab-content-113\"]/div/div[2]/form/table/tbody/tr[2]/td[4]/md-checkbox/div[1]")).click();
			System.out.println("----Enabled checkbox Clicked for Hutch---->>");
			Thread.sleep(4000);	
			
			List<WebElement> aa = driver.findElements(By.name("txtAccountNumber"));
			aa.get(2).sendKeys("1");
					
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"tab-content-113\"]/div/div[2]/form/table/tbody/tr[2]/td[3]/div/select")).click();
			System.out.println("----Renewal Interval Clicked---->>");
			Thread.sleep(4000);	

			driver.findElement(By.xpath("//*[@id=\"tab-content-113\"]/div/div[2]/form/table/tbody/tr[2]/td[3]/div/select/option[2]")).click();
			System.out.println("----Daily Clicked---->>");
			Thread.sleep(2000);	

			driver.findElement(By.xpath("//*[@id=\"tab-content-113\"]/div/div[2]/form/div/div/div/button[2]")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(4000);	
			
			String actual_msg3=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect3="Please enter a price between 3 and 10 for AIRTEL";
				
			if(actual_msg3.contains(expect3))
			{
				System.out.println("Validation passed = "+ actual_msg3 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg3);
			}

			Thread.sleep(4000);
			
			List<WebElement> aaa = driver.findElements(By.name("txtAccountNumber"));
			aaa.get(2).clear();
			
			Thread.sleep(4000);
			
			List<WebElement> aa1 = driver.findElements(By.name("txtAccountNumber"));
			aa1.get(2).sendKeys("3"); */
			
			driver.findElement(By.className("automation-op-config-btn-save")).click();
			System.out.println("----Save btn Clicked---->>");
			Thread.sleep(2000);	
			
			String actual_msg5=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect5="Operators information has been added successfully";
				
			if(actual_msg5.contains(expect5))
			{
				System.out.println("Validation passed = "+ actual_msg5 );
			}
			else
			{
				System.out.println("Test Case Failed = "+ actual_msg5);
			} 

			
		}

		@Test(priority = 26 ) // (priority=10)
		public void web_config() throws Exception {
			
			
			driver.findElement(By.name("website_config")).click();
			Thread.sleep(2000);
			System.out.println("website_config clicked");
			
			driver.findElement(By.className("automation-web-config-cb-list")).click();
			System.out.println("list PWA on the Appmaker Store checkbox clicked");
			Thread.sleep(2000);

			driver.findElement(By.name("save_btn")).click();
			Thread.sleep(1000);
			System.out.println("save_btn clicked");

			String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect = "Your request has been submitted successfully. You will receive an email confirmation on approval";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Test Case Failed = " + actual_msg);
			}

			Thread.sleep(9000);
			// Click status and submit for approval

			driver.findElement(By.name("Profile_View1")).click();
			System.out.println("Profile button clicked = Passed");
			Thread.sleep(5000);

			driver.findElement(By.name("LogOut")).click();
			System.out.println("Successfully logged out ");
			Thread.sleep(7000);

		

		}
		
		
	//****///////////////////////////////////////////---------Reject_App_from_super_Admin-------------///////////////////////////////////////////////////////*****/
		
		
		@Test(priority = 27 ) // (priority=10)
		public void Reject_App_from_super_Admin() throws Exception {

		
			
			driver.findElement(By.name("email")).sendKeys("su@simatosolutions.com");
			Thread.sleep(2000);
			System.out.println("Email entered = Passed");

			driver.findElement(By.name("password")).sendKeys("#Appmaker123");
			System.out.println("Password entered = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("submitbtn")).click();
			System.out.println("Login button clicked = Passed");
			Thread.sleep(8000);
			
			List<WebElement> x = driver.findElements(By.className("auto-login-dialog-btn-yes"));

			if (x.size() > 0)
			{
			    x.get(0).click();
			}
			
			Thread.sleep(8000);

			File file1 = new File("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\src\\Article_Test\\textWrite.txt");
			FileReader fr = new FileReader(file1);
			BufferedReader reader = new BufferedReader(fr);

			String str = reader.readLine();


			driver.findElement(By.className("automation-home-text-search-app-details")).sendKeys(str);
			Thread.sleep(3000);
			
			System.out.println("app name = " +str);

			driver.findElement(By.className("automation-home-btn-manage")).click();
			System.out.println("----Manage_btn button clicked---->>");
			Thread.sleep(5000);

	//-----Need to check this 		
			
			driver.findElement(By.className("automation-op-app-sel-action-dialog")).click();
			System.out.println("----Action CATEGORY clicked---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.className("automation-op-app-sel-action-opt-dialog-rejected")).click();
			System.out.println("----Action CATEGORY reject selected---->>");
			Thread.sleep(5000);

			driver.findElement(By.className("automation-op-app-btn-apply-dialog")).click();
			System.out.println("Apply button clicked = Passed");
			Thread.sleep(10000);
			
			driver.findElement(By.className("automation-op-app-sel-action-hutch")).click();
			System.out.println("----Action CATEGORY clicked for hutch---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.className("automation-op-app-sel-action-opt-hutch-rejected")).click();
			System.out.println("----Action CATEGORY clicked for hutch---->>");
			Thread.sleep(5000);

			driver.findElement(By.className("automation-op-app-btn-apply-hutch")).click();
			System.out.println("Apply button clicked = Passed");
			Thread.sleep(10000);
			
			/*
			driver.findElement(By.xpath("//*[@id=\"mat-select-3\"]")).click();
			System.out.println("----Action CATEGORY clicked for Airtel---->>");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"mat-option-14\"]")).click();
			System.out.println("----Action CATEGORY rejected selected---->>");
			Thread.sleep(5000);

			driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-operator-approval/mat-dialog-content/table/tbody/tr[3]/td[4]/button")).click();
			System.out.println("Apply button clicked = Passed");
			Thread.sleep(10000);*/

			driver.findElement(By.className("automation-op-app-btn-close")).click();
			System.out.println("Close button clicked = Passed");
			Thread.sleep(7000);
			
			driver.findElement(By.className("automation-menu")).click();
			System.out.println("Main menu clicked");
			Thread.sleep(7000);
			
			driver.findElement(By.className("automation-home-link-logout")).click();
			System.out.println("Logout button clicked");
			Thread.sleep(7000);
			
			reader.close();

			
			
		}
			
		@Test(priority = 28 ) // (priority=10)
		public void Submit_For_Approve_App_Again() throws Exception {
			
			 
			 	driver.findElement(By.name("email")).sendKeys("sakunthalanfm@gmail.com");
				Thread.sleep(2000);
				System.out.println("Email entered = Passed");

				driver.findElement(By.name("password")).sendKeys("Saku@1234");
				System.out.println("Password entered = Passed");
				Thread.sleep(2000);

				driver.findElement(By.name("submitbtn")).click();
				System.out.println("Login button clicked = Passed");
				Thread.sleep(2000);
				
				

				String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
				String expect = "Login Successful";

				if (actual_msg.contains(expect)) {
					System.out.println("Validation passed = " + actual_msg);
				} else {
					System.out.println("Test Case Failed = " + actual_msg);
				}

				Thread.sleep(7000);

				List<WebElement> activeColumns = driver.findElements(By.name("Created_Apps"));
				Thread.sleep(1000);
				activeColumns.get(activeColumns.size() - 1).click();
				Thread.sleep(4000);
				
				driver.findElement(By.name("publish_btn")).click();
				System.out.println("----Publish button clicked---->>");
				Thread.sleep(5000);

				driver.findElement(By.name("Status")).click();
				System.out.println("----Status button clicked---->>");
				Thread.sleep(10000);

				driver.findElement(By.name("close_btn")).click();
				System.out.println("----Close button clicked---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.name("submit_for_approvals")).click();
				System.out.println("----submit_for_approvals button clicked---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.cssSelector("md-pagination-wrapper > .md-tab:nth-child(2) > .ng-scope")).click();
				System.out.println("----Operator configuration button clicked---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.className("automation-op-config-btn-save")).click();
				System.out.println("----Save button clicked---->>");
				Thread.sleep(5000);
			
			}
		
		@Test(priority = 29) // (priority=10)
		public void Login_Super_Admin_For_SubmitForConfig() throws Exception {
			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			Thread.sleep(4000);
			
			 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			 driver.switchTo().window(tabs.get(0)); //switches to new tab
			 driver.get("https://appmakercms.otenro.com/app/login");
				
				driver.findElement(By.name("email")).sendKeys("su@simatosolutions.com");
				Thread.sleep(2000);
				System.out.println("Email entered = Passed");

				driver.findElement(By.name("password")).sendKeys("#Appmaker123");
				System.out.println("Password entered = Passed");
				Thread.sleep(2000);

				driver.findElement(By.name("submitbtn")).click();
				System.out.println("Login button clicked = Passed");
				Thread.sleep(7000);

				File file1 = new File("C:\\Appmaker Automation\\Article Fullround Testing Process(Staging)Paid Apps\\src\\Article_Test\\textWrite.txt");
				FileReader fr = new FileReader(file1);
				BufferedReader reader = new BufferedReader(fr);

				String str = reader.readLine();

				driver.findElement(By.className("automation-home-text-search-app-details")).sendKeys(str);
				Thread.sleep(3000);

				driver.findElement(By.className("automation-home-btn-manage")).click();
				System.out.println("----Manage_btn button clicked---->>");
				Thread.sleep(5000);

				driver.findElement(By.className("automation-op-app-sel-action-dialog")).click();
				System.out.println("----Action CATEGORY clicked for dialog---->>");
				Thread.sleep(5000);

				driver.findElement(By.className("automation-op-app-sel-action-opt-dialog-approved_and_submitted_for_config")).click();
				System.out.println("----Action CATEGORY selected config for dialog---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.className("automation-op-app-btn-apply-dialog")).click();
				System.out.println("----Save button clicked---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.className("automation-op-app-sel-action-hutch")).click();
				System.out.println("----Action CATEGORY clicked for hutch---->>");
				Thread.sleep(5000);

				driver.findElement(By.className("automation-op-app-sel-action-opt-hutch-approved_and_submitted_for_config")).click();
				System.out.println("----Action CATEGORY selected config for hutch---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.className("automation-op-app-btn-apply-hutch")).click();
				System.out.println("----Save button clicked---->>");
				Thread.sleep(5000);
				
				
				/*
				driver.findElement(By.xpath("//*[@id=\"mat-select-3\"]")).click();
				System.out.println("----Action CATEGORY clicked for Airtel---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id=\"mat-option-13\"]")).click();
				System.out.println("----Action CATEGORY Submit for Config selected---->>");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-operator-approval/mat-dialog-content/table/tbody/tr[3]/td[4]/button")).click();
				System.out.println("----Save button clicked---->>");
				Thread.sleep(5000);
				*/
				
				driver.findElement(By.className("automation-op-app-btn-close")).click();
				System.out.println("Close button clicked = Passed");
				Thread.sleep(7000);
				
				driver.findElement(By.className("automation-menu")).click();
				System.out.println("Main menu clicked");
				Thread.sleep(7000);
				
				driver.findElement(By.className("automation-home-link-logout")).click();
				System.out.println("Logout button clicked");
				Thread.sleep(7000);
				
				reader.close();
		}
		
		
		
		@Test(priority = 30 ) // (priority=10)
		public void Check_App_Status() throws Exception {
			
	// This code is to get new Tab in chrome browser 
			/*driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			Thread.sleep(4000);
			
			 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			 driver.switchTo().window(tabs.get(0)); //switches to new tab
			 driver.get("https://appmaker.otenro.com/app/login");*/
			 
	// login
			 
			 	driver.findElement(By.name("email")).sendKeys("sakunthalanfm@gmail.com");
				Thread.sleep(2000);
				System.out.println("Email entered = Passed");

				driver.findElement(By.name("password")).sendKeys("Saku@1234");
				System.out.println("Password entered = Passed");
				Thread.sleep(2000);

				driver.findElement(By.name("submitbtn")).click();
				System.out.println("Login button clicked = Passed");
				Thread.sleep(2000);
				
				driver.findElement(By.className("auto-login-dialog-btn-yes")).click();
				System.out.println("You are already logged into an active session. Proceeding with this new session will result in you being logged out of your active session and any unsaved progress being lost. Please confirm to proceed. = Clicked ok Button");
				Thread.sleep(2000);

				String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]"))
						.getAttribute("innerHTML");
				String expect = "Login Successful";

				if (actual_msg.contains(expect)) {
					System.out.println("Validation passed = " + actual_msg);
				} else {
					System.out.println("Test Case Failed = " + actual_msg);
				}

				Thread.sleep(7000);

				List<WebElement> activeColumns = driver.findElements(By.name("Created_Apps"));
				Thread.sleep(1000);
				activeColumns.get(activeColumns.size() - 1).click();
				Thread.sleep(4000);
				
				driver.findElement(By.name("publish_btn")).click();
				System.out.println("----Publish button clicked---->>");
				Thread.sleep(5000);

				driver.findElement(By.name("Status")).click();
				System.out.println("----Status button clicked---->>");
				Thread.sleep(10000);
		}

		
		@Test(enabled = false)
		public void Get_Web_Configuraion_URL_Load_PWA() throws InterruptedException, IOException, AWTException {

			File objFile = new File("C:\\Appmaker Automation\\Article smoke Testing Process\\ExcelWriteReadFile\\AppnameReadWrite.xlsx");
			FileInputStream objInstream = new FileInputStream(objFile);
			XSSFWorkbook objWorkbk1 = new XSSFWorkbook(objInstream);// Workbook create
			XSSFSheet sheet = objWorkbk1.getSheet("AppNames");

			Thread.sleep(2000);

			String Appname = sheet.getRow(1).getCell(0).getStringCellValue();

			String url = ("https://article.otenro.com/" + Appname);
			System.out.println(url);
			driver.get(url);
			Thread.sleep(5000);

			objWorkbk1.close();

			Robot robot = new Robot();
			// Creates the delay of 5 sec so that you can open notepad before
			// Robot start writting
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);

			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"nav-toggle\"]")).click();

			driver.findElement(By.cssSelector(".fa-bars")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#mySidenav > a:nth-child(2)")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".flex-row:nth-child(1) > .flex-col:nth-child(1) > img")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".list-group-item-heading")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".fa-arrow-left")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".fa-arrow-left")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".flex-row:nth-child(3) img")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".list-group-item-text")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".fa-bars")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#mySidenav > a:nth-child(2)")).click();
			Thread.sleep(3000);

			driver.findElement(By.cssSelector(".fa-download")).click();

			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);

			Thread.sleep(3000);

		}

		@Test(enabled = false)
		public void Send_Push_message() throws InterruptedException, IOException, AWTException {
			driver.get(baseURL);
			driver.manage().window().maximize();

			driver.findElement(By.name("Login_btn")).click();
			Thread.sleep(2000);
			System.out.println("Login button clicked = Passed");

			driver.findElement(By.name("email")).sendKeys("sakunthalanfm@gmail.com");
			Thread.sleep(2000);
			System.out.println("Email entered = Passed");

			driver.findElement(By.name("password")).sendKeys("Saku@1234");
			System.out.println("Password entered = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("submitbtn")).click();
			System.out.println("Login button clicked = Passed");
			Thread.sleep(2000);

			String actual_msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expect = "Login Successful";

			if (actual_msg.contains(expect)) {
				System.out.println("Validation passed = " + actual_msg);
			} else {
				System.out.println("Test Case Failed = " + actual_msg);
			}

			Thread.sleep(7000);

			List<WebElement> activeColumns = driver.findElements(By.name("Created_Apps"));
			Thread.sleep(1000);
			activeColumns.get(activeColumns.size() - 1).click();
			Thread.sleep(1000);

			driver.findElement(By.name("Engage_btn")).click();
			System.out.println("Engage_btn button clicked = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("push_messages")).click();
			System.out.println("Push Messages button clicked = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("add_new_item")).click();
			System.out.println("Add new Messages button clicked = Passed");
			Thread.sleep(2000);

			driver.findElement(By.name("message")).sendKeys("This is a test....");
			System.out.println("Messages Entered");
			Thread.sleep(2000);

			driver.findElement(By.name("send_message_now")).click();
			System.out.println("Send Message button clicked");
			Thread.sleep(2000);

		}

	}


