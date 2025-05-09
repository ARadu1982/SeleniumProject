package Tests;
import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import ShareData.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest extends ShareData {

        public ElementsMethods elementsMethods;
        public AlertMethods alertMethods;
        public JavascripMethods javascriptMethods;
        public HomePage homePage;
        public CommonPage commonPage;
        public AlertsPage alertsPage;

    @Test
        public void alertTestMethod() {

            elementsMethods = new ElementsMethods(driver);
            alertMethods = new AlertMethods(driver);
            commonPage = new CommonPage(driver);
            homePage = new HomePage(driver);
            alertsPage = new AlertsPage(driver);
            javascriptMethods = new JavascripMethods(driver);

            homePage.goToDesiredMenu("Alerts, Frame & Windows");

            commonPage.goToDesiredSubMenu("Alerts");

            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // prima alerta
            alertsPage.alertOk();

            // a doua alerta
            alertsPage.delayAlert();

            // a treia alerta
            alertsPage.confirmAlertThenDismiss();


             String expectedMessage = "You selected Cancel";
            alertsPage.confirmResultAssert(expectedMessage);

            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // a patra alerta
             alertsPage.alertPrompt();

            String expectedPromptMessage = "You entered Some text!";
             alertsPage.assertPromptResult(expectedPromptMessage);

        }

    }
