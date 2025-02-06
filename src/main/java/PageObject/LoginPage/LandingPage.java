package PageObject.LoginPage;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(css = "#userEmail")
    WebElement userEmail;
    @FindBy(css="#userPassword")
    WebElement userPassword;
    @FindBy(css="#login")
    WebElement loginBtn;
    @FindBy(css="[class*='toast-message']")
    WebElement errorToastMessage;
    public CatalogPage loginApplication(String email,String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
        return new CatalogPage(driver);
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");

    }
    public String getErrorMessage(){
        waitForWebElementToBeVisbile(errorToastMessage);
        return errorToastMessage.getText();
    }
}
