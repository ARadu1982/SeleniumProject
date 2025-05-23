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

        public HomePage homePage;
        public CommonPage commonPage;
        public AlertsPage alertsPage;

    @Test
        public void alertTestMethod() {

            commonPage = new CommonPage(getDriver());
            homePage = new HomePage(getDriver());
            alertsPage = new AlertsPage(getDriver());

            homePage.goToDesiredMenu("Alerts, Frame & Windows");

            commonPage.goToDesiredSubMenu("Alerts");

//            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // prima alerta
            alertsPage.alertOk();

            // a doua alerta
            alertsPage.delayAlert();

            // a treia alerta
            alertsPage.confirmAlertThenDismiss();


             String expectedMessage = "You selected Cancel";
            alertsPage.confirmResultAssert(expectedMessage);

//            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // a patra alerta
             alertsPage.alertPrompt();

            String expectedPromptMessage = "You entered Some text!";
             alertsPage.assertPromptResult(expectedPromptMessage);

        }

    }
