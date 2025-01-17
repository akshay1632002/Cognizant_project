package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindDoctorsElements extends BasePage{
	public FindDoctorsElements(WebDriver driver)
	{
		super(driver);
	}
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//Locators for Find Doctors Function Elements
	
	@FindBy(xpath="//div[contains(text(),'Find Doctors')]")
	WebElement findDoc_element;
	
	@FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement search_speciality;
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-item']/span/div[text()='Dentist']")
	WebElement recent_search;
	
	@FindBy(xpath="//h2[@class='doctor-name']")
	List<WebElement> doctors_name;
	
	@FindBy(xpath="//div[@class='u-d-flex']/span")
	List<WebElement> occupation_type;
	
	@FindBy(xpath="//button[@class='u-t-capitalize u-bold u-round-corner--large c-btn--dark-medium']")
	List<WebElement> bookfree_buttons;
	
	public void findDocPage()
	{
		findDoc_element.click();
	}
	
	public void findDoctor(String spec) throws InterruptedException
	{
		search_speciality.sendKeys(spec);
		Thread.sleep(3000);
		WebElement r_srch=wait.until(ExpectedConditions.visibilityOf(recent_search));
		r_srch.click();
		
		js.executeScript("window.scrollBy(0,1800)","");
	}
	
	public List<WebElement> doctersName()
	{
		return doctors_name;
	}
	
	public List<WebElement> occupations()
	{
		return occupation_type;
	}
	
	public List<WebElement> bookFree()
	{
		return bookfree_buttons;
	}
	

}
