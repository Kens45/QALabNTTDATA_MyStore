package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductsPage {

    public static By firstProduct = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");
    public static By quantityField = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By addToCartButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By productName = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/h6");
    public static By productPrice = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By quantity = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By totalPrice = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By buyButton = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By currencyButton = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/button");
    public static By currencyOptions = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/ul");
    public static By dollarOption = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/ul/li[2]/a");
}
