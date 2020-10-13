package WindowsAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPopUp
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Destiny\\Downloads\\Softwares\\ChromeDriver_Version_85\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				/*Below line will automatically insert username and password into the windows popup
				the pattern is :-
				driver.get(http://username:password@Site-URL)*/
				driver.get("https://admin:admin@the-internet.herokuapp.com/");
				driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]")).click();
				//End of Program
				
			}

	}
