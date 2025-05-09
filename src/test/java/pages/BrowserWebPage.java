package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BrowserWebPage extends CommonPage{

    @FindBy(id = "tabButton")
    WebElement tabButtonElement;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElementFromNewTab;

    @FindBy(id = "windowButton")
    WebElement windowElement;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingFromNewWindowElement;

    public BrowserWebPage(WebDriver driver) {
        super(driver);
    }

    public void  clickTabButton(){
        elementsMethods.clickOnElements(tabButtonElement);
        windowsMethods.switchToOpenTab();
    }

    public void switchToTabOpened(){
        windowsMethods.switchToOpenTab();
    }

    public void assertSampleHeadingNewPage(String sampleHeadingExpectedText)
    {
        String sampleHeadingActualText = sampleHeadingElementFromNewTab.getText();
        elementsMethods.displayElementContent(sampleHeadingElementFromNewTab);
        Assert.assertEquals(sampleHeadingActualText,sampleHeadingExpectedText);
    }

    public void closingTab(){
        windowsMethods.closeTab();
    }

    public void switchingToMainTab(){
        windowsMethods.switchToMainTab();
    }

    public void clickWindowButton(){
        elementsMethods.clickOnElements(windowElement);
    }

    public void displayNewWindowContent(){
        elementsMethods.displayElementContent(sampleHeadingFromNewWindowElement);
    }
    public void closingWindow(){
        windowsMethods.closeWindow();
    }
}
