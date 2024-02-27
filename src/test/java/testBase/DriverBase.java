package testBase;
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
 
public class DriverBase {
	public WebDriver driver;
	Properties p;
	public static Logger logger;
 
	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String br) throws IOException, InterruptedException {
 
		/*switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser");
			return;
		}*/
		
		//Selenium grid ------------------------------
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(p.getProperty("os").equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (p.getProperty("os").equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return;
			}
			//browser
			if(p.getProperty("browser").equalsIgnoreCase("chrome")) {
				capabalities.setBrowserName("chrome");
			}
			else if(p.getProperty("browser").equalsIgnoreCase("edge")) {
				capabalities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("no matching browser .....");
				return;
			}
			 driver = new RemoteWebDriver(new URL("http://192.168.107.74:4444") , capabalities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				return;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(p.getProperty("appURL"));
		logger = LogManager.getLogger(this.getClass());
		driver.manage().window().maximize();
		
	}
 
	@AfterClass
	public void closure() {
		driver.quit();
	}
	
	
	public static class Scrshot {

		public static String SShot(String filename,WebDriver driver) throws IOException {

			TakesScreenshot ts=(TakesScreenshot)driver;

			File src=ts.getScreenshotAs(OutputType.FILE);

			File trg=new File(System.getProperty("user.dir")+"\\Screenshots\\"+filename+".png");

			FileUtils.copyFile(src, trg);

			return trg.getAbsolutePath();

		}
	}
		
		public static Logger getLogger() 
		{		 
			logger=LogManager.getLogger(); //Log4j
			return logger;
		}

	


	
 
}