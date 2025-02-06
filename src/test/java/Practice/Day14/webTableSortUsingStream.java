package Practice.Day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class webTableSortUsingStream {
    @Test
    public void validateTableData(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//thead/tr/th[1]")).click();
        //capture all the webelements into list
        List<WebElement> elements=driver.findElements(By.xpath("//tr/td[1]"));
       // capture text of all webelements into new (original) list)
        List<String> orginalList =elements.stream().map(s->s.getText()).collect(Collectors.toList());
        // sort on the original list of step3 -> soted listed
        List<String>sortedList=orginalList.stream().sorted().collect(Collectors.toList());
       // Compare orginal list vs sorted list
        Assert.assertTrue(orginalList.equals(sortedList));
      //  scan the name coulmn with get text -> Beans -> print the price of the beans
         List<String> price= elements.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggies(s)).collect(Collectors.toList());
         price.forEach(t-> System.out.println(t));



    }
    public String getPriceVeggies(WebElement s){
        String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;

    }
}
