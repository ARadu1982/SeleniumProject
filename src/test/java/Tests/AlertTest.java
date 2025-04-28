package Tests;
import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

        public WebDriver driver;

        public ElementsMethods elementsMethods;

        public AlertMethods alertMethods;

        public JavascripMethods javascriptMethods;

    @Test
        public void alertTestMethod() {

            // Deschidem un browser de chrome
            driver = new FirefoxDriver();
            //accesam o pagina web
            driver.get("https://demoqa.com/");

            // definim un wait implicit pentru un interval maxim de timp
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //facem browserul in modul maximize
            driver.manage().window().maximize();

            elementsMethods = new ElementsMethods(driver);
            alertMethods = new AlertMethods(driver);

            javascriptMethods = new JavascripMethods(driver);
            javascriptMethods.scroll(0,400);

            WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            elementsMethods.clickOnElements(alertFrameWindowElement);

            WebElement alertElement = driver.findElement((By.xpath("//span[text()='Alerts']")));
            elementsMethods.clickOnElements(alertElement);

            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // prima alerta
            WebElement alertOkElement = driver.findElement(By.id("alertButton"));
            elementsMethods.clickOnElements(alertOkElement);

            alertMethods.interactWithAlerts();

           javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // a doua alerta
            WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
            elementsMethods.clickOnElements(alertDelayElement);

            alertMethods.interactWithDelayAlert();

            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");


            // a treia alerta
            WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
            elementsMethods.clickOnElements(alertConfirmElement);

            alertMethods.interactWithDismissAlert();

            String expectedMessage = "You selected Cancel";
            String actualMessage = driver.findElement(By.id("confirmResult")).getText();
            System.out.println("Mesajul afisat este: "+actualMessage);

            Assert.assertEquals(actualMessage,expectedMessage);

            javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // a patra alerta
            WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
            elementsMethods.clickOnElements(alertPromptElement);

            alertMethods.interactWithAlertPrompt("Some text!");

            String expectedPromptMessage = "You entered Some text!";
            String actualPromptMessage = driver.findElement(By.id("promptResult")).getText();
            System.out.println("Mesajul afisat este: "+actualPromptMessage);

            Assert.assertEquals(actualPromptMessage,expectedPromptMessage );

        }

    }
