package wecare;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author ankush.agrawal
 *
 */
public class Utils {

	static WebDriver driver;
	public static Properties config;
	public static Workbook book;
	public static Sheet sh;

	// wait for given time
	public void threadWait(int value) throws InterruptedException {
		Thread.sleep(value);
	}

	// close the current browser
	public void closeWindow() {
		driver.close();
	}

	// close the browser
	public void closeBrowser() {
		driver.quit();
	}

	// maximize the window
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// opening in different browser
	public void selectbrowser() throws Exception {

		config = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "config");
		config.load(f);

		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\Input\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "src\\Input\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	public void launchBrowser(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// entering text in a text field
	public void enterTextcommand(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}

	// click button

	public void clickCommand(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	// move to an element

	public void moveToElement(By locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		action.moveToElement(element).click().build().perform();
	}

	// selecting the element from dropdown

	public void dropdown(By locator, int index) {
		WebElement element = driver.findElement(locator);
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// validating the string

	public void validate(String expected, String actual) {
		boolean booleanvalue = expected.equals(actual);
		if (booleanvalue == false) {
			System.out.println("expected string" + expected + "Acutual is not as expected" + actual + "");
		} else {
			System.out.println("expected string" + expected + "Acutual as expected" + actual + "");
		}
	}

	// validatig the page title

	public void VerifyTitle(String exp_Title) {
		String actualtitle = driver.getTitle();
		if (exp_Title.equals(actualtitle)) {
			System.out.println("pass");
		} else {
			System.out.println("false");
		}
	}

	/**
	 * 
	 * @param Alert method start from here
	 * 
	 */
	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public String alertGetText() {
		Alert al = driver.switchTo().alert();
		return al.getText();
	}

	public void alertSendkeys(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}

	// For Screenshot 

	public void take_screenShot(String Filename){
	  try {
	         File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	         
	         FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"screenshot"+Filename+".png"));
	     } catch (IOException e1) {
	         e1.printStackTrace();
	     }
	  
	  /**
	   * 
	   * @param wait method start from here
	   * 
	   */
	  public void waitforClick(By locator){
		  WebDriverWait wait =new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeClickable(locator))
	  }
	  
	  public void waitforElementSelected(By locator){
		  WebDriverWait wait =new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeSelected(locator));
	  }
	  
	  public void waitforAlert(By locator){
		  WebDriverWait wait =new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.alertIsPresent());
	  }
	  
	  public void waitforVisible(By locator){
		  WebDriverWait wait =new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	  }
	  
	  public void waitforVisible(By locator){
		  WebDriverWait wait =new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	  }
	  
	 
	}
