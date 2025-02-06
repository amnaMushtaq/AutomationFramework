package Practice.Day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());

    }
}
