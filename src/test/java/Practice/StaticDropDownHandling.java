package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropDown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select dropdown=new Select(staticDropDown);
        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }

}
