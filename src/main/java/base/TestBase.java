package base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import util.TestUtil;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");

			prop.load(fis);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public static void initBrowserSession() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")){

			System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		log.info("=== Browser Session Starting ===");

		log.info("Initializing" + browserName + "browser");

		driver.manage().deleteAllCookies();

		log.info("Deleting all cookies for fresh session");

		driver.manage().window().maximize();

		log.info("Maximizing browser for visibility");

		String baseUrl = prop.getProperty("url");

		driver.get(baseUrl);

		log.info("Retrieving and navigating to url: " + baseUrl);

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		log.info("Page load timeout set");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		log.info("Implicit wait timeout set");

		log.info("=== Browser Session Initialized ===");
	}
	
	@AfterSuite
	public void tearDownBrowserSession() throws InterruptedException {
		Thread.sleep(2000);
		if(getDriver() != null){
			getDriver().quit();
		}
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
}
