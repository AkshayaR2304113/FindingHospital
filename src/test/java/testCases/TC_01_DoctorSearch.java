package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UtilityFile.excel;

import pageObjects.Corporate;
import pageObjects.FilterDoctor;
import pageObjects.FindingDoctors;
import pageObjects.GetDocName;

import pageObjects.Surgeries;
import testBase.DriverBase;


@Listeners(ExtentReportManager.ExtenttReportss.class)
public class TC_01_DoctorSearch extends DriverBase {
	
	
	
	public static String path;
	
	
	// The actual test case
	@Test (priority=1)
	public void search() throws IOException, InterruptedException{
		
		DriverBase.getLogger().info("Goto Find Doctors");
		DriverBase.getLogger().info("Enter Location and details..");
		FindingDoctors searchH = new FindingDoctors(driver);
		String[] data = excel.FileData();
		searchH.location_Nav();
		searchH.Location_Value(data[0], driver);
		
		searchH.Search_Nav();
		searchH.Search_Value(data[1],driver);
		
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\locNdSp.png");
		FileHandler.copy(FirstScr, destination);
		
		path=Scrshot.SShot("LocNdSpe", driver);
		
		
		
	}
	
	@Test(priority=2)
	public void sortD() throws IOException, InterruptedException{
		
		
		DriverBase.getLogger().info("Provide the Filters to sort the doctors in the given location");
		
		FilterDoctor sortDoc = new FilterDoctor(driver);
		
		sortDoc.PStories_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\Pstories.png");
		FileHandler.copy(FirstScr, destination);
		
		
		
		sortDoc.PStories();
		
		sortDoc.Experience_Nav();
		File FirstScr1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination1 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\exp.png");
		FileHandler.copy(FirstScr1, destination1);
		
	
		
		sortDoc.Experience_val();
		
		sortDoc.AllFilters_Nav();
		
		File FirstScr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\allfilters.png");
		FileHandler.copy(FirstScr2, destination2);
		
		
		
		
		sortDoc.Availability_Nav();
		
		sortDoc.Sort_Nav();
		File FirstScr3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\sort.png");
		FileHandler.copy(FirstScr3, destination3);
		
		path=Scrshot.SShot("sort", driver);
		
		sortDoc.Sort();
	}
	
	@Test(priority=3)
	public void GetName() throws IOException, InterruptedException{
		
		DriverBase.getLogger().info("Retrive the Doctor details");
		
		GetDocName GetDoc = new GetDocName(driver);
		
		GetDoc.Doctor_Nav();
		
		GetDoc.Hospital_Nav();
		
		GetDoc.Write_Data_Excel();
		
		
	}
	

  @Test (priority=4)
	public void surLst() throws IOException, InterruptedException{
		
	    DriverBase.getLogger().info("Goto Surgery --> Retrive the Surgery List");
		Surgeries surg = new Surgeries(driver);
		surg.Surgery_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\surg.png");
		FileHandler.copy(FirstScr, destination);
		
		path=Scrshot.SShot("surgeryTab", driver);
		
		Thread.sleep(3000);
		
		surg.SurgeryList();
		
		Thread.sleep(3000);
		
		surg.Write_Data_Excel();
		
}
	
	@Test (priority=5)
	public void FormValidation() throws IOException, InterruptedException{
		
		DriverBase.getLogger().info("Validate Form fields with invalid input");
		Corporate form = new Corporate(driver);
		form.Corporate_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\form.png");
		FileHandler.copy(FirstScr, destination);
		
		path=Scrshot.SShot("form", driver);
		
		form.Form_Val("2304113@.com");
		form.Submit();
		File FirstScr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\invalid.png");
		FileHandler.copy(FirstScr2, destination2);
		
		path=Scrshot.SShot("Inavlid", driver);
		
		
		DriverBase.getLogger().info("validate form Details with valid input");
		form.Form_Val("2304113@cognizant.com");
		form.Submit();
		File FirstScr3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hackathon_Project\\Screenshot\\valid.png");
		FileHandler.copy(FirstScr3, destination3);
		
		path=Scrshot.SShot(" valid", driver);
}
}