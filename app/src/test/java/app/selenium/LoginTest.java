package app.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.constant.NavigationConstants;

import app.utils.TestConstants;
import app.utils.TestVideoRecorder;

/**
 * Login test that enters Home
 * 
 * @author David García Prados
 *
 */
public class LoginTest {
	private WebDriver driver;
	private TestVideoRecorder testVideoRecorder;
	private final Logger logger = LogManager.getLogger();

	@Before
	public void init() {
		driver = new FirefoxDriver();

		testVideoRecorder = null;
		try {
			testVideoRecorder = new TestVideoRecorder(this.getClass().getSimpleName());
			testVideoRecorder.start();
		} catch (Exception ex) {
			logger.error(ex + TestConstants.VIDEO_ERROR_RECORD_TEST);
		}
	}

	@After
	public void quit() {
		driver.quit();
		try {
			testVideoRecorder.stop();
		} catch (Exception ex) {
			logger.error(ex + TestConstants.VIDEO_ERROR_RECORD_TEST);
		}
	}

	@Test
	public void login() {

		// Open login page
		driver.get(TestConstants.LOCAHOST_BASE_URL + NavigationConstants.LOGIN);

		// Wait until a timeout and check that title is App Login
		(new WebDriverWait(driver, TestConstants.SELENIUM_DEFAULT_WAIT_SECONDS))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().startsWith("App Login");
					}
				});

		// Access to username text field and type the value
		WebElement elementUsername = driver.findElement(By.name("username"));
		elementUsername.sendKeys("admin");

		// Access to password text field and type the value
		WebElement elementPassword = driver.findElement(By.name("password"));
		elementPassword.sendKeys("admin");

		// Submit form
		elementUsername.submit();

		// Wait until a timeout and check that title is App Home
		(new WebDriverWait(driver, TestConstants.SELENIUM_DEFAULT_WAIT_SECONDS))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().startsWith("App Home");
					}
				});
	}
}
