package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;

    public ElementsMethods elementsMethods;
    public JavascripMethods javascripMethods;
    public HomePage homePage;
    public CommonPage commonPage;

    @Test
    public void automationMethod() {

        // Deschidem un browser de chrome
        driver = new FirefoxDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        javascripMethods = new JavascripMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        

//        //facem un scroll
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//
        javascripMethods.scroll(0,400);
//
//        //declaram un element
//        List<WebElement> formElements = driver.findElements(By.xpath("//h5"));
//        elementsMethods.selectElementFromListByText(formElements,"Forms");
        homePage.goToDesiredMenu("Forms");

//        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
//        List<WebElement> subElementList = driver.findElements(By.xpath("//span[@class='text']"));
//        elementsMethods.selectElementFromListByText(subElementList,"Practice Form");
        commonPage.goToDesiredSubMenu("Practice Form");

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Amaritei";
        elementsMethods.fillElement(firstNameElement,firstNameValue);


        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Radu";
        elementsMethods.fillElement(lastNameElement,lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "radu@yahoo.com";
        elementsMethods.fillElement(userEmailElement, userEmailValue);

        WebElement mobileNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "2323232356";
        elementsMethods.fillElement(mobileNumberElement, mobileNumberValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        elementsMethods.uploadPicture(pictureElement);

        WebElement MaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement FemaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement OtherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderElement = new ArrayList<>();

        genderElement.add(MaleElement);
        genderElement.add(FemaleElement);
        genderElement.add(OtherElement);

//        elementsMethods.selectElementFromListByText(genderElement,"Female");

//        WebElement SubjectElement = driver.findElement((By.id("subjectsInput")));
//        String SubjectValues = "Social Studies";
//        SubjectElement.sendKeys(SubjectValues);
//        SubjectElement.sendKeys(Keys.ENTER);
//
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
