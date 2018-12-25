package com.cucumberautomationpractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steps.StepDefinitionClass;

public class HomePageObjects {
	
	public HomePageObjects()
	{
		PageFactory.initElements(StepDefinitionClass.driver, this);
	} 
	
	@FindBy(xpath="//a[@title='Women']")
	private WebElement womentab;
	
	@FindBy(xpath="//div/ul/li[2]//a[@title='Dresses']")
	private WebElement dresstab;

	@FindBy(xpath="//ul//li[3]//a[@title='T-shirts']")
	private WebElement tshirtstab;
	
	@FindBy(xpath="//input[@id='newsletter-input']")
	private WebElement newsletter;
	
	@FindBy(xpath="//button[@name='submitNewsletter']")
	private WebElement submitnewsletter;
	
	public WebElement getWomenTab()
	{
		return womentab;
	}
	
	public WebElement getDressTab()
	{
		return dresstab;
	}
	
	public WebElement getTshirtTab()
	{
		return tshirtstab;
	}
	
	public WebElement getNewsLetterTab()
	{
		return newsletter;
	}
	
	public WebElement getNewsLetterButton()
	{
		return submitnewsletter;
	}
	
	public String getTitle()
	{
		return StepDefinitionClass.driver.getTitle();
	}
}
