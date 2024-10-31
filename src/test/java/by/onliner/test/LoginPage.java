package by.onliner.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

// МЕТОДЫ для клика по кнопкам
    public void clickButtonSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPageXPath.BUTTON_SIGN_IN))).click();
    }
    public void clickButtonSignInLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPageXPath.BUTTON_SIGN_IN_LOGIN))).click();
    }

    public void acceptCookies() {
        try {
            WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LoginPageXPath.BUTTON_COOCKIE_ID)));
            if (cookiesButton.isDisplayed()) {
                cookiesButton.click();
            }
        } catch (Exception e) {
            System.out.println("Кнопка Куки не найдена");
        }
    }
// МЕТОДЫ для получения текста
    public String getMessageEmptyFields() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageXPath.EMPTY_FIELDS))).getText();
    }
    public String getMessageEmptyPassword() {
        return webDriver.findElement(By.xpath(LoginPageXPath.EMPTY_PASSWORD)).getText();
    }
    public String getMessageEmptyName() {
        return webDriver.findElement(By.xpath(LoginPageXPath.EMPTY_NAME)).getText();
    }
    public String getMessageNamePasswordIncorrect(){
        return webDriver.findElement(By.xpath(LoginPageXPath.NAME_PASSWORD_INCORRECT)).getText();
    }
// МЕТОДЫ для заполнения полей
    public void sendKeysName(String name) {
        webDriver.findElement(By.xpath(LoginPageXPath.INPUT_NAME)).sendKeys(name);
    }
    public void sendKeysPassword(String password) {
        webDriver.findElement(By.xpath(LoginPageXPath.INPUT_PASSWORD)).sendKeys(password);
    }
}
