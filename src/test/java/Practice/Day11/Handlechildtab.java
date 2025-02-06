package Practice.Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Handlechildtab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<WebElement> firstcolumn=driver.findElements(By.cssSelector("div[id='gf-BIG'] table tbody tr td:nth-of-type(1) a"));
        int sizeofColumn=firstcolumn.size();
        System.out.println(sizeofColumn);
        for(int i=1;i<sizeofColumn;i++) {
            String clickLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstcolumn.get(i).sendKeys(clickLinkTab);
            Thread.sleep(5000);
        }

           Set<String> windows = driver.getWindowHandles();
           Iterator<String> it= windows.iterator();
           while(it.hasNext()){

               driver.switchTo().window(it.next());
               System.out.println(driver.getTitle());
           }




        driver.quit();

    }
}
