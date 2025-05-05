package HelperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ElementsMethods {

        WebDriver driver;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
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

}
