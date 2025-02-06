package Practice;

import Practice.Day1.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AutoSuggestiveDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebdriverManager.getDriver();

      //  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
       // driver.manage().window().maximize();

//        driver.findElement(By.id("autosuggest")).sendKeys("aus");
//       // Thread.sleep(3000);
//        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//        for (WebElement option: options){
//            if(option.getText().equalsIgnoreCase("Australia")){
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
//
//                // Click using JavaScript if necessary
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
//                break;
////                option.click();
////                break;
//            }
//
//        }
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());
        driver.findElement(By.cssSelector("input[value='radio2']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());


    }
}
