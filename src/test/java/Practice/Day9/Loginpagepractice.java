package Practice.Day9;

import Practice.Day1.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Loginpagepractice {
    public static void main(String[] args) {
        WebDriver driver=new WebdriverManager().getDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        login(driver,wait);
        adItemsToCart(driver,wait);


    }
    public static void login(WebDriver driver,WebDriverWait wait){
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog.modal-confirm")));
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        WebElement staticdropdown= driver.findElement(By.cssSelector("*[data-style='btn-info']"));
        Select option=new Select(staticdropdown);
        option.selectByValue("consult");
        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.id("signInBtn")).click();

    }
    public static void adItemsToCart(WebDriver driver, WebDriverWait wait){


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-list/app-card//button")));

        List<WebElement> cartButtons = driver.findElements(By.xpath("//app-card-list/app-card//button"));
        for (int i=0;i<cartButtons.size();i++){
            cartButtons.get(i).click();

        }
        driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();
    }
}
