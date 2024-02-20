package orangeHRM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
    
public class SetUpOrangeHRM {
	public WebDriver driver = null;

    public SetUpOrangeHRM() 
	{
		super(); // this mean this class is a parent class
	}

	@Parameters("browser")
	@BeforeTest
	public void mainRunnerforPagesWebsite(@Optional("chrome") String browser) {
		
		if (browser.equals("chrome")) { 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("doesn't support browser" + browser);

		}
	}

	@Test
	@Ignore
	public void test()
	{
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		    sleep(10); 
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.tagName("button")).click();
			sleep(15);
		     WebElement dashboard =  driver.findElement(By.cssSelector("h6[data-v-7b563373]"));
		     String ActualResult= dashboard.getText();
		     System.out.println(ActualResult);
		     assertEquals(ActualResult, "Dashboard");
		     driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void browserQuit() {
		driver.quit();
	}

	public void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
