package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTab {

    public WebDriver driver;
    public JavascripMethods javascriptMethods;
    public ElementsMethods elementsMethods;
    public WindowsMethods windowsMethods;
    public HomePage homePage;
    public CommonPage commonPage;

    @Test
    public void browserWindowMethod() {
        // Deschidem un browser de chrome
        driver = new FirefoxDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");

        // definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        //facem un scroll
        javascriptMethods = new JavascripMethods(driver);

//      javascriptMethods.scroll(0,400);

//      WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//      elementsMethods.clickOnElements(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");


//        WebElement browserWindowsElement = driver.findElement((By.xpath("//span[text()='Browser Windows']")));
//        elementsMethods.clickOnElements(browserWindowsElement);
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElements(tabButtonElement);

        windowsMethods.switchToOpenTab();

        WebElement sampleHeadingElement = driver.findElement((By.id("sampleHeading")));
        String sampleHeadingActualText = sampleHeadingElement.getText();
        String sampleHeadingExpectedText = "This is a sample page";

        elementsMethods.displayElementContent(sampleHeadingElement);

        Assert.assertEquals(sampleHeadingActualText,sampleHeadingExpectedText);
        windowsMethods.closeTab();

        windowsMethods.switchToMainTab();

        WebElement windowElement = driver.findElement(By.id("windowButton"));
        elementsMethods.clickOnElements(windowElement);

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement newWindowElement = driver.findElement((By.id("sampleHeading")));
        elementsMethods.displayElementContent(newWindowElement);

        // inchidem window ul deschis
        windowsMethods.closeWindow();

        // facem switch pe fereastra initiala
        driver.switchTo().window(windowList.get(0));


    }
}
