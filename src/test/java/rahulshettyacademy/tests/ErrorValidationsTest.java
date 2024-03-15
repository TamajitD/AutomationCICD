package rahulshettyacademy.tests;

import rahulshettyacademy.TestComponents.Retry;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class) 

	
	
	
	public void LoginErrorValidation() throws IOException, InterruptedException{
	landingPage.loginApplication("damtamajit@gmail.com", "Shelly@743559");
		//div[aria-label='Incorrect email or password.']
	Assert.assertEquals("Incorrect email or password", landingPage.ErrorMessage());
		
		}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("tamajittuhindam@gmail.com", "Shelly@743559");
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
        
	}
	
	

}
