package com.toolsqa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.toolsqa.beans.FillFormData;
import com.toolsqa.dao.FillformDAO;

public class Fillform {

	public static WebDriver driver;
	FillFormData formdata;

	@FindBy(xpath="//input[@name='firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@value='Male' and contains(@id, 'sex')]")
	WebElement male;
	
	@FindBy(xpath="//input[@value='Female' and contains(@id, 'sex')]")
	WebElement female;
	
	@FindBy(xpath="//input[@id='datepicker']")
	WebElement pickdate;
	
	@FindAll({
		@FindBy(name="exp")
	})
	List<WebElement> rBtnYears;
	
	@FindBy(id="submit")
	WebElement submit;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "D:\\WI{PRO\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		PageFactory.initElements(driver, this);
	}
	
	@Parameters(value="testCaseID")
	@Test
	public void getFillFormTest(@Optional String testCaseID){
		FillformDAO formdetails=new FillformDAO();
		formdata = formdetails.getFormData(testCaseID);
		fname.sendKeys(formdata.getFirstName());
		lname.sendKeys(formdata.getLastName());

		String sex = "M";
		if (sex.equalsIgnoreCase("M")) {
			male.click();
		} else if (sex.equalsIgnoreCase("F")) {
			female.click();
		} else {
			System.out.println("Wrong Option");
		}

		
		rBtnYears.get(4).click();
		pickdate.sendKeys(formdata.getPickDate());
		List<WebElement> cBoxProfession = driver.findElements(By.name("profession"));
		cBoxProfession.get(0).click();

		List<WebElement> cBoxTool = driver.findElements(By.name("tool"));
		cBoxTool.get(2).click();

		Select continents = new Select(driver.findElement(By.xpath("//select[@name='continents']")));
		continents.selectByIndex(3);

		Select selCommands = new Select(driver.findElement(By.xpath("//select[@name='selenium_commands']")));
		selCommands.selectByIndex(2);

		submit.click();

	}
	
	@AfterTest
	public void validate(){
		driver.close();
		driver.quit();
	}
}
