package Practice.Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int rows =driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
        int columns=driver.findElements(By.cssSelector("table[name='courses'] tr th")).size();
        System.out.println("Number of Rows in the table are: "+rows);
        System.out.println("Number of Columns in the table are: "+columns);
        List<WebElement> row2=driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(3) td"));
        for(int i=0;i< row2.size();i++){
            System.out.println(row2.get(i).getText());

        }
        driver.close();
    }
}
