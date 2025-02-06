package Practice.Day9;

import Practice.Day1.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddToCart {
    public static void main(String[] args) {
        WebDriver driver=new WebdriverManager().getDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        String [] itemNeeded={"Beetroot", "Tomato","Beans"};
        addToCart(driver,itemNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());


        driver.quit();
    }
    public static void addToCart(WebDriver driver, String [] itemNeeded){
        int j=0;
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));


        for(int i=0;i<products.size();i++){
            String[] productText=products.get(i).getText().split("-");
            String finalProduct=productText[0].trim();
            List itemNeedList= Arrays.asList(itemNeeded);

            if(itemNeedList.contains(finalProduct)){
                j++;
                driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
                System.out.println(finalProduct + "Added to cart");
                if(j==itemNeeded.length)
                    break;
            }
        }

    }

}
