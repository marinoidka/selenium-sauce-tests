package ru.marinoidka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public CheckoutCompletePage clickFinish() {
        driver.findElement(By.cssSelector("[data-test='finish']")).click();
        return new CheckoutCompletePage(driver);
    }
}
