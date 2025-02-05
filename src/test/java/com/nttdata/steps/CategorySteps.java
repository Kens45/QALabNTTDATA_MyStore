package com.nttdata.steps;


import com.nttdata.page.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class CategorySteps {

    private WebDriver driver;

    public CategorySteps(WebDriver driver){
        this.driver = driver;
    }

    public void selectCategory(String category){
        List<WebElement> categories = driver.findElement(By.xpath("//*[@id='top-menu']")).findElements(By.tagName("li"));
        for (WebElement c : categories) {
            if (c.getText().equalsIgnoreCase(category)) {
                c.click();
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }

    public void selectSubcategory(String subcategory){
        List<WebElement> subcategories = driver.findElement(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]")).findElements(By.tagName("li"));
        for (WebElement s : subcategories) {
            if (s.getText().equalsIgnoreCase(subcategory)) {
                s.click();
                break;
            }
        }
    }

    public boolean checkCategory(String category) {
        try {
            List<WebElement> categories = driver.findElement(By.xpath("//*[@id='top-menu']")).findElements(By.tagName("li"));
            for (WebElement c : categories) {
                if (c.getText().equalsIgnoreCase(category)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkSubcategory(String subcategory) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
            List<WebElement> subcategories = driver.findElement(By.xpath("//ul[@data-depth='1'][.//*[@id='category-4']]")).findElements(By.tagName("li"));
            for (WebElement s : subcategories) {
                if (s.getText().equalsIgnoreCase(subcategory)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Subcategory not found " + subcategory);
            return false;
        }
    }


}
