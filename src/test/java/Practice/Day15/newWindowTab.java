package Practice.Day15;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


public class newWindowTab {

    @Parameters({"WindowURL"})
    @Test(groups = {"Smoke"})

    public void openNewTab(String wURL) throws IOException {
        WebDriver driver = new ChromeDriver();
       // System.out.println(wURL);
        driver.get(wURL);
        driver.manage().window().maximize();
       driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentwindow=it.next();
        String childwindow= it.next();
        driver.switchTo().window(childwindow);
        driver.get("https://rahulshettyacademy.com/");
        String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
        driver.switchTo().window(parentwindow);
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);
        File file=name.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file,new File("logo.png"));
        //Get width & Height
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        driver.quit();
    }
}
