package Practice.Day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class pagination {
    public class paginationUsingStream {
        @Test(groups = {"Smoke"})
        public void validateTableData() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            driver.findElement(By.xpath("//thead/tr/th[1]")).click();

            List<String> price;

            do {
                List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
                price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggies(s)).collect(Collectors.toList());
                price.forEach(t -> System.out.println(t));

                if (price.size() < 1) {
                    driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
                }


            } while (price.size() < 1);
        }

        public String getPriceVeggies(WebElement s) {
            String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
            return pricevalue;

        }
    }
}
