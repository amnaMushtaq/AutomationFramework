package PageObject.LoginPage;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class*='cart']")
    WebElement cartBtn;

    @FindBy(css="[class='cart'] h3")
    List<WebElement> cartDetails;

    @FindBy(css="[class='totalRow'] button")
    WebElement checkoutBtn;


    By cartGrid=By.cssSelector("[class='cart'] h3");


    public Boolean verifyProductInCart(String prodName)  {
        waitForElementToBeVisible(cartGrid);


        Boolean match = cartDetails.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(prodName));
        return match;

    }
    public CheckoutPage goToCheckout()  {
        checkoutBtn.click();
        return new CheckoutPage(driver);

    }

}
