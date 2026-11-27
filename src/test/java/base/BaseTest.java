package base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );

        Selenide.open("https://www.ispot.com.ua/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        Selenide.closeWebDriver();
    }
}
