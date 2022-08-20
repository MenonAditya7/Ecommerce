package firstProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce1 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\itmaint\\eclipse-workspace\\Seleniumnew\\src\\chromedrivernew\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();




		//GOOGLE

		WebElement gg= driver.findElement(By.xpath("//*[@name='q']"));
		gg.sendKeys("saucedemo");

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN); 
		r.keyRelease(KeyEvent.VK_DOWN);
		//Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//*[text()='Swag Labs']")).click();

		//Login procedure


		WebElement username =	driver.findElement(By.xpath("//*[@placeholder='Username']"));
		username.click();
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// Thread.sleep(3000);


		//Dropdown

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ddwon =driver.findElement(By.className("product_sort_container"));
		Select ad = new Select(ddwon);
		ad.selectByValue("lohi");

		//scroll down
		WebElement dn = driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']"));
		JavascriptExecutor jw = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jw.executeScript("arguments[0].scrollIntoView()", dn);



		//context click
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']"))).perform();
		WebElement cc = driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']"));

		ac.contextClick(cc).perform();
		Robot op = new Robot();

		op.keyPress(KeyEvent.VK_DOWN);
		op.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		op.keyPress(KeyEvent.VK_ENTER);

		//window handle

		Set<String> windowhandles =driver.getWindowHandles();
		System.out.println("windowhandles");
		Iterator<String> iterator =windowhandles.iterator();
		String pw =   iterator.next();
		String nextwindow =iterator.next();

		driver.switchTo().window(nextwindow);

		//Add to cart

		driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		WebElement up = driver.findElement(By.className("shopping_cart_badge"));
		Thread.sleep(3000);
		up.click();
		driver.findElement(By.id("checkout")).click();

		//Details

		driver.findElement(By.name("firstName")).sendKeys("Aditya");
		driver.findElement(By.id("last-name")).sendKeys("Menon");
		driver.findElement(By.id("postal-code")).sendKeys("69870");
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();



		Thread.sleep(3000);
		WebElement we =	 driver.findElement(By.xpath("//*[@class='summary_total_label']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		je.executeScript("arguments[0].scrollIntoView()", we);

		driver.findElement(By.xpath("//*[@name='finish']")).click();

		driver.navigate().to("https://www.saucedemo.com/inventory.html");



		driver.quit();




	}

}


