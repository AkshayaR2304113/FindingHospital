package pageObjects;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
 
public class BasePage {
 
	//BasePage contains only the constructor.
	//Which will initiate the driver.
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}