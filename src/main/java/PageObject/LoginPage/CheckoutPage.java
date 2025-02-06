package PageObject.LoginPage;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Place Order')]")
    WebElement placeOrderbtn;


    @FindBy(css="[placeholder='Select Country']")
    WebElement selectCountry;

    @FindBy(css="[class*='ta-results'] button:nth-of-type(1)")
    WebElement firstCountry;

    By orderSucessToast =By.cssSelector("[aria-label='Order Placed Successfully']");
    By successMessage=By.cssSelector("h1[class='hero-primary']");


    public void selectCountry(String countryName)throws InterruptedException{
        selectCountry.sendKeys(countryName);  // Directly send keys to the input field
        Thread.sleep(300);
        //Wait for options to appear
        firstCountry.click();

    }
    public ConfirmationPage placeOrder() {


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderbtn);
        //  Thread.sleep(300);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderbtn);
        waitForElementToBeVisible(orderSucessToast);
        waitForElementToBeVisible(successMessage);
        return new ConfirmationPage(driver);


// Assert that the success message matches the expected text

    }
}
