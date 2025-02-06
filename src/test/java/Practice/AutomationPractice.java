package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractice {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","C:/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());
        driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
    }
}
