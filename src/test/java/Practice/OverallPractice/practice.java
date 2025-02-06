package Practice.OverallPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class practice {
    @Test
    public void splitString() throws InterruptedException {
//        String s = "khan Cricket academy";
//        String[] splitted = s.split(" ");
//        //System.out.println(splitted[0].trim());
//        for(int i=0;i<s.length();i++){
//            //System.out.println( splitted[i].trim());
//            System.out.println(s.charAt(i));
//        }
//        System.out.println("****************************Reverse order **************");
//        for(int i=s.length()-1;i>=0;i--){
//            //System.out.println( splitted[i].trim());
//            System.out.println(s.charAt(i));
            WebDriver driver=new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
//            Wait<WebDriver> fluentwait=new FluentWait<>(driver)
//                    .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
          //  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//            WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
//            Select option=new Select(staticDropDown);
//            option.selectByValue("option3");
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            driver.manage().window().maximize();
            driver.findElement(By.id("autosuggest")).sendKeys("aus");
            Thread.sleep(3000);
            List <WebElement> suggestions=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//            for (int k=0;k<suggestions.size();k++){
//                String suggetionText=suggestions.get(k).getText();
//                if(suggetionText.equalsIgnoreCase("Australia")){
//                    ((JavascriptExecutor) driver).executeScript("argumnet[0].scrollintoView",suggetionText);
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",suggetionText);
////                    suggestions.get(k).click();
//                    break;
//                }
                for (WebElement suggestion: suggestions){
                    if(suggestion.getText().equalsIgnoreCase("Australia")){
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",suggestion);
                        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",suggestion);
                        break;
                    }
                }



            }
//            driver.get("https://www.cypress-outdoorliving.com/");
//            Actions a=new Actions(driver);
//            WebElement element=driver.findElement(By.cssSelector(".nav-item dropdown"));
//            a.moveToElement(element).build().perform();
    // Thread.sleep(3000);

//                option.click();
//                break;






        }


