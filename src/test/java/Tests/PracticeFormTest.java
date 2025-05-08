package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import ShareData.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends ShareData {

    public ElementsMethods elementsMethods;
    public JavascripMethods javascripMethods;
    public HomePage homePage;
    public CommonPage commonPage;
    public PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() {

        elementsMethods = new ElementsMethods(driver);
        javascripMethods = new JavascripMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        practiceFormPage = new PracticeFormPage(driver);

        javascripMethods.scroll(0,400);

        homePage.goToDesiredMenu("Forms");

        commonPage.goToDesiredSubMenu("Practice Form");
        practiceFormPage.completeFirstRegion("Amaritei","Radu","radu@yahoo.com","Aleea Codrilor","2323232356");
        practiceFormPage.completeGender("Male");

        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("English");
        subjects.add("Social");
        practiceFormPage.completeSubjectWithList(subjects);

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");
        hobbies.add("Reading");
        practiceFormPage.completeHobbies(hobbies);

        //Tema - State and Select City

        javascripMethods.scroll(0,400);
        practiceFormPage.completeStateAndCity("NCR","Delhi"); // aici pica testul

        practiceFormPage.submit();

//        WebElement StateElement = driver.findElement(By.id("react-select-3-input"));
//        js.executeScript("arguments[0].click();",StateElement);
//        StateElement.sendKeys("NCR");
//        StateElement.sendKeys(Keys.ENTER);
//
//        WebElement CityElement = driver.findElement(By.id("react-select-4-input"));
//        js.executeScript("arguments[0].click();",CityElement);
//        CityElement.sendKeys("Delhi");
//        CityElement.sendKeys(Keys.ENTER);
//
//        WebElement submitElement = driver.findElement(By.id("submit"));
//        js.executeScript("arguments[0].click();",submitElement);


    }
}
