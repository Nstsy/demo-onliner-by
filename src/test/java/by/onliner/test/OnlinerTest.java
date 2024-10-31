package by.onliner.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerTest {
    public WebDriver webDriver;
    public LoginPage loginPage;

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

    @Test
    public void testEmptyFields() {
        loginPage.clickButtonSignInLogin();
        Assertions.assertEquals(LoginMessage.MESSAGE_EMPTY_FIELDS, loginPage.getMessageEmptyFields());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.sendKeysName("Nastya");
        loginPage.clickButtonSignInLogin();
        Assertions.assertEquals(LoginMessage.MESSAGE_EMPTY_PASSWORD, loginPage.getMessageEmptyPassword());
    }

    @Test
    public void testEmptyName() {
        loginPage.sendKeysPassword("111555111");
        loginPage.clickButtonSignInLogin();
        Assertions.assertEquals(LoginMessage.MESSAGE_EMPTY_NAME, loginPage.getMessageEmptyName());
    }

    @Test
    public void testNamePasswordIncorrect() {
        loginPage.sendKeysPassword("111555111");
        loginPage.sendKeysName("Nastya");
        loginPage.clickButtonSignInLogin();
          Assertions.assertEquals(LoginMessage.MESSAGE_NAME_PASSWORD_INCORRECT, loginPage.getMessageNamePasswordIncorrect());
    }

    @AfterEach
    public void end() {
        webDriver.quit();
    }
}
