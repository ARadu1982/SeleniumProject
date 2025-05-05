package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascripMethods;
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

import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    public HomePage homePage;
    public CommonPage commonPage;
    public ElementsMethods elementsMethods;
    public JavascripMethods javascripMethods;

    @Test
    public void automationMethod(){

        // Deschidem un browser de chrome
        driver = new FirefoxDriver();

        elementsMethods = new ElementsMethods(driver);
        javascripMethods = new JavascripMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);

        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

//        javascripMethods.scroll(0,400);
//
//        //declaram un element
//        WebElement Elementsfield = driver.findElement(By.xpath("//h5[text()='Elements']"));
//        elementsMethods.clickOnElements(Elementsfield);
        homePage.goToDesiredMenu("Elements");

//        WebElement WebTablefield = driver.findElement((By.xpath("//span[text()='Web Tables']")));
//        elementsMethods.clickOnElements(WebTablefield);
        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> tabelElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tabelElements.size();

        WebElement AddButtonfield = driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickOnElements(AddButtonfield);

        WebElement FirstNamefield = driver.findElement(By.id("firstName"));
        String firstNameValue = "Amaritei";
        elementsMethods.fillElement(FirstNamefield,firstNameValue);

        WebElement LastNamefield = driver.findElement(By.id("lastName"));
        String lastNameValue = "Radu";
        elementsMethods.fillElement(LastNamefield,lastNameValue);


        WebElement UserEmailfield = driver.findElement(By.id("userEmail"));
        String userEmailValue = "radu@gmail.com";
        elementsMethods.fillElement(UserEmailfield,userEmailValue);


        WebElement Agefield = driver.findElement(By.id("age"));
        String ageValue = "42";
        elementsMethods.fillElement(Agefield,ageValue);

        WebElement Salaryfield = driver.findElement(By.id("salary"));
        String salaryValue = "100";
        elementsMethods.fillElement(Salaryfield,salaryValue);

        WebElement Departmentfield = driver.findElement(By.id("department"));
        String departmentValue = "IT activities";
        elementsMethods.fillElement(Departmentfield,departmentValue);

        WebElement Submitbutton = driver.findElement(By.id("submit"));
        elementsMethods.clickOnElements(Submitbutton);

        List<WebElement> expectedTabelElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize+1;

        Assert.assertEquals(expectedTabelElements.size(),expectedTableSize);

        String actualTableValue = expectedTabelElements.get(3).getText();

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(userEmailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

    }
}
