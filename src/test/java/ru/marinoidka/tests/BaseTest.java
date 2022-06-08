package ru.marinoidka.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.marinoidka.utils.ScreenShotMaker.makeScreenshotOnFailure;

public abstract class BaseTest {
    public static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    public static Properties properties = new Properties();
    public static WebDriver driver;
    public static String baseUrl;
    public static String username;
    public static String password;
    public static String productID;
    public static String firstname;
    public static String lastname;
    public static String postcode;
    public static String checkoutCompleteURL;

    @Step("Открываем окно браузера Chrome")
    @BeforeAll
    static void beforeAll() throws IOException {
        driver = WebDriverManager.chromedriver().create();

        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
        productID = properties.getProperty("productID");
        firstname = properties.getProperty("firstname");
        lastname = properties.getProperty("lastname");
        postcode = properties.getProperty("postcode");
        checkoutCompleteURL = properties.getProperty("checkout.complete.url");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }


    @Step("Делаем скриншот страницы")
    @AfterEach
    void afterEach() throws IOException {
        Allure.addAttachment("Page screenshot", new FileInputStream(makeScreenshotOnFailure(driver)));
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
    }


    @Step("Закрываем окно браузера")
    @AfterAll
    static void afterAll() {
        if (driver!=null){
            driver.quit();
        }
    }
}
