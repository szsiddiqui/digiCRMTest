package com.digiCRMTest.autoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.digiCRMTest.autoqa.base.TestBase;

public class ContactsPage  extends TestBase{
	
	//PageFactory - OR
	
	@FindBy(xpath="//div[attribute::class='ui header item mb5 light-black\']")
	WebElement contactsPageTitle;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContactsButton;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement contactsFirstNameInp;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement contactsLastNameInp;
	
	
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement contactSaveButton;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	public ContactsPage()
	{
			PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getContactsPageUITitle()
	{
			return contactsPageTitle.getText();
			
	}
	
	public void createNewContact(String first_name, String last_name)
	{
		newContactsButton.click();
		contactsFirstNameInp.sendKeys(first_name);
		contactsLastNameInp.sendKeys(last_name);
		contactSaveButton.click();
	}
	
	public boolean verifyContactslabel(){
		return contactslabel.isDisplayed();
	}
}
