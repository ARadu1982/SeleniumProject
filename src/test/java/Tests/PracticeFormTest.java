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

    public HomePage homePage;
    public CommonPage commonPage;
    public PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() {

        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

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
        practiceFormPage.completeStateAndCity("NCR","Delhi");
        practiceFormPage.submit();

    }
}
