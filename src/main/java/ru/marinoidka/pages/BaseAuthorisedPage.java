package ru.marinoidka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.marinoidka.elements.FooterPageElements;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.marinoidka.utils.TabUtils.*;

public class BaseAuthorisedPage extends BasePage implements FooterPageElements {
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

    public BaseAuthorisedPage(final WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public void goToLinkedIn() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void goToTwitter() {
        twitterButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void goToFacebook() {
        facebookButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void tearDown() {
        if (driver!=null) {
            driver.findElement(By.id("react-burger-menu-btn")).click();
            driver.findElement(By.id("logout_sidebar_link")).click();
        }
    }

    public void checkHeaderLogo() {
        assertThat(driver.findElement(By.cssSelector(".app_logo")).isDisplayed(), equalTo(true));
    }

    public void checkHeaderLabel() {
        assertThat(driver.findElement(By.className("header_label")).isDisplayed(), equalTo(true));
    }

    public void checkShoppingCartContainer() {
        assertThat(driver.findElement(By.id("shopping_cart_container")).isDisplayed(), equalTo(true));
    }

    public void checkShoppingCartLink() {
        assertThat(driver.findElement(By.className("shopping_cart_link")).isDisplayed(), equalTo(true));
    }

    public void checkSecondaryContainer() {
        assertThat(driver.findElement(By.cssSelector(".header_secondary_container")).getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
    }

    public void checkFooterCopy() {
        assertThat(footerCopy.isDisplayed(), equalTo(true));
    }

    public void checkFooterRobot() {
        assertThat(footerRobot.isDisplayed(), equalTo(true));
    }

    public void checkSideMenuButton() {
        sideMenuButton.click();
        assertThat(sideMenuWrap.isDisplayed(), equalTo(true));
    }

    public void clickSideMenuAllItems() {
        sideMenuButton.click();
        goToInventorySideMenuLink.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
    }

    public void clickSideMenuAbout() {
        sideMenuButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), equalTo("https://saucelabs.com/"));
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void clickSideMenuLogout() {
        sideMenuButton.click();
        logoutSideMenuLink.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
    }

    public void clickSideMenuReset() {
        sideMenuButton.click();
        resetSideMenuLink.click();
        assertThat(sideMenuWrap.isDisplayed(), equalTo(true));
    }

    public void clickSideMenuCrossButton() {
        sideMenuButton.click();
        crossSideMenuButton.click();
        assertThat(sideMenuWrap.isDisplayed(), equalTo(false));
    }
}
