package com.htc.LoginDemo.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.htc.ReadExcelFile.Login;
import com.htc.ReadExcelFile.ReadData;

public class LoginTest {
WebDriver driver=null;
Properties prop=null;
Login loginpage=null;



@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	loginpage=new Login(driver);
	
	driver.get("http://demo-store.seleniumacademy.com/");
}

@AfterMethod
public void tearDown() {
	//driver.close();
}
@DataProvider(name = "logindata")
public Object[][] LoginDemopage()
{
	
	ReadData ref= new ReadData("C:\\Users\\admin\\Desktop\\Selenium\\ExcelRead\\src\\main\\resources\\ReadData.xlsx");
	int totalNoOfRows=ref.getRowCount(0);
	
	Object[][] loginDataSet=new Object[totalNoOfRows-1][2];
	
	for(int row=1;row<totalNoOfRows;row++)// 0th row is heading so starting from 1
	{
	
		loginDataSet[row-1][0]=ref.getData(0,row,0);//for each cell value 
		loginDataSet[row-1][1]=ref.getData(0,row,1);
	
	}
	
	System.out.println(loginDataSet.length);
	return loginDataSet;
	
}
@Test(dataProvider ="logindata" )
public void test_loginCredential(String emailid,String password)
{
	if(emailid!=null && password!=null) {
		loginpage.accountBy();
		loginpage.loginBy();
		loginpage.emailidBy(emailid);
		loginpage.passwordBy(password);
		loginpage.loginButtonBy();
	}
		
	
}
}
