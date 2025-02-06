package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loopingDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        int i=1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());


    }
}
