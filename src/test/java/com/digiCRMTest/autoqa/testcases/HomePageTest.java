package com.digiCRMTest.autoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.digiCRMTest.autoqa.base.TestBase;
import com.digiCRMTest.autoqa.pages.HomePage;
import com.digiCRMTest.autoqa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		homePage=new HomePage();
		
	}
	
	@Test
	public void homePageTitleTest()
	{
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle,"Cogmento CRM and Business Cloud Solutions");
	}
	
	@Test
	public void LoginButtonTest()
	{
		loginPage=homePage.gotoLogInPage();
		
		String actualTitle=loginPage.getLoginPageTitle();
		
		Assert.assertEquals(actualTitle, "Cogmento CRM");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
