package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import UtilityFile.WriteData;

public class GetDocName extends BasePage {
	
	WebDriver driver;

	public GetDocName (WebDriver driver) {
		super(driver);
	}
	
	List<String> DocsName= new ArrayList<>();
	List<String> HospName= new ArrayList<>();
	
	@FindBy(xpath="//div/a/div/h2[@data-qa-id='doctor_name']")
	List<WebElement> DocName;
	
	@FindBy(xpath="//div/a/span[@data-qa-id='doctor_clinic_name']")
	List<WebElement> HospitalName;
	
		
    public void Doctor_Nav() throws InterruptedException, IOException{
    	
    	int i = 0;
		
		for( WebElement name : DocName) {
			
			String DName = name.getText();
			System.out.println(DName);
			
			DocsName.add(DName);
			
			
			if(i==4) {
				break;
			}
			
			i++;
			
			
		}
		
		Thread.sleep(3000);
		
      
		
	}
    
    public void Hospital_Nav() throws InterruptedException, IOException{
    	
    	int i=0;
    	
    	 for( WebElement name : HospitalName) {
 			
 			String hName = name.getText();
 			System.out.println(hName);
 			
 			HospName.add(hName);
 			
 			
 			
			if(i==4) {
 				
 				break;
 			}
 			
 			i++;
 			
 			
 		}
 		
 		
 		
 		Thread.sleep(5000);
    	
    }
    
      public void Write_Data_Excel() throws IOException, InterruptedException {
    	  
    	  WriteData w = new WriteData();
        	
        	w.writeData("Doctor Info", DocsName, 0, 0);
        	
        	Thread.sleep(3000);
        	
        	w.writeData("Doctor Info", HospName, 0, 1);
    	
    	
    }
}
