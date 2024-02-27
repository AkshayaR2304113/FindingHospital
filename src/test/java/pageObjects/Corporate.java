package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Corporate extends BasePage {
	
	WebDriver driver;

	public Corporate (WebDriver driver) {
		super(driver);
	}
	
	//WebDriverWait wait=new WebDriverWait(driver, 20);
	
	@FindBy(xpath="//div/div/span/span[text()='For Corporates']")
	WebElement CorporateTab;
	
	@FindBy(xpath="//div/div/a[text()='Health & Wellness Plans']")
	WebElement CorporateValue;
	
	@FindBy(xpath="(//form/div/input[@id='name'])[1]")
	WebElement Name;
	
	@FindBy(xpath="(//form/div/input[@id='organizationName'])[1]")
	WebElement OrgnName;
	
	@FindBy(xpath="(//form/div/input[@id='contactNumber'])[1]")
	WebElement Contact;
	
	@FindBy(xpath="//div/input[@id='officialEmailId']")
	WebElement emailID;
	
	@FindBy(xpath="(//form/div/select[@id='organizationSize'])[1]")
	WebElement OrgnSize;
	
	@FindBy(xpath="(//form/div/select[@id='interestedIn'])[1]")
	WebElement IntrstIN;
	
	@FindBy(xpath="//button[text()='Schedule a demo']")
	WebElement DemoButton;
	
	@FindBy(xpath="(//div/div[text()='THANK YOU'])[1]")
	WebElement TQ;
	
	
	
	
	
	public void Corporate_Nav() throws InterruptedException, IOException {
		
		CorporateTab.click();
		
		Thread.sleep(3000);
		
		
		
		CorporateValue.click();
	}
	
    public void Form_Val(String Email) throws InterruptedException, IOException{
    	
    	Name.clear();
    	
    	Name.sendKeys("akshaya");
    	
    	OrgnName.clear();
    	
    	OrgnName.sendKeys("Cognizant");
    	
    	Contact.clear();
    	
    	Contact.sendKeys("8838543865");
    	
    	emailID.clear();
    	
    	emailID.sendKeys(Email);
    	
    	Select SizeSelect =new Select(OrgnSize);
    	
    	SizeSelect.selectByVisibleText("501-1000");
    	
    	Thread.sleep(3000);
    	
        Select objSelect =new Select(IntrstIN);
    	
    	objSelect.selectByVisibleText("Taking a demo");
    	
    	
    	
    	
		
		
	}
    
    public void Submit() throws InterruptedException{
    	
    	
    	
    	
    	Thread.sleep(3000);
    	
    	Boolean Enable = DemoButton.isEnabled();
    	
    	
    	if(Enable.equals(false)) {
    		
    		System.out.println("Demo button is disabled");
    		
    	}
    	
    	else {
    		
    		DemoButton.click();
    		
    		Thread.sleep(90000);
    		
    		Boolean Display = TQ.isDisplayed();
    		
    		if(Display.equals(true)) {
        		
        		System.out.println("Thank you message is displayed");
        		
        	}
    		
    		else {
    			
    			System.out.println("Thank you message is not displayed");
    		}
    		
    		
    	}
    	
		
		
	}

}
