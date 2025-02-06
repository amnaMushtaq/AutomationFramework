package Practice.OverallPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class practice1 {
   @Test
    public void addToCart(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        driver.manage().window().maximize();
        String[] itemNeeded={"Almonds","Mango","Onion"};
        addtoCart(driver,itemNeeded);


       // driver.findElements();
    }
    public static void addtoCart(WebDriver driver,String[] itemNeeded){
        int j = 0;
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i< products.size();i++){
            String productName=products.get(i).getText().split("-")[0].trim();
            List listItemNeeded = Arrays.asList(itemNeeded);

            if(listItemNeeded.contains(productName)){
                j++;

                WebElement productAddButton=driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",productAddButton);
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();",productAddButton);
//                WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='product-action'] button"))).click();
                //driver.findElement(By.cssSelector()).click();
                System.out.println(productName + " Added to the cart");

                if(j==itemNeeded.length){
                    break;
                }


            }
        }


    }
}
