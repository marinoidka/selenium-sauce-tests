package ru.marinoidka.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        this.driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(300))
                .implicitlyWait(Duration.ofSeconds(300));

        initElements(this.driver, this);
    }




}
