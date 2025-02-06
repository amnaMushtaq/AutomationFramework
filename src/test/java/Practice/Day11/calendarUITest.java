package Practice.Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class calendarUITest {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        String month="6";
        String date="15";
        String year="2027";
        String[] expectedList={month, date, year};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("button[class*='react-date-picker__calendar']")).click();
        driver.findElement(By.cssSelector("span[class*='calendar__navigation']")).click();
        driver.findElement(By.cssSelector("span[class*='calendar__navigation']")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        //driver.findElement(By.xpath("//abbr[contains(text(),'June')]")).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        List<WebElement> calendarDate=driver.findElements(By.cssSelector("input[class*='react-date-picker__inputGroup']"));
        for(int i=0;i<calendarDate.size();i++){
            System.out.println(calendarDate.get(i).getAttribute("value"));
            Assert.assertEquals(calendarDate.get(i).getAttribute("value"),expectedList[i]);
        }


    }
}
