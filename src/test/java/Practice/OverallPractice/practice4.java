package Practice.OverallPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class practice4 {
    @Test
    public void brokenURL() throws IOException {
        WebDriver driver=new ChromeDriver();
        SoftAssert a=new SoftAssert();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> brokenLinks=driver.findElements(By.cssSelector("[class='gf-li'] a"));
        for(WebElement link:brokenLinks){
            String url=link.getAttribute("href");
            HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resCode=conn.getResponseCode();
            a.assertTrue(resCode<400,"The Link with the Text "+link.getText()+ " is broken with the status code "+ resCode);
        }
        a.assertAll();


    }
}
