package ru.marinoidka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.marinoidka.utils.TabUtils.switchToTheNextTabAndBack;

public class SideMenu extends BaseAuthorisedPage{
    public SideMenu(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenuButton;
    @FindBy(className = "bm-menu-wrap")
    WebElement sideMenuWrap;
    @FindBy(id = "inventory_sidebar_link")
    WebElement goToInventorySideMenuLink;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutSideMenuLink;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutSideMenuLink;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetSideMenuLink;
    @FindBy(id = "react-burger-cross-btn")
    WebElement crossSideMenuButton;

    @Step("Нажимаем на боковое меню")
    public void checkSideMenuButton() {
        sideMenuButton.click();
        assertThat(sideMenuWrap.isDisplayed(), equalTo(true));
    }
    @Step("Нажимаем All Items в боковом меню")
    public void clickSideMenuAllItems() {
        sideMenuButton.click();
        goToInventorySideMenuLink.click();
        switchToTheNextTabAndBack(driver, "inventory.html");
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
    }
    @Step("Нажимаем About в боковом меню")
    public void clickSideMenuAbout() {
        sideMenuButton.click();
        aboutSideMenuLink.click();
        switchToTheNextTabAndBack(driver, "saucelabs.com");
    }
    @Step("Нажимаем Logout в боковом меню")
    public void clickSideMenuLogout() {
        sideMenuButton.click();
        logoutSideMenuLink.click();
    }
    @Step("Нажимаем Reset в боковом меню")
    public void clickSideMenuReset() {
        sideMenuButton.click();
        resetSideMenuLink.click();
        assertThat(sideMenuWrap.isDisplayed(), equalTo(true));
        crossSideMenuButton.click();
    }
    @Step("Нажимаем крестик в боковом меню")
    public void clickSideMenuCrossButton() {
        sideMenuButton.click();
        crossSideMenuButton.click();
        assertThat(sideMenuWrap.isDisplayed(), equalTo(true));
    }
}
