package util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.PageObject;

public class util extends PageObject{
	WebDriver driver = getDriver();
	private static JavascriptExecutor jse;

	public static boolean scrollToElement(WebDriver driver, WebElement Element) {
		jse = ((JavascriptExecutor) driver);
		try {
			jse.executeScript("scroll(0, arguments[0].offsetTop-100)",Element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean switchToFrame(WebDriver driver, WebElement frame) {
		try {
			driver.switchTo().defaultContent();
			if (frame != null)
				driver.switchTo().frame(frame);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void waitForPageLoad(WebDriver driver_) {
	    Wait<WebDriver> wait = new WebDriverWait(driver_, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
	
	public static boolean isElementPresent(WebDriver driver_,String xpath){
		Boolean isPresent = false;
       return  isPresent = driver_.findElements(By.xpath(xpath)).size() > 0;
    }
	
}
