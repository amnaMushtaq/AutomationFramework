package Practice.Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import static java.awt.SystemColor.window;

public class javaScriptExecutorPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> values=driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-of-type(4)"));
        int sum=0;
        for(int i=0;i<values.size();i++){
            sum=sum+Integer.parseInt(values.get(i).getText());

        }
        System.out.println(sum);
        int total=Integer.parseInt(driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,total);

        List<WebElement> prices=driver.findElements(By.cssSelector("table[name='courses'] td:nth-child(3)"));
        int sum1=0;
        for(int i=0;i<prices.size();i++){
            int price=Integer.parseInt(prices.get(i).getText());
            sum1=sum1+price;
            //System.out.println(sum1);
        }
        System.out.println(sum1);
    }
}
