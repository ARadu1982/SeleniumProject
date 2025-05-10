package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends CommonPage{

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tabelElements;

    @FindBy(id="addNewRecordButton")
    private WebElement addNewButton;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(id = "age")
    private WebElement ageElement;

    @FindBy(id = "salary")
    private WebElement salaryElement;

    @FindBy(id = "department")
    private WebElement departmentElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addNewRecordButton(){
        elementsMethods.clickOnElements(addNewButton);
    }

    public int numberOfRecords(){
        return tabelElements.size();
    }

    public void completeRegistrationForm(String firstName, String lastName, String userEmail, String age, String salary,String department){

        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(userEmailElement, userEmail);
        elementsMethods.fillElement(ageElement, age);
        elementsMethods.fillElement(salaryElement, salary);
        elementsMethods.fillElement(departmentElement, department);


    }

    public void submitAction(){
        elementsMethods.clickOnElements(submitElement);
    }

    public void assertNewRecordValues(int beforeSubmitTableSize, String firstNameValue, String lastNameValue,String userEmailValue, String ageValue, String salaryValue, String departmentValue ){

        int afterSubmitTableSize = numberOfRecords();

        Integer expectedTableSize = beforeSubmitTableSize+1;

        Assert.assertEquals(afterSubmitTableSize,expectedTableSize);

        String actualTableValue = tabelElements.get(3).getText();

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(userEmailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

    }
}
