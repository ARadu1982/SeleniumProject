package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    public WebDriver driver;

    @Test
    public void framesMethod() {
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

        WebElement frameElement = driver.findElement((By.xpath("//span[text()='Frames']")));
        frameElement.click();

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sampleHeadingFrameElement = driver.findElement((By.id("sampleHeading")));
        System.out.println("Textul din frame este: "+sampleHeadingFrameElement.getText());

        // ne intoarcem cu focusul din frame pe pagina principala
        driver.switchTo().defaultContent();

        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);

        js.executeScript("window.scrollBy(200,200)");


    }
}
