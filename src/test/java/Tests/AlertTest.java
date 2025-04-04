package Tests;
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

            //facem un scroll
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//            js.executeScript("window.scrollBy(0, 400)");

            WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            alertFrameWindowElement.click();

            WebElement alertElement = driver.findElement((By.xpath("//span[text()='Alerts']")));
            alertElement.click();

            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // prima alerta
            WebElement alertOkElement = driver.findElement(By.id("alertButton"));
            alertOkElement.click();

            Alert alertOk = driver.switchTo().alert();
             // mutam focusul pe alerta
            alertOk.accept();

            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");


            // a doua alerta
            WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
            alertDelayElement.click();

            // definim un wait explicit ca sa astepte dupa alerta
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alertDelay = driver.switchTo().alert();
            alertDelay.accept();

            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");


            // a treia alerta
            WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
            alertConfirmElement.click();

            Alert alertConfirmation = driver.switchTo().alert();
            alertConfirmation.dismiss();

            String expectedMessage = "You selected Cancel";
            String actualMessage = driver.findElement(By.id("confirmResult")).getText();
            System.out.println("Mesajul afisat este: "+actualMessage);

            Assert.assertEquals(actualMessage,expectedMessage);

            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            // a patra alerta
            WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
            alertPromptElement.click();

            Alert alertPrompt = driver.switchTo().alert();
            alertPrompt.sendKeys("Some text!");
            alertPrompt.accept();

            String expectedPromptMessage = "You entered Some text!";
            String actualPromptMessage = driver.findElement(By.id("promptResult")).getText();
            System.out.println("Mesajul afisat este: "+actualPromptMessage);

            Assert.assertEquals(actualPromptMessage,expectedPromptMessage );


        }

    }
