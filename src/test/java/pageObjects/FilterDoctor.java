package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterDoctor extends BasePage{
	
	WebDriver driver;

	public FilterDoctor (WebDriver driver) {
		super(driver);
	}
	

	
	@FindBy(xpath="(//div/span/i[@class='u-transition--transform u-d-inlineblock icon-ic_dropdown u-f-right'])[2]")
	WebElement PatientStories;
	
	@FindBy(xpath="//ul/li/span[text()='10+ Patient Stories']")
	WebElement PStories_Value;
	
	@FindBy(xpath="(//div/span/i[@class='u-transition--transform u-d-inlineblock icon-ic_dropdown u-f-right'])[3]")
	WebElement Experience;
	
	@FindBy(xpath="//ul/li/span[text()='10+ Years of experience']")
	WebElement Experience_Value;
	
	@FindBy(xpath="(//div/i[@class='u-transition--transform u-d-inlineblock icon-ic_dropdown'])")
	WebElement AllFilters;
	
	@FindBy(xpath="(//div[@class='c-filter__select--radio u-d-inlineblock u-valign--middle u-pos-rel'] )[8]")
	WebElement Availability;
	
	@FindBy(xpath="(//div/span/i[@class='u-transition--transform u-d-inlineblock icon-ic_dropdown u-f-right'])[4]")
	WebElement Sort;
	
	@FindBy(xpath="//ul/li/span[text()='Number of patient stories - High to low']")
	WebElement Sort_Value;
	
	public void PStories_Nav() throws InterruptedException, IOException{
		
		PatientStories.click();
		
		Thread.sleep(5000);
		
	}
	
    public void PStories() throws InterruptedException{
		
    	PStories_Value.click();
    	
    	Thread.sleep(5000);
		
	}
    
    public void Experience_Nav() throws InterruptedException, IOException{
		
    	Experience.click();
    	
    	Thread.sleep(5000);
		
	}
    
    public void Experience_val() throws InterruptedException{
		
    	Experience_Value.click();
    	Thread.sleep(5000);
		
	}
	
    public void AllFilters_Nav() throws InterruptedException, IOException{
		
    	AllFilters.click();
    	
    	
    	
    	Thread.sleep(5000);
		
	}
    
    public void Availability_Nav() throws InterruptedException{
		
    	Availability.click();
    	Thread.sleep(5000);
		
	}
	
    public void Sort_Nav() throws InterruptedException, IOException{
		
    	Sort.click();
    	
    	
    	
    	Thread.sleep(5000);
		
	}
    
    public void Sort() throws InterruptedException{
		
    	Sort_Value.click();
    	Thread.sleep(5000);
		
	}

}
