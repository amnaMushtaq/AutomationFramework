
package TestCases;

import PageObject.LoginPage.CartPage;
import PageObject.LoginPage.CatalogPage;
import PageObject.LoginPage.CheckoutPage;
import PageObject.LoginPage.ConfirmationPage;
import TestComponents.BaseTest;
import TestComponents.Retry;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;




public class ErrorValidationsTest extends BaseTest {


    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void loginErrorValidation() throws InterruptedException, IOException {
        landingPage.loginApplication("admin25@gmail.com", "Admn123");
        String errorMessage=landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email  password.",errorMessage);

    }
    @Test(groups = {"ErrorHandling"})
    public void ProductErrorValidation() throws InterruptedException, IOException {
        String prodName = "QWERTY";
        CatalogPage catalogProducts=landingPage.loginApplication("admin25@gmail.com", "Admin123");
        List<WebElement> products=catalogProducts.getProductList();
        catalogProducts.addProductToCart(prodName);
        CartPage cartPage=catalogProducts.goToCartPage();
        Boolean match =cartPage.verifyProductInCart("QWety");
        Assert.assertFalse(match);





    }

}



