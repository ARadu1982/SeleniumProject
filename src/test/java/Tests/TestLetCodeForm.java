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
        emailElement.sendKeys("ar@email.com");

        WebElement countryCodeElement = driver.findElement(By.xpath("//select/option[@data-countrycode='RO']"));
        countryCodeElement.click();

        WebElement countryElement = driver.findElement(By.xpath("//select/option[@value='Romania']"));
        countryElement.click();

        WebElement phoneElement = driver.findElement(By.xpath("//input[@id='Phno']"));
        phoneElement.sendKeys("123456789");



        driver.close();
    }
}
