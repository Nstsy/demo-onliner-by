package by.onliner.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.get("https://www.onliner.by/");
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        loginPage.acceptCookies();
        loginPage.clickButtonSignIn();
    }

    @AfterEach
    public void end() {
        webDriver.quit();
    }
}
