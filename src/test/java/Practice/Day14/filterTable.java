package Practice.Day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

@Test
public class filterTable {
    public void filter() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Rice");
        List<WebElement> veggies =driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(veggies.size(),filteredList.size());

    }
}
