package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod(){

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
        WebElement Elementsfield = driver.findElement(By.xpath("//h5[text()='Elements']"));
        Elementsfield.click();

        WebElement WebTablefield = driver.findElement((By.xpath("//span[text()='Web Tables']")));
        WebTablefield.click();

        WebElement AddButtonfield = driver.findElement(By.id("addNewRecordButton"));
        AddButtonfield.click();

        WebElement FirstNamefield = driver.findElement(By.id("firstName"));
        String firstNameValue = "Amaritei";
        FirstNamefield.sendKeys(firstNameValue);

        WebElement LastNamefield = driver.findElement(By.id("lastName"));
        String lastNameValue = "Radu";
        LastNamefield.sendKeys(lastNameValue);

        WebElement UserEmailfield = driver.findElement(By.id("userEmail"));
        String userEmailValue = "radu@gmail.com";
        UserEmailfield.sendKeys(userEmailValue);

        WebElement Agefield = driver.findElement(By.id("age"));
        String ageValue = "42";
        Agefield.sendKeys(ageValue);

        WebElement Salaryfield = driver.findElement(By.id("salary"));
        String salaryValue = "100";
        Salaryfield.sendKeys(salaryValue);

        WebElement Departmentfield = driver.findElement(By.id("department"));
        String departmentValue = "IT activities";
        Departmentfield.sendKeys(departmentValue);

        WebElement Submitbutton = driver.findElement(By.id("submit"));
        Submitbutton.click();

    }
}
