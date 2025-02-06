package PageObject.LoginPage;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class CatalogPage extends AbstractComponent {

    WebDriver driver;

    public CatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card']")
    List<WebElement> products;

    By product1 = By.xpath("//div[@class='card']");
    By spinner = By.cssSelector(".la-ball-scale-multiple");
    By toastMessage = By.id("toast-container");
    By addToCart=By.cssSelector("[class*='cart']");


    public List<WebElement> getProductList() {
        waitForElementToPresent(product1);  // Ensure the product list is loaded
        waitForElementToBeVisible(By.cssSelector("h5 b"));  // Ensure the product names are visible

        List<WebElement> freshProducts = driver.findElements(product1);
        System.out.println("Number of products found: " + freshProducts.size());
        return freshProducts;
    }


    public WebElement getProductByName(String prodName) throws InterruptedException {
        waitForElementToPresent(product1);  // Ensure that product list is loaded

        List<WebElement> freshProducts = driver.findElements(product1);
        System.out.println("Found " + freshProducts.size() + " products.");
        for (WebElement prod : freshProducts) {
            try {
                // Wait for the product label to be visible before attempting to get text
                waitForElementToBeVisible(By.cssSelector("h5 b"));
                WebElement label = prod.findElement(By.cssSelector("h5 b"));
                String prodLabelText = label.getText().trim();
                System.out.println("Product label: " + prodLabelText);

                if (prodLabelText.equalsIgnoreCase(prodName)) {
                    return prod;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Product label not found in this product card: " + e.getMessage());
                freshProducts = driver.findElements(product1);  // Re-fetch the products in case DOM changes
            }
        }

        System.out.println("Product not found: " + prodName);
        return null;
    }




    public void addProductToCart(String prodName) throws InterruptedException {
        WebElement prod = getProductByName(prodName);

        if (prod != null) {

            waitForElementToBeClickable(addToCart);  // Wait for button to be clickable
            WebElement addToCartButton = prod.findElement(addToCart);
            addToCartButton.click();

            waitForElementToBeInvisible(spinner);
            waitForElementToBeVisible(toastMessage);
        } else {
            System.out.println("Product not found: " + prodName);
            throw new RuntimeException("Product not found: " + prodName);
        }
    }




}


