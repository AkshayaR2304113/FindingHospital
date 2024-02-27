package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityFile.WriteData;

public class Surgeries extends BasePage {

	WebDriver driver;

	public Surgeries (WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath="//div/a/div[text()='Surgeries']")
	WebElement SurgeryTab;
	
	@FindBy(xpath="//div/p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> SurgeryName;
	
	
	@FindBy(xpath="//h1[text()='Popular Surgeries']")
	WebElement Scroll;
	
	
		
	
	
	List<String> SurgName= new ArrayList<>();
	
	public void Surgery_Nav() throws InterruptedException {
		
		SurgeryTab.click();
		Thread.sleep(3000);
		
		
	}
	
    public void SurgeryList() throws InterruptedException, IOException{
    	
    	
    	
    	for( WebElement name : SurgeryName) {
			
			Thread.sleep(3000);
			
			String SName = name.getText();
			
			System.out.println(SName);
			
			SurgName.add(SName);
			
		}
		
		
		
	}
    
    public void Write_Data_Excel() throws IOException {
  	  
  	    WriteData w = new WriteData();
      	
      	w.writeData("Surgery List", SurgName, 0, 0);
  	
  	
  }
}
