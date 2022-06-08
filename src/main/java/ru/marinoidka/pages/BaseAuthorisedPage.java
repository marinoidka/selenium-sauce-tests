package ru.marinoidka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.marinoidka.elements.FooterPageElements;
import ru.marinoidka.elements.SideMenuElements;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.marinoidka.utils.TabUtils.switchToTheNextTabAndBack;

public class BaseAuthorisedPage extends BasePage implements FooterPageElements, SideMenuElements {
    @FindBy(css = ".social_twitter a")
    WebElement twitterButton;
    @FindBy(css = ".social_facebook a")
    WebElement facebookButton;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton;
    @FindBy(className = "footer_copy")
    WebElement footerCopy;
    @FindBy(className = "footer_robot")
    WebElement footerRobot;
    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenuButton;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutSideMenuLink;
    @FindBy(css = ".app_logo")
    WebElement appLogo;
    @FindBy(className = "header_label")
    WebElement headerLabel;
    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCartContainer;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;


    public BaseAuthorisedPage(final WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    @Step("Разлогин")
    @Override
    public LoginPage logOut() {
        sideMenuButton.click();
        logoutSideMenuLink.click();
        return new LoginPage(driver);
    }

    @Step("Переходим в LinkedIn")
    @Override
    public void goToLinkedIn() {
        linkedInButton.click();
        switchToTheNextTabAndBack(driver, "linkedin.com");
    }

    @Step("Переходим в Twitter")
    public void goToTwitter() {
        twitterButton.click();
        switchToTheNextTabAndBack(driver, "twitter.com");
    }

    @Step("Переходим в Facebook")
    public void goToFacebook() {
        facebookButton.click();
        switchToTheNextTabAndBack(driver, "facebook.com");
    }

    @Step("Разлогин")
    public void tearDown() {
        sideMenuButton.click();
        logoutSideMenuLink.click();
    }

    @Step("Проверяем наличие хедера")
    public void checkHeaderLogo() {
        assertTrue(appLogo.isDisplayed());
    }

    @Step("Проверяем наличие логотипа")
    public void checkHeaderLabel() {
        assertTrue(headerLabel.isDisplayed());
    }

    @Step("Проверяем наличие контейнера корзины")
    public void checkShoppingCartContainer() {
        assertTrue(shoppingCartContainer.isDisplayed());
    }

    @Step("Проверяем наличие корзины")
    public void checkShoppingCartLink() {
        assertTrue(shoppingCart.isDisplayed());
    }

    @Step("Проверяем наличие Copyright в подвале страницы")
    public void checkFooterCopy() {
        assertThat(footerCopy.isDisplayed(), equalTo(true));
    }

    @Step("Проверяем наличие робота в подвале страницы")
    public void checkFooterRobot() {
        assertThat(footerRobot.isDisplayed(), equalTo(true));
    }

}
