package ru.netology.qamid;

import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import ru.netology.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.setting.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(TestListener.class)
public class LoginTests {

    public AndroidDriver driver;

    @BeforeEach
    @Step("1. Запуск приложения")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "API29");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.iteco.fmhandroid");
        desiredCapabilities.setCapability("appium:appActivity", "ru.iteco.fmhandroid.ui.AppActivity");
        desiredCapabilities.setCapability("appium:unicodeKeyboard", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @AfterEach
    @Step("3. Закрытие приложения")
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Step("2. Авторизация в приложении")
    @Description("Авторизация в приложении с использованием валидных значений логина и пароля")
    public void validLoginAndPassword() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(8000);
        MobileElement el4 = (MobileElement) driver.findElementById("trademark_image_view");
        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Авторизация в приложении")
    @Description("Попытка авторизации в приложении с использованием невалидного значения логина и валидного значения пароля")
    public void invalidLoginAndValidPassword() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Авторизация в приложении")
    @Description("Попытка авторизации в приложении с использованием валидного значения логина и незаполненным полем пароля")
    public void validLoginAndEmptyPasswordField() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Авторизация в приложении")
    @Description("Авторизация в приложении с использованием валидных значений логина и пароля и выход из учетной записи")
    public void successfulLoginAndLogout() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(8000);
        MobileElement el4 = (MobileElement) driver.findElementById("trademark_image_view");

        boolean actualLogIn = el4.isDisplayed();
        Assertions.assertTrue(actualLogIn);

        MobileElement el5 = (MobileElement) driver.findElementById("authorization_image_button");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(2000);
        MobileElement el6 = (MobileElement) driver.findElementById("android:id/title");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(2000);
        MobileElement el7 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el7.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Авторизация в приложении")
    @Description("Авторизация в приложении с использованием валидных значений логина и пароля с закрытием приложения")
    public void successfulLoginAndQuitWithoutLogout() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(8000);
        MobileElement el4 = (MobileElement) driver.findElementById("trademark_image_view");

        boolean actualLogIn = el4.isDisplayed();
        Assertions.assertTrue(actualLogIn);

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        MobileElement el5 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el5.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test //данный тест не работает при подключении физического устройства
    @Step("2. Авторизация в приложении")
    @Description("Попытка авторизации в приложении с с использованием валидных значений логина и пароля при отсутствии связи")
    public void validLoginAndPasswordNoConnection() throws InterruptedException {
        Thread.sleep(5000);

        driver.toggleAirplaneMode();

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();


        Thread.sleep(2000);
        driver.toggleAirplaneMode();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }
}
