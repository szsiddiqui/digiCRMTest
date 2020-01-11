package com.digiCRMTest.autoqa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import com.digiCRMTest.autoqa.Util.TestUtil;
import com.digiCRMTest.autoqa.base.TestBase;
import com.digiCRMTest.autoqa.pages.ContactsPage;
import com.digiCRMTest.autoqa.pages.HomePage;
import com.digiCRMTest.autoqa.pages.LoginPage;
import com.digiCRMTest.autoqa.pages.UserLandingPage;

public class ContactsPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	
	UserLandingPage userLandingPage;
	
	ContactsPage contactsPage;
	
	TestUtil crmUtil;
	
	String sheetName= "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = crmUtil.getTestData("Contacts");
		return data;
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
		loginPage = homePage.gotoLogInPage();
		
		String emailID=prop.getProperty("email");
		String password=prop.getProperty("password");
		
		userLandingPage=loginPage.loginCRM(emailID, password);
		contactsPage = userLandingPage.gotoContactsPage();
		crmUtil = new TestUtil();
	}
	
	@Test
	public void contactsPageTitleTest()
	{
		String contactsPageHeader = contactsPage.getContactsPageUITitle();
		Reporter.log("Contacts Page Header:" +contactsPageHeader);
		Assert.assertEquals(contactsPageHeader, "Contacts");
	}
	
	//@Test(dataProvider="getCRMTestData")
	//public void createNewContactTest(String fname,String lname) throws IOException
	//{
	//	contactsPage.createNewContact(fname,lname);
	//	TestUtil.takeScreenshotAtEndOfTest();
	//}
	
	//@Test
	//public void verifyContactsPagelabel()
	//{
		//Assert.assertTrue(contactsPage.verifyContactslabel(),"Contacts label is missing on the page");
	//}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
}
