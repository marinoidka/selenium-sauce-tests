package ru.marinoidka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.marinoidka.elements.FooterPageElements;


import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;


public class InventoryPage extends BasePage implements FooterPageElements {

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkCartOnThePage() {
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo(0)));
        return this;
    }

    public InventoryPage getProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        return this;
    }

    public CartPage clickCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
        return new CartPage(driver);
    }

}
