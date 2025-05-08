package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {

    WebDriver driver;
    ElementsMethods elementsMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="firstName")
    WebElement firstNameElement;

    @FindBy(id="lastName")
    WebElement lastNameElement;

    @FindBy(id="userEmail")
    WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    WebElement pictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;

    @FindBy(id = "currentAddress")
    WebElement addressElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobbyElement;

//    @FindBy(xpath = "//div[@id='subjectsContainer']")
    @FindBy(id = "subjectsInput")
    WebElement subjectElement;

    @FindBy(id = "submit")
    WebElement submitElement;

    public void completeFirstRegion(String firstName,String lastName, String email, String address, String mobileNo){

        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(userEmailElement, email);
        elementsMethods.fillElement(addressElement, address);
        elementsMethods.fillElement(mobileNumberElement, mobileNo);

    }

    public void completeGender(String gender){
        switch (gender) {
            case "Male":
                elementsMethods.clickOnElements(maleGenderElement);
                break;
            case "Female":
                elementsMethods.clickOnElements(femaleGenderElement);
                break;
            case "Other":
                elementsMethods.clickOnElements(otherGenderElement);
                break;
        }
    }

    public void completeSubject(String subject){

        elementsMethods.clickOnElements(subjectElement);
        elementsMethods.fillWithActions(subjectElement, subject);

    }

    public void completeSubjectWithList(List<String> list){
        elementsMethods.clickOnElements(subjectElement);
        elementsMethods.fillMultipleValues(subjectElement,list);
    }

    public void completeHobbies(List<String> hobbies){
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        hobbiesElement.add(musicHobbyElement);

        elementsMethods.clickMultipleValues(hobbiesElement,hobbies);
    }

    public void completeStateAndCity(String state, String city){ // tema - de transmis o lista de valori

        elementsMethods.clickOnElements(stateElement);
//        elementsMethods.waitVisibilityElement(stateElement);
        elementsMethods.fillWithActions(stateElement, state);
        elementsMethods.clickOnElements(cityElement);
//        elementsMethods.waitVisibilityElement(cityElement);
        elementsMethods.fillWithActions(cityElement,city);

    }

    public void submit(){
        elementsMethods.clickOnElements(submitElement);
    }
}