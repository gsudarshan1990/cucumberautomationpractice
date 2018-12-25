package steps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberautomationpractice.HomePageObjects;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinitionClass {
	
	public static final String CHROME_KEY="webdriver.chrome.driver";
	public static final String CHROME_PATH="C:\\SeleniumDriversImportant\\chromedriver.exe";
	public static WebDriver driver;
	HomePageObjects hpo , hpo1,hpo2,hpo3,hpo4,hpo5,hpo6;
	List<WebElement> products;
	int productCountFromText;
	String productName;
	List<WebElement> rows;
	List<WebElement> columns;
	boolean compare;
	@Before
	public void init()
	{
		System.setProperty(CHROME_KEY, CHROME_PATH);
		driver=new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Given("^User enters the homepage$")
	public void user_enters_the_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("^User checks tabs exists$")
	public void user_checks_tabs_exists() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hpo=new HomePageObjects();
		Assert.assertTrue(hpo.getWomenTab().isEnabled());
		Assert.assertTrue(hpo.getDressTab().isEnabled());
		Assert.assertTrue(hpo.getTshirtTab().isEnabled());
	}	

	
	
	

	

	@Given("^User on home Page$")
	public void user_on_home_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		hpo1=new HomePageObjects();
	}

	@When("^User enters valid email address$")
	public void user_enters_valid_email_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Random r=new Random();
	    int value=r.nextInt(5000);
	    String email="sudarshan"+value+"@gmail.com";
	    hpo1.getNewsLetterTab().sendKeys(email);
	    hpo1.getNewsLetterButton().click();
	  
	}

	@Then("^Subscription message is displayed$")
	public void subscription_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement message=driver.findElement(By.xpath("//p[contains(@class,'alert-success')]"));
		String msg=message.getText();
		System.out.println(msg);
		Assert.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", msg);
	}

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hpo2=new HomePageObjects();
	}

	@When("^User clicks on the WOMEN$")
	public void user_clicks_on_the_WOMEN() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   hpo2.getWomenTab().click();
	}

	@Then("^user enters corresponding WOMEN$")
	public void user_enters_corresponding_WOMEN() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 
		Assert.assertTrue(hpo2.getTitle().contains("Women"));
	}

	@When("^User clicks on the DRESSES$")
	public void user_clicks_on_the_DRESSES() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hpo2.getDressTab().click();
	}

	@Then("^user enters corresponding DRESSES$")
	public void user_enters_corresponding_DRESSES() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(hpo2.getTitle().contains("Dresses"));
	}

	@When("^User clicks on the T-SHIRTS$")
	public void user_clicks_on_the_T_SHIRTS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hpo2.getTshirtTab().click();
	}

	@Then("^user enters corresponding T-SHIRTS$")
	public void user_enters_corresponding_T_SHIRTS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(hpo2.getTitle().contains("T-shirts"));
	}
	
	@Given("^User clicks DressesPage$")
	public void user_clicks_DressesPage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hpo3=new HomePageObjects();
		hpo3.getDressTab().click();
	}

	@Then("^User checks S$")
	public void user_checks_S() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  WebElement element=driver.findElement(By.xpath("//*[@id=\"ul_layered_id_attribute_group_1\"]/li[1]/label/a"));
	  Assert.assertTrue(element.getText().contains("S"));
	}

	@Then("^User checks M$")
	public void user_checks_M() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 WebElement element=driver.findElement(By.xpath("//*[@id=\"ul_layered_id_attribute_group_1\"]/li[2]/label/a"));
	 Assert.assertTrue(element.getText().contains("M"));
	}

	@Then("^User checks L$")
	public void user_checks_L() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   WebElement element=driver.findElement(By.xpath("//*[@id=\"ul_layered_id_attribute_group_1\"]/li[3]/label/a"));
	   Assert.assertTrue(element.getText().contains("L"));
	}
	
	@Given("^User is on DressesPage and calculate number of products present in text$")
	public void user_is_on_DressesPage_and_calculate_number_of_products_present_in_text() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hpo4=new HomePageObjects();
		hpo4.getDressTab().click();
		WebElement element=driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]"));
		
		String msg=element.getText();
		String intvalue=msg.replaceAll("[^0-9]","");
		productCountFromText=Integer.parseInt(intvalue);
		
	}

	@When("^User counts number of products$")
	public void user_counts_number_of_products() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    products=driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
	}

	@Then("^User verify whether products are equal$")
	public void user_verify_whether_products_are_equal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(products.size(), productCountFromText);
	}
	
	@Given("^User is on Dresses Page$")
	public void user_is_on_Dresses_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   hpo5=new HomePageObjects();
	   hpo5.getDressTab().click();
	}

	@When("^Click the products and moves to Cart Page$")
	public void click_the_products_and_moves_to_Cart_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 products=driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
		 for(int i=0;i<products.size();i++)
		 {
			 products.get(i).click();
			 WebDriverWait wait=new WebDriverWait(driver,30);
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")));
			 products.get(i).findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
			 break;
			 
		 }
		 WebDriverWait wait2=new WebDriverWait(driver,30);
		 wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"))));
		 driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	}

	@Then("^Verify the product is displayed on the Cart Page$")
	public void verify_the_product_is_displayed_on_the_Cart_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).isEnabled());
	}
	

	@Given("^User is on Product Page$")
	public void user_is_on_Product_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hpo5=new HomePageObjects();
		hpo5.getDressTab().click();
		products=driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
		for(int i=0;i<products.size();i++)
		{
			products.get(i).click();
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")));
			products.get(i).findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
			break;
		 
		}
		WebDriverWait wait2=new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"))));
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	 
	}

	@Then("^User check Tweet is Displyaed$")
	public void user_check_Tweet_is_Displyaed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement tweetelement=driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[2]/a"));
		Assert.assertTrue(tweetelement.isEnabled());
	}
		
	@Given("^User is on the Product Message$")
	public void user_is_on_the_Product_Message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		hpo5=new HomePageObjects();
		hpo5.getDressTab().click();
		products=driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
		for(int i=0;i<products.size();i++)
		{
			
			products.get(i).click();
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")));
			WebElement element1=products.get(i).findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
			WebElement element=products.get(i).findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]"));
			productName=element1.getText();
			element.click();
			break;
		 
		}
		WebDriverWait wait2=new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"))));
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	 
	  
	}

	@When("^User checks the WebTable$")
	public void user_checks_the_WebTable() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rows=driver.findElements(By.xpath("//*[@id=\"product_3_13_0_0\"]"));
	 columns=rows.get(0).findElements(By.xpath("//*[@id=\"product_3_13_0_0\"]/td[2]"));

	   
	   
	}

	@Then("^user asserts the product message$")
	public void user_asserts_the_product_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	    Assert.assertTrue(columns.get(0).getText().contains(productName));
	}
	
	@Given("^User is on Dresses Pages$")
	public void user_is_on_Dresses_Pages() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   hpo6=new HomePageObjects();
	   hpo6.getDressTab().click();

	}

	@When("^User clicks to Sort from A to Z$")
	public void user_clicks_to_Sort_from_A_to_Z() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element=driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Select sortorderselect=new Select(element);
		sortorderselect.selectByValue("name:asc");
		WebDriverWait wait4=new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/ul/p/img")));
		List<WebElement> allproducts=driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
		String[] order=new String[allproducts.size()];
		for(int i=0;i<allproducts.size();i++)
		{
			int count=i+1;
			WebElement elements=allproducts.get(i).findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+count+"]/div/div[2]/h5/a"));
			order[i]=elements.getText();
		}
		
		
		
		List<String> ToSortString=Arrays.asList(order);
		Collections.sort(ToSortString);
		String[] sortedarray=new String[order.length];
		sortedarray=ToSortString.toArray(sortedarray);
		
		
		compare=Arrays.equals(order, sortedarray);
		
	}

	@Then("^Check whether dressed appeared in the Sorted Order$")
	public void check_whether_dressed_appeared_in_the_Sorted_Order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(compare);
	}
	
}
