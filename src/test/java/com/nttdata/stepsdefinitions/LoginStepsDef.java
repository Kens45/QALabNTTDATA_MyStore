package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CategorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.ProductsSteps;
import com.nttdata.steps.ShoppingCartSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class LoginStepsDef {

    private WebDriver driver;
    private ProductsSteps productsSteps(WebDriver driver) {
        return new ProductsSteps(driver);
    };
    private ShoppingCartSteps shoppingCartSteps(WebDriver driver) {
        return new ShoppingCartSteps(driver);
    };

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.signInAccess();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
        loginSteps.login();
        screenShot();
        if(!loginSteps.validateCredentials()){
            driver.close();
        }
        Assertions.assertTrue(loginSteps.validateCredentials(), "Credenciales inválidas");
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        productsSteps(driver).changeCurrency();
        CategorySteps categorySteps = new CategorySteps(driver);
        Assertions.assertTrue(categorySteps.checkCategory(category), "Categoría inválida");
        categorySteps.selectCategory(category);
        screenShot();
        Assertions.assertTrue(categorySteps.checkSubcategory(subcategory), "Subcategoría inválida");
        categorySteps.selectSubcategory(subcategory);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int quantity) {
        productsSteps(driver).selectProduct();
        screenShot();
        productsSteps(driver).selectQuantity(quantity);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        productsSteps(driver).addToCart();
        screenShot();
        Assertions.assertEquals("Hummingbird printed t-shirt", productsSteps(driver).getProductName());
        Assertions.assertEquals("5,00 $", productsSteps(driver).getProductPrice());
        Assertions.assertEquals("2", productsSteps(driver).getProductQuantity());
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        double productPrice = Double.parseDouble(productsSteps(driver).getProductPrice().replace(" $", "").replace(",",".").trim());
        int productQuantity = Integer.parseInt(productsSteps(driver).getProductQuantity());
        double expectedTotalPrice = productPrice * productQuantity;

        double actualTotalPrice = Double.parseDouble(productsSteps(driver).getTotalPrice().replace(" $", "").replace(",",".").trim());
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        productsSteps(driver).buyProduct();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        Assertions.assertEquals("CARRITO", shoppingCartSteps(driver).getTitle());
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        double productPrice = shoppingCartSteps(driver).getProductPrice();
        int productQuantity = shoppingCartSteps(driver).getQuantity();
        double expectedTotalPrice = productPrice * productQuantity;

        double actualTotalPrice = shoppingCartSteps(driver).getTotalPrice();
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }
}
