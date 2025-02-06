package PageObject.LoginPage;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="tr td:nth-of-type(2)")
    List<WebElement> productNames;

    @FindBy(css="[class*='table-bordered']")
    WebElement tableGrid;

    public Boolean verifyOrderDisplay(String prodName)  {
        waitForWebElementToBeVisbile(tableGrid);
        Boolean match = productNames.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(prodName));
        productNames.forEach(s-> System.out.println("product names"+s));
        return match;

    }
}
