package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void automationMethod() {

        // Deschidem un browser de chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //facem browserul in modul maximize
        driver.manage().window().maximize();
        

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        //declaram un element
        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Amaritei";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Radu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "radu@yahoo.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement mobileNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "23232323";
        mobileNumberElement.sendKeys(mobileNumberValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/Capture1.PNG");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement MaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement FemaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement OtherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String Gender = "Female";

        if (MaleElement.getText().equals(Gender)){
            MaleElement.click();
        } else if (FemaleElement.getText().equals(Gender)){
            FemaleElement.click();
        } else if (OtherElement.getText().equals("Other")){
            OtherElement.click();
        }

        WebElement SubjectElement = driver.findElement((By.id("subjectsInput")));
        String SubjectValues = "Social Studies";
        SubjectElement.sendKeys(SubjectValues);
        SubjectElement.sendKeys(Keys.ENTER);

        WebElement StateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();",StateElement);
        StateElement.sendKeys("NCR");
        StateElement.sendKeys(Keys.ENTER);

        WebElement CityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();",CityElement);
        CityElement.sendKeys("Delhi");
        CityElement.sendKeys(Keys.ENTER);


    }
}
