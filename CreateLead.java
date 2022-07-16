package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		WebElement logout = driver.findElement(By.className("decorativeSubmit"));	

		String obj1 = logout.getAttribute("value");

		System.out.println(obj1);

		if (obj1.equals("Logout"))
		{
			System.out.println("Successfully logged in");
		}

		driver.findElement(By.linkText("CRM/SFA")).click();	

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Kalmar");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Saravana");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Karthik");

		WebElement dropdown= driver.findElement(By.id("createLeadForm_dataSourceId"));

		Select select = new Select (dropdown);

		select.selectByVisibleText("Conference");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Karthik Cool");

		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSE");

		driver.findElement(By.id("createLeadForm_description")).sendKeys("Peace Life");

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saravanakarthikcse@gmail.com");

		WebElement dropdown2= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select1 = new Select (dropdown2);
		select1.selectByVisibleText("New York");

		driver.findElement(By.className("smallSubmit")).click();

		String obj = driver.getTitle();

		System.out.println(obj);

		if(obj.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Title is correct");
		}

		else
		{
			System.out.println("Title is incorrect");
		}

	}
}

