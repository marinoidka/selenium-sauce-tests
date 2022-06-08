package ru.marinoidka.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.marinoidka.elements.SortingDropDownValues;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;


public class InventoryPage extends BaseAuthorisedPage {

    @Getter
    @FindBy(id = "shopping_cart_container")
    WebElement cartContainer;
    @Getter
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;
    @Getter
    @FindBy(css = "[data-test=product_sort_container]")
    WebElement sortingDropdown;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    @Step("Проверяем страницу Inventory")
    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }
    @Step("Проверяем корзину")
    public InventoryPage checkCartOnThePage() {
        assertThat(cartContainer.getSize(), not(equalTo(0)));
        return this;
    }
    @Step("Добавляем продукт {productID} в корзину")
    public InventoryPage getProduct(String productID) {
        driver.findElement(By.id(productID)).click();
        return this;
    }
    @Step("Нажимаем на корзину")
    public CartPage clickCart() {
        cartContainer.click();
        return new CartPage(driver);
    }

    @Step("Сортировка по имени опции текстом")
    public InventoryPage chooseSortingOption(String value) {
        sortingDropdown.click();
        By locator = SortingDropDownValues.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }

    @Step("Сортировка по опции типом ENUM")
    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }

    @Step("Начальная сортировка товаров по имени")
    public List<String> inventoryProductList() {
        List<String> initialSortingProductList = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return initialSortingProductList;
    }

    @Step("Начальная сортировка товаров по цене")
    public List<Double> inventoryProductListByPrice() {
        List<Double> initialSortingProductListByPrice = driver.findElements(By.cssSelector(".inventory_item_price"))
                .stream().map(webElement -> webElement.getText().substring(1))
                .mapToDouble(webElement -> Double.parseDouble(webElement))
                .boxed()
                .collect(Collectors.toList());
        return initialSortingProductListByPrice;
    }

}
