import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Registration_Form {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Deepika\\Selenium\\chromedriver_win32_100\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		//Verify PageName is visible
		WebElement pagename=driver.findElement(By.cssSelector("div.main-header"));
		Assert.assertEquals("Practice Form", pagename.getText());
		System.out.println("Expected page name is displayed-Assert is passed");
		
		//Verify Form topic is visible
		WebElement formname= driver.findElement(By.xpath("//h5[text()='Student Registration Form']"));
		Assert.assertEquals("Student Registration Form", formname.getText());
		System.out.println("Expected Form name is displayed-Assert is passed");
		
		//Enter Values to the fields
		//:: Name Fields
		driver.findElement(By.id("firstName")).sendKeys("Deepika");
		driver.findElement(By.id("lastName")).sendKeys("Damayanthi");
		
		//::Email Field
		driver.findElement(By.id("userEmail")).sendKeys("DeepikaTest@gmail.com");
		
		//::Gender Radio Button
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
		//::Mobile Field
		driver.findElement(By.id("userNumber")).sendKeys("0111234567");
		
		
		//:: Date of Birth Field
		driver.findElement(By.id("dateOfBirthInput")).clear();
		// 1 - Select Year
		WebElement ddl_year=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select selectYear=new Select(ddl_year);
		selectYear.selectByValue("1990");
		
		// 2 - Select Month
		WebElement ddl_month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select selectMonth=new Select(ddl_month);
		selectMonth.selectByIndex(7);
		
		// 3 - Select Date
		driver.findElement(By.xpath("//div[@class='react-datepicker__week'][2]/div[1]")).click();
		
		// :: Subjects Field
		//WebDriverWait wait=new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.textToBePresentInElementLocated((By) driver.findElement(By.id("subjectsInput")), "IT"));
		driver.findElement(By.id("subjectsInput")).sendKeys("Infromation Technology");
		
		
		// :: Hobbies Field
		WebElement chkbox_Reading= driver.findElement(By.xpath("//label[text()='Reading']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", chkbox_Reading);
		
		// :: Picture Upload Field
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\User\\Desktop\\Deepika\\Selenium\\Selenium_Project\\Student_Registration_Form\\src\\Picture\\ProfilePic.png");
		
		// :: Current Address Field
		driver.findElement(By.id("currentAddress")).sendKeys("Colombo-3");
		
	//	System.out.println(state.size());
		Thread.sleep(10000);
		driver.close();

	}

}
