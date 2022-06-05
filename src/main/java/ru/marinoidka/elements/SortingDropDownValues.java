package ru.marinoidka.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.marinoidka.pages.LoginPage;

import java.util.List;
import java.util.stream.Collectors;

import static ru.marinoidka.pages.BasePage.driver;

public enum SortingDropDownValues {
    NAME_ASC(By.cssSelector("[data-test=product_sort_container] > [value=az]"), "Name (A to Z)"),
    NAME_DESC(By.cssSelector("[data-test=product_sort_container] > [value=za]"), "Name (Z to A)"),
    PRICE_ASC(By.cssSelector("[data-test=product_sort_container] > [value=lohi]"), "Name (Price (low to high))"),
    PRICE_DESC(By.cssSelector("[data-test=product_sort_container] > [value=hilo]"), "Name (Price (high to low))");


    @Getter
    By elementLocator;
    @Getter
    String title;
    SortingDropDownValues( By cssSelector, String title) {
        this.elementLocator = cssSelector;
        this.title = title;
    }

    public SortingDropDownValues getByValue(String title) {
        return SortingDropDownValues.valueOf(title);
    }

}