package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestLetCodeForm {

    public WebDriver driver;

    @Test
    public void letCodeFormTest(){

        // Deschidem un browser de chrome
        driver = new FirefoxDriver();

        //accesam o pagina web
        driver.get("https://letcode.in/forms");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@id='firstname']"));
        firstNameElement.sendKeys("Amaritei");

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@id='lasttname']"));
        lastNameElement.sendKeys("Radu");

        WebElement emailElement = driver.findElement(By.xpath("//input[@id='email']"));
        emailElement.clear();
        emailElement.sendKeys("ar@email.com");

        WebElement countryCodeElement = driver.findElement(By.xpath("//select/option[@data-countrycode='RO']"));
        countryCodeElement.click();

        WebElement countryElement = driver.findElement(By.xpath("//select/option[@value='Romania']"));
        countryElement.click();

        WebElement phoneElement = driver.findElement(By.xpath("//input[@id='Phno']"));
        phoneElement.sendKeys("123456789");

        WebElement adressLine1Element = driver.findElement(By.xpath("//input[@id='Addl1']"));
        adressLine1Element.sendKeys("address line 1");

        WebElement adressLine2Element = driver.findElement(By.xpath("//input[@id='Addl2']"));
        adressLine2Element.sendKeys("address line 2");

        WebElement stateElement = driver.findElement(By.xpath("//input[@id='state']"));
        stateElement.sendKeys("Ilfov");

        WebElement dateElement = driver.findElement(By.xpath("//input[@type='date']"));
        dateElement.sendKeys("1990-11-05");

        WebElement genderElement = driver.findElement(By.xpath("//input[@type='radio' and @id='male']"));
        genderElement.click();

        WebElement termsAndConditionElement = driver.findElement(By.xpath("//input[@type='checkbox']"));
        termsAndConditionElement.click();

        WebElement submitElement = driver.findElement(By.xpath("//input[@type='submit']"));
        submitElement.click();

//        driver.close();
    }
}
