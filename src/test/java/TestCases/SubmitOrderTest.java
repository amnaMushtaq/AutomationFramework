package TestCases;

import PageObject.LoginPage.*;
import TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class SubmitOrderTest extends BaseTest {
   // String prodName = "QWERTY";

    @Test(dataProvider="getData")
    public void submitOrder(String email, String password, String prodName) throws InterruptedException, IOException {
        CatalogPage catalogProducts=landingPage.loginApplication(email, password);
        List<WebElement> products=catalogProducts.getProductList();
        catalogProducts.addProductToCart(prodName);
        CartPage cartPage=catalogProducts.goToCartPage();
        Boolean match =cartPage.verifyProductInCart(prodName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage=cartPage.goToCheckout();
        checkoutPage.selectCountry("aus");
         ConfirmationPage confirmationPage=checkoutPage.placeOrder();
         String successMessage= confirmationPage.getConfirmationMessage();
        Assert.assertTrue(successMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."), "Success message did not match expected value.");

    }
    @Test(dataProvider = "getHashMapDatafromJSON")
    public void orderHistory(HashMap<String,String> input) throws InterruptedException, IOException {
        //String prodName = "QWERTY";
        CatalogPage catalogProducts=landingPage.loginApplication(input.get("email"),input.get("password"));
        OrderPage orderPage=landingPage.goToOrderPage();
        Boolean match=orderPage.verifyOrderDisplay(input.get("prodName"));
        Assert.assertTrue(match);
    }


    @DataProvider
    public Object[][] getData(){
        return new Object[][]{{"admintest@gmail.com","Admintest123","QWERTY"},{"admin25@gmail.com","Admin123","IPHONE 13 PRO"}};
    }

    @DataProvider
    public Object[][] getHashMapData(){
        HashMap<String,String> data=new HashMap<String,String>();
        data.put("email","admintest@gmail.com");
        data.put("password","Admintest123");
        data.put("prodName","QWERTY");
        HashMap<String,String> data1=new HashMap<String,String>();

        data1.put("email","admin25@gmail.com");
        data1.put("password","Admin123");
        data1.put("prodName","IPHONE 13 PRO");

        return new Object[][]{{data},{data1}};
    }

    @DataProvider
    public Object[][] getHashMapDatafromJSON() throws IOException {
        List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json");


        return new Object[][]{{data.get(0)},{data.get(1)}};
    }
}



