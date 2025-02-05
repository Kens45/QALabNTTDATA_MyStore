package com.nttdata.steps;


import com.nttdata.page.ProductsPage;
import com.nttdata.page.ShoppingCartPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductsSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    public ProductsSteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void changeCurrency(){
        WebElement element = driver.findElement(ProductsPage.currencyButton);
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.currencyOptions));
        WebElement currency = driver.findElement(ProductsPage.dollarOption);
        currency.click();
    }

    public void selectProduct(){
        WebElement firstProduct = driver.findElement(ProductsPage.firstProduct);
        firstProduct.click();
    }

    public void selectQuantity(int quantity){
        WebElement quantityField = driver.findElement(ProductsPage.quantityField);
        quantityField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        quantityField.sendKeys(String.valueOf(quantity));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.addToCartButton));
    }

    public void addToCart(){
        WebElement addToCartButton = driver.findElement(ProductsPage.addToCartButton);
        addToCartButton.click();
    }

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.productName));
        return driver.findElement(ProductsPage.productName).getText();
    }

    public String getProductPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.productPrice));
        return driver.findElement(ProductsPage.productPrice).getText();
    }

    public String getProductQuantity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.quantity));
        return driver.findElement(ProductsPage.quantity).getText();
    }

    public String getTotalPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.totalPrice));
        return driver.findElement(ProductsPage.totalPrice).getText();
    }

    public void buyProduct(){
        WebElement buyButton = driver.findElement(ProductsPage.buyButton);
        buyButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.cartTitle));
    }
}