package com.htc.ReadExcelFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login{
WebDriver driver=null;
private By accountBy=By.xpath("(//span[@class='label'])[3]");
private By loginBy=By.xpath("//div[@class='links']//ul//li[@class=' last']//a");
private By emailidBy=By.xpath("//input[@id='email']");
private By passwordBy=By.xpath("//input[@id='pass']");
private By loginbuttonBy=By.xpath("//button[@id='send2']");

public Login(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void accountBy()
{
	driver.findElement(accountBy).click();
}
public void loginBy() {
	driver.findElement(loginBy).click();
}
public void emailidBy(String email) {
	driver.findElement(emailidBy).sendKeys(email);
}
public void passwordBy(String password) {
	driver.findElement(passwordBy).sendKeys(password);
}
public void loginButtonBy() {
	driver.findElement(loginbuttonBy).click();
}

}
