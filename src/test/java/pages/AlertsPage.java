package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends CommonPage{

    @FindBy(id="alertButton")
    WebElement alertOkElement;

    @FindBy(id = "timerAlertButton")
    WebElement alertDelayElement;

    @FindBy(id = "confirmButton")
    WebElement alertConfirmElement;

    @FindBy(id = "promtButton")
    WebElement alertPromptElement;

    @FindBy(id = "confirmResult")
    WebElement confirmResultElement;

    @FindBy(id = "promtButton")
    WebElement promtButtonElement;

    @FindBy(id = "promptResult")
    WebElement promptResultElement;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void alertOk(){
        elementsMethods.clickOnElements(alertOkElement);
        alertMethods.interactWithAlerts();
        javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public void delayAlert(){
        elementsMethods.clickOnElements(alertDelayElement);
        alertMethods.interactWithDelayAlert();
        javascriptMethods.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public void confirmAlertThenDismiss(){
        WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickOnElements(alertConfirmElement);
        alertMethods.interactWithDismissAlert();

    }

    public void confirmResultAssert(String expectedMessage){

        String actualMessage = confirmResultElement.getText();
        System.out.println("Mesajul afisat este: "+actualMessage);

        Assert.assertEquals(actualMessage,expectedMessage);
    }

    public void alertPrompt(){

        elementsMethods.clickOnElements(alertPromptElement);
        alertMethods.interactWithAlertPrompt("Some text!");
    }

    public void assertPromptResult(String expectedPromptMessage){
        String actualPromptMessage = promptResultElement.getText();
        System.out.println("Mesajul afisat este: "+actualPromptMessage);

        Assert.assertEquals(actualPromptMessage,expectedPromptMessage );
    }

    // De continuat refatorizarea cu urmatoarele actiuni din clasa AlertTest
}
