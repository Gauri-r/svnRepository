package WindowsObjectInspect;

//import java.awt.Window.Type;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadPDF
	{

		public static void main(String[] args) throws InterruptedException, IOException
			{
				// TODO Auto-generated method stub
				String downloadPath = System.getProperty("user.dir");

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Destiny\\Downloads\\Softwares\\ChromeDriver_Version_85\\chromedriver_win32\\chromedriver.exe");

				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

				chromePrefs.put("profile.default_content_settings.popups", 0);

				chromePrefs.put("download.default_directory", downloadPath);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				
				WebDriver driver = new ChromeDriver(options);
				driver.get("https://smallpdf.com/pdf-to-word");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[contains(@class,'hrcxSS')]")).click();
				Thread.sleep(3000);
				Runtime.getRuntime().exec("F:\\Gauri\\EclipseOxygen\\AutoITProject\\Script\\DownloadPdf.exe");
				System.out.println("File Uploaded");

				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")));
				driver.findElement(By.xpath(
						"//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]"))
						.click();
				driver.findElement(By.xpath(
						"//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]"))
						.click();
				// Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
						"//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")));
				driver.findElement(By.xpath(
						"//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]"))
						.click();
				Thread.sleep(3000);
				File f = new File(downloadPath + "/Resume-converted.docx");
				Thread.sleep(10000);
				if (f.exists())
					{
						System.out.println("File downloaded at Project Location");
					}
			}

	}
