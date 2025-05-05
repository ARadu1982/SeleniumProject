package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class Frames {

    public WebDriver driver;
    public JavascripMethods javascriptMethods;
    public ElementsMethods elementsMethods;
    public FramesMethods frameMethods;
    public HomePage homePage;
    public CommonPage commonPage;

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

        elementsMethods = new ElementsMethods(driver);
        frameMethods = new FramesMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);

        //facem un scroll
        javascriptMethods = new JavascripMethods(driver);
        javascriptMethods.scroll(0,400);

//        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElements(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement frameElement = driver.findElement((By.xpath("//span[text()='Frames']")));
//        elementsMethods.clickOnElements(frameElement);
        commonPage.goToDesiredSubMenu("Frames");

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        frameMethods.switchToFrame(frame1Element);

        WebElement sampleHeadingFrameElement = driver.findElement((By.id("sampleHeading")));
        elementsMethods.displayElementContent(sampleHeadingFrameElement);

        // ne intoarcem cu focusul din frame pe pagina principala
        frameMethods.switchToDefaultContent();

        javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        frameMethods.switchToFrame(frame2Element);

        javascriptMethods.executeScript("window.scrollBy(200,200)");

    }
}
