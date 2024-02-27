package pageObjects;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class FindingDoctors extends BasePage {
	
    //Every pageObject class will extends the BasePage
	
	WebDriver driver;

	public FindingDoctors (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div/a/div[text()='Find Doctors']")
	WebElement FindDoc;
	
	@FindBy(xpath="//div/input[@data-qa-id='omni-searchbox-locality']")
	WebElement LocationSearch;
	
	@FindBy(xpath="//div/input[@data-qa-id='omni-searchbox-keyword']")
	WebElement DoctorSearch;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/div")
	WebElement Surgeon;
	
	public void location_Nav() throws InterruptedException {
		
		FindDoc.click();
		Thread.sleep(3000);
		LocationSearch.clear();
		Thread.sleep(3000);
	}
	
	public void Location_Value(String location , WebDriver driver) throws IOException, InterruptedException {
		
		LocationSearch.click();
		
		LocationSearch.sendKeys(location);
		
		Thread.sleep(2000);
		
	    
	}
	
	public void Search_Nav() {
		DoctorSearch.click();
	}
	
	public void Search_Value(String DoctorType , WebDriver driver) throws IOException, InterruptedException {
		
		DoctorSearch.sendKeys(DoctorType);
		Thread.sleep(2000);
		
		Surgeon.click();
	    
	}

	

}
