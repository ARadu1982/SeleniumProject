package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTab {

    public WebDriver driver;
    public JavascripMethods javascriptMethods;
    public ElementsMethods elementsMethods;

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
        //facem un scroll
        javascriptMethods = new JavascripMethods(driver);
        javascriptMethods.scroll(0,400);

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.clickOnElements(alertFrameWindowElement);

        WebElement browserWindowsElement = driver.findElement((By.xpath("//span[text()='Browser Windows']")));
        elementsMethods.clickOnElements(browserWindowsElement);

        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElements(tabButtonElement);

        // definim o lista care va contine window tabs
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());

        // ne mutam pe noul tab deschis
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingElement = driver.findElement((By.id("sampleHeading")));
        String sampleHeadingActualText = sampleHeadingElement.getText();
        String sampleHeadingExpectedText = "This is a sample page";

        System.out.println("Textul din new tab este: "+sampleHeadingActualText);

        Assert.assertEquals(sampleHeadingActualText,sampleHeadingExpectedText);
        driver.close();

        //revenim la pagina originala
        driver.switchTo().window(tabList.get(0));

        WebElement windowElement = driver.findElement(By.id("windowButton"));
        windowElement.click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement newWindowElement = driver.findElement((By.id("sampleHeading")));
        String newWindowElementText = newWindowElement.getText();
        System.out.println("Textul din noua pagina deschisa este: "+newWindowElementText);

        // inchidem window ul deschis
        driver.close();

        // facem switch pe windowul initial
        driver.switchTo().window(windowList.get(0));


    }
}
