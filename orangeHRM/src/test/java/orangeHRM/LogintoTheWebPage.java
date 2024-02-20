package orangeHRM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogintoTheWebPage extends SetUpOrangeHRM {

	WebDriver driver=null;
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

