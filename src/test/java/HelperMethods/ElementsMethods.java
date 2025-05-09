package HelperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.security.Key;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {

        WebDriver driver;
        JavascriptExecutor js;
        Actions actions;

    public ElementsMethods(WebDriver driver) {

        this.driver = driver;
        js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);

    }

    public void clickOnElements(WebElement element){
            element.click();
    }

    public void  fillElement(WebElement element, String value){

        element.sendKeys(value);
    }

    public void  uploadPicture(WebElement element){
        File file = new File("src/test/resources/Capture1.PNG");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value){

        for (int i = 0; i < elementsList.size(); i++) {
            if (elementsList.get(i).getText().equals(value)) {
                clickOnElements(elementsList.get(i));
                break;
            }
        }

//        for(int i = 0; i< formElements.size();i++){
//            if (formElements.get(i).getText().equals("Forms")){
//                elementsMethods.clickOnElements(formElements.get(i));
//            }
//        } // returns  org.openqa.selenium.StaleElementReferenceException: The element with the reference b86d71e9-07f9-4196-af


        }

    public void displayElementContent(WebElement element){
        System.out.println("Textul din web element este: "+element.getText());
    }

    public void  fillWithActions(WebElement webElement, String value){
        actions.sendKeys(value).perform(); // build.perform can be used also
        waitVisibilityElement(webElement);
        actions.sendKeys(Keys.ENTER).perform();

    }
    public void  waitVisibilityElement(WebElement webElement){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void fillMultipleValues(WebElement webElement,List<String> list){

        for(String value:list){
            webElement.sendKeys(value);
            waitVisibilityElement(webElement);
            webElement.sendKeys(Keys.ENTER);
        }

    }

    public void clickMultipleValues(List<WebElement> webElements,List<String> list){

        for(String value: list){
            for(WebElement webElement: webElements){
                waitVisibilityElement(webElement);
                if (webElement.getText().equals(value)){
                    webElement.click();
                }
            }

        }

    }

    public  void selectFromComboboxElement(WebElement webElement,String value)
    {
        js.executeScript("arguments[0].click();",webElement);
        webElement.sendKeys(value);
        webElement.sendKeys(Keys.ENTER);
    }




}
