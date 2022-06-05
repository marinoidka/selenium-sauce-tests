package ru.marinoidka.utils;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TabUtils {
    public static void switchToTheNextTab(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на последнюю вкладку
        driver.switchTo().window(tabs.get(tabs.size() - 1));


    }

    public static void switchToTheNextTabAndBack(WebDriver driver, String checkingUrl) {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на последнюю вкладку
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        assertThat(driver.getCurrentUrl(), containsString(checkingUrl));

        driver.switchTo().window(tabs.get(0));
    }
}
