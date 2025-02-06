package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
       // driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click(); //using parent child treverse

        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //using index
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='ATQ']")).click(); //using parent child treverse
        driver.close();

    }
}
