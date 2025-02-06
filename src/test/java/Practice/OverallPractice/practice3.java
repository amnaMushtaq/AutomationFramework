package Practice.OverallPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import org.apache.commons.io.FileUtils;

public class practice3 {
    @Test
    public void newTabTitle() throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> firstColumn=driver.findElements(By.cssSelector("div[id='gf-BIG'] table tr td:nth-child(1) a"));
        for (int i=0;i<firstColumn.size();i++){
           String newTabClick= Keys.chord(Keys.CONTROL,Keys.ENTER);
           firstColumn.get(i).sendKeys(newTabClick);
        }
        Set<String> windows=driver.getWindowHandles();
        Iterator<String>it=windows.iterator();
        while(it.hasNext()){
            //it.next();
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
            //File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(src,new File("C:\\Users\\mushtamn"));
            String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath= "src/test/resources/screenshot/" + "Example" + "_"+ timestamp+ ".png";
            File screenshot=    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File destination= new File(System.getProperty("user.dir")+"/"+filePath);
         //   FileUtils.copyFile(screenshot,destination);
            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());



        }
        driver.quit();


    }
}
