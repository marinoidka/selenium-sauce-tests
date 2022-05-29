package ru.marinoidka.utils;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TabUtils {
    public static void switchToTheNextTab(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на вторую вкладку
        driver.switchTo().window(tabs.get(1));
    }

    public static void switchToTheNextTabAndBack(WebDriver driver, String checkingUrl, WebElement webElement) {

        String MainWindow = driver.getWindowHandle();


        webElement.click();

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на основную страницу
        driver.switchTo().window(newTab.get(0));
        assertThat(driver.getCurrentUrl(), equalTo(checkingUrl));

        driver.close();

        driver.switchTo().window(MainWindow);
    }
}
