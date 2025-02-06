package PageObject.LoginPage;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfirmationPage extends AbstractComponent {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css ="h1[class='hero-primary']")
    WebElement headerSuccessMsg;





    public String getConfirmationMessage(){
// Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerSuccessMsg);

// Get the text of the success message
        String successMessage = headerSuccessMsg.getText().trim();
        System.out.println("Success Message: "+ successMessage);
        return successMessage;
    }
}
