package Practice.Day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) {
        //WebDriver driver=new WebdriverManager().getDriver();
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        Actions a=new Actions(driver);
        WebElement source=driver.findElement(By.cssSelector("#draggable"));
        WebElement target=driver.findElement(By.cssSelector("#droppable"));
        a.dragAndDrop(source,target).build().perform();

        driver.switchTo().defaultContent();
    }
}
