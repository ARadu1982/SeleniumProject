package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage{

    @FindBy(id="firstName")
    private WebElement firstNameElement;

    @FindBy(id="lastName")
    private WebElement lastNameElement;

    @FindBy(id="userEmail")
    private WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;

    @FindBy(id = "currentAddress")
    private WebElement addressElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyElement;

//    @FindBy(xpath = "//div[@id='subjectsContainer']")
    @FindBy(id = "subjectsInput")
    private WebElement subjectElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNo){

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

        javascriptMethods.scroll(0,400);
        elementsMethods.clickMultipleValues(hobbiesElement,hobbies);
        javascriptMethods.scroll(0,400);
    }

    public void completeStateAndCity(String state, String city){ // tema - de transmis o lista de valori

        javascriptMethods.forceClick(stateElement);
//        elementsMethods.clickOnElements(stateElement);
//        elementsMethods.waitVisibilityElement(stateElement);
        elementsMethods.fillWithActions(stateElement, state);
        javascriptMethods.forceClick(cityElement);

//        elementsMethods.clickOnElements(cityElement);
//        elementsMethods.waitVisibilityElement(cityElement);
        elementsMethods.fillWithActions(cityElement,city);

    }

    public void submit(){
        javascriptMethods.forceClick(submitElement);
    }
}