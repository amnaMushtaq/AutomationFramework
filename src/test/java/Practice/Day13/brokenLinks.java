package Practice.Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class brokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for (WebElement link : links){
            String url= link.getAttribute("href");
             HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
             conn.setRequestMethod("HEAD");
             conn.connect();
             int respCode=conn.getResponseCode();
            System.out.println(respCode);
//             if(respCode>400){
//                 System.out.println("The link with Text "+ "'"+ link.getText()+"'"+" is broken with code "+respCode );
//                 Assert.assertTrue(false);
//             }
             Assert.assertTrue(respCode<400,"The link with Text "+ "'"+ link.getText()+"'"+" is broken with code "+respCode );

        }



    }


}
