package Practice.OverallPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class paginationPractice {
    @Test
    public void pagination(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//thead/tr/th[1]")).click();
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.cssSelector("tr td:nth-of-type(1)"));

            price=rows.stream().filter(s -> s.getText().contains("Orange")).map(s -> getVeggiesPrice( s)).collect(Collectors.toList());
            price.forEach(s-> System.out.println(s));
            if(price.size()<1){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while(price.size()<1);

    }
    public String getVeggiesPrice(WebElement s){
        String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;


    }

}
