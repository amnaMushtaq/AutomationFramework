package AbstractComponent;

import PageObject.LoginPage.CartPage;
import PageObject.LoginPage.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="button[routerlink*='cart']")
    WebElement cartIconTop;
    @FindBy(css="button[routerlink*='myorders']")
    WebElement OrderIcon;

    By cartIcon=By.cssSelector("button[routerlink*='cart']");

    public void waitForElementToPresent(By findBy){

         wait.until(ExpectedConditions.presenceOfElementLocated(findBy));


    }

    public void waitForWebElementToBeVisbile(WebElement findBy){

        wait.until(ExpectedConditions.visibilityOf(findBy));


    }
    public void waitForElementToBeInvisible(By findBy){

        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));




    }
    public void waitForElementToBeVisible(By findBy){

        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));



    }
    public void waitForElementToBeClickable(By findBy) {
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public CartPage goToCartPage() throws InterruptedException {

        waitForElementToPresent(cartIcon);

        Thread.sleep(300);
        cartIconTop.click();
        CartPage cartPage=new CartPage(driver);
        return cartPage;

    }

    public OrderPage goToOrderPage() throws InterruptedException {

        waitForWebElementToBeVisbile(OrderIcon);
        Thread.sleep(300);
        OrderIcon.click();
        OrderPage orderPage=new OrderPage(driver);
        return orderPage;

    }
}
