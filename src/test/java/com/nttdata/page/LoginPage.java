package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By signInButton = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");
    public static By userInput = By.xpath("//*[@id=\"field-email\"]");
    public static By passInput = By.xpath("//*[@id=\"field-password\"]");
    public static By loginButton = By.xpath("//*[@id=\"submit-login\"]");

    public static By userName = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span");
    public static By logOutButton = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]");
}
