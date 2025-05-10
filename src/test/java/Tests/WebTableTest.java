package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.WebTablePage;

import java.util.List;

public class WebTableTest extends ShareData {

     HomePage homePage;
     CommonPage commonPage;
     WebTablePage webTablePage;

    @Test
    public void automationMethod(){

        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());
        webTablePage = new WebTablePage(getDriver());


        homePage.goToDesiredMenu("Elements");
        commonPage.goToDesiredSubMenu("Web Tables");
        int beforeSubmitTableSize = webTablePage.numberOfRecords();

        webTablePage.addNewRecordButton();

        String firstNameValue = "Amaritei";
        String lastNameValue = "Radu";
        String userEmailValue = "radu@gmail.com";
        String ageValue = "42";
        String salaryValue = "100";
        String departmentValue = "IT activities";
        webTablePage.completeRegistrationForm(firstNameValue,lastNameValue,userEmailValue,ageValue,salaryValue,departmentValue);

        webTablePage.submitAction();

        webTablePage.assertNewRecordValues(beforeSubmitTableSize,firstNameValue, lastNameValue,userEmailValue,ageValue,salaryValue,departmentValue);

    }
}
