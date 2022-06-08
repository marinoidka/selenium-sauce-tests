package ru.marinoidka.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.InventoryPage;
import ru.marinoidka.pages.LoginPage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static ru.marinoidka.elements.SortingDropDownValues.*;

@Epic("Основные тесты")
@Feature("Тесты на сортировку")
public class SortingProductsTests extends BaseTest {


    public static List<String> initialSortingProductList;
    public static List<Double> initialSortingProductListByPrice;

    @Step("Логинимся на сайте и получаем список товаров в начальной сортировке")
    @BeforeEach
    public void goInventory() {
        initialSortingProductList = new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .inventoryProductList();
        initialSortingProductListByPrice = new InventoryPage(driver)
                .inventoryProductListByPrice();

    }

    @Step("Проверяем сортировку по имени по возрастанию")
    @Test
    void sortingByNameASCTest() {
        new InventoryPage(driver)
                .chooseSortingOption(NAME_ASC);

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        initialSortingProductList.sort(Comparator.naturalOrder());
        assertEquals(listOfProductNames, initialSortingProductList);
    }

    @Step("Проверяем сортировку по имени по убыванию")
    @Test
    void sortingByNameDESCTest() {
        new InventoryPage(driver)
                .chooseSortingOption(NAME_DESC);

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        initialSortingProductList.sort(Comparator.reverseOrder());
        assertEquals(listOfProductNames, initialSortingProductList);
    }

    @Step("Проверяем сортировку по цене по убыванию")
    @Test
    void sortingByPriceDESCTest() {
        new InventoryPage(driver)
                .chooseSortingOption(PRICE_DESC);
        List<Double> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_price"))
                .stream().map(webElement -> webElement.getText().substring(1))
                .mapToDouble(webElement -> Double.parseDouble(webElement))
                .boxed()
                .collect(Collectors.toList());
        initialSortingProductListByPrice.sort(Comparator.reverseOrder());
        assertEquals(listOfProductNames, initialSortingProductListByPrice);
    }

    @Step("Проверяем сортировку по цене по возрастанию")
    @Test
    void sortingByPriceASCTest() {
        new InventoryPage(driver)
                .chooseSortingOption(PRICE_ASC);
        List<Double> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_price"))
                .stream().map(webElement -> webElement.getText().substring(1))
                .mapToDouble(webElement -> Double.parseDouble(webElement))
                .boxed()
                .collect(Collectors.toList());
        initialSortingProductListByPrice.sort(Comparator.naturalOrder());
        assertEquals(listOfProductNames, initialSortingProductListByPrice);
    }

    @Step("Разлогин")
    @AfterEach
    public void logOut() {
        new BaseAuthorisedPage(driver)
                .logOut();
    }

}
