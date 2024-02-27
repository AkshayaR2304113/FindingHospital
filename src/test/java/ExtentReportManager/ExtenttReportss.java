package ExtentReportManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testCases.TC_01_DoctorSearch;

public class ExtenttReportss implements ITestListener
{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String myReport="Test-Report-"+timestamp+".html";
		sparkreporter =new ExtentSparkReporter(".\\Reports\\"+myReport);
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Akshaya R");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("On Test Started.....");
	}
	public void onTestSuccess(ITestResult result)
	{
		String path=TC_01_DoctorSearch.path;
		test=extent.createTest(result.getName())
				.addScreenCaptureFromPath(path,result.getName());
		test.log(Status.PASS, "Test case Passed is:"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:"+result.getName());
		test.log(Status.FAIL, "Test casec FAILED CAUSE is:"+result.getThrowable());

	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:"+result.getName());
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("onTestFailedButWithinSuccessPercentage...........");
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}
