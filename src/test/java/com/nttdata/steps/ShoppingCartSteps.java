package com.nttdata.steps;


import com.nttdata.page.ShoppingCartPage;
import org.openqa.selenium.WebDriver;


public class ShoppingCartSteps {

    private WebDriver driver;

    public ShoppingCartSteps(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(ShoppingCartPage.cartTitle).getText();
    }

    public double getProductPrice(){
       String price = driver.findElement(ShoppingCartPage.productPrice).getText().replace(" $", "").replace(",",".").trim();
       return Double.parseDouble(price);
    }

    public int getQuantity(){
        String quantity = driver.findElement(ShoppingCartPage.productQuantity).getAttribute("value");
        return Integer.parseInt(quantity);
    }

    public double getTotalPrice(){
        String totalPrice = driver.findElement(ShoppingCartPage.totalPrice).getText().replace(" $", "").replace(",",".").trim();
        return Double.parseDouble(totalPrice);
    }

}
