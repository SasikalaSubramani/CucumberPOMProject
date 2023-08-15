package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	private WebDriver driver;

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By privacyCheckbox =By.xpath("//input[@name='agree']");
	private By continueButton = By.xpath("//input[@value='Continue']");
	private By successMessg = By.xpath("//*[@id='common-success']//h1");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	public static String getRandomMailID() {
		return "automation" + System.currentTimeMillis()+"@gmail.com";

	}

	public String getRegisterPageTitle() {
		return driver.getTitle();
	}
	

	public void fillRegisterForm(String firstName, String lastName, String telePhone, String passWord ) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(firstname).sendKeys(firstName);
		driver.findElement(lastname).sendKeys(lastName);
		driver.findElement(email).sendKeys(getRandomMailID());
		driver.findElement(telephone).sendKeys(telePhone);
		driver.findElement(password).sendKeys(passWord);
		driver.findElement(confirmPassword).sendKeys(passWord);
		driver.findElement(privacyCheckbox).click();
	}

	public void clickContinue() {
		driver.findElement(continueButton).click();
	}

	public String getSuccessMessg() {
		return driver.findElement(successMessg).getText();
	}

}