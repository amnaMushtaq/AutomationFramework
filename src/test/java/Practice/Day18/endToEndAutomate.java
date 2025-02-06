package Practice.Day18;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class endToEndAutomate {
    @Test
    public void test() throws InterruptedException {
        String prodName="QWERTY";
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("admin25@gmail.com");
        driver.findElement(By.cssSelector("#userPassword")).sendKeys("Admin123");
        driver.findElement(By.cssSelector("#login")).click();
        // Wait for at least one product card to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='row']//div[@class='card']")));

// Locate all product cards after waiting
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='row']//div[@class='card']"));
        System.out.println("Number of products found: " + products.size());

        for (WebElement prod : products) {
            try {
                // Get the product label
                String prodLabel = prod.findElement(By.cssSelector("h5 b")).getText();
                System.out.println("Product label: " + prodLabel);

                // Check if the product matches the desired name
                if (prodLabel.equals(prodName)) {
                    // Click the "Add to Cart" button
                    prod.findElement(By.cssSelector("[class*='cart']")).click();
                    break; // Exit the loop after finding the desired product
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element not found inside product card: " + e.getMessage());
            }
        }


//        int size=driver.findElements(By.cssSelector("[class='card']")).size();
//        System.out.println(size);
//        for (WebElement prod: products){
//            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(prod, By.cssSelector("div h5 b")));
//             String prodlabel=prod.findElement(By.cssSelector("div h5 b")).getText();
//            System.out.println("Product label: "+prodlabel);
//             if(prodlabel.equals(prodName)){
//                 prod.findElement(By.cssSelector("[class*='cart']")).click();
//             }
//        }
  //      WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".la-ball-scale-multiple")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        Thread.sleep(300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[routerlink*='cart']")));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='cart'] h3")));
        List<WebElement> cartProds=driver.findElements(By.cssSelector("[class='cart'] h3"));
        Boolean match=cartProds.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(prodName));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector("[class='totalRow'] button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
        // Locate the input element and send the keys directly
        WebElement inputElement = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
        inputElement.sendKeys("aus");  // Directly send keys to the input field
        Thread.sleep(300);
 //Wait for options to appear
        driver.findElement(By.cssSelector("[class*='ta-results'] button:nth-of-type(1)")).click();
//        List<WebElement> options=driver.findElements(By.cssSelector("[class*='ta-results'] button"));
//
//        options.stream().filter(option-> option.getText().trim().equalsIgnoreCase("Australia"))
//                .findFirst()
//                .ifPresent(option->
//        {
//            try{
//                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", option);
//                Thread.sleep(300);
//                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", option);
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        });
        WebElement submitBtn=driver.findElement(By.xpath("//*[contains(text(), 'Place Order')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",submitBtn);
      //  Thread.sleep(300);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Order Placed Successfully']")));
        // Wait for the visibility of the element
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='hero-primary']")));

// Find the success message element
        WebElement successMessageElement = driver.findElement(By.cssSelector("h1[class='hero-primary']"));

// Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", successMessageElement);

// Get the text of the success message
        String successMessage = successMessageElement.getText().trim();
        System.out.println(successMessage);

// Assert that the success message matches the expected text
        Assert.assertTrue(successMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."),"Success message did not match expected value.");







    }
}
