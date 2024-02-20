
package OrangeCrossBrowser;
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
import orangeHRM.SetUpOrangeHRM;




public class MainSection extends SetUpOrangeHRM {

	@Test
	public void loginWithValidCredentials()
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
	

}