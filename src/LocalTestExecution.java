

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalTestExecution {

	public static RemoteWebDriver driver;
	
	@Test
	public void launchBrowser() throws MalformedURLException
	{
		WebDriverManager.chromedriver().setup();
		
		String url="http://192.168.0.102:4444/wd/hub";
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		
		/*	Map<String,Object> cloudOption = new HashMap();
			
			cloudOption.put("build", "Smoke Test");
			cloudOption.put("name", "Chrome Smoke Test");
			
			options.setCapability("cloud-options", cloudOption);*/
			
			driver = new RemoteWebDriver(new URL(url), option);
			
			driver.get("https://www.amazon.in/");
			
			driver.manage().window().maximize();
			
			String URL = driver.getCurrentUrl();
			String title = driver.getTitle();
			
			System.out.println(URL);
			System.out.println(title);
			
			driver.quit();
	}
	
}
