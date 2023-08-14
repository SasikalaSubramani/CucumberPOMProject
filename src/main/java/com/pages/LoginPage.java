package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

//	1.By locators
	private By emailId = By.id("input-email");
	private By paasword = By.id("input-password");
	private By signInButton = By.xpath("//input[@value = 'Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password11");

	// constructor of the page class

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(paasword).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: "+ un +" and "+pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(paasword).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		return new AccountsPage(driver);
	}

}
