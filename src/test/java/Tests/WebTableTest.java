package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement elementsField=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsField.click();

        WebElement webTableField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTableField.click();

        WebElement addField=driver.findElement(By.id("addNewRecordButton"));
        addField.click();

        WebElement firstNameField=driver.findElement(By.id("firstName"));
        String firstNameValue="Doe";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField=driver.findElement(By.id("lastName"));
        String lastNameValue="Jane";
        lastNameField.sendKeys(lastNameValue);

        WebElement eMailField=driver.findElement(By.id("userEmail"));
        String eMailValue="jane.doe@email.com";
        eMailField.sendKeys(eMailValue);

        WebElement ageField=driver.findElement(By.id("age"));
        String ageValue="35";
        ageField.sendKeys(ageValue);

        WebElement salaryField=driver.findElement(By.id("salary"));
        String salaryValue="5000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField=driver.findElement(By.id("department"));
        String departmentValue="IT";
        departmentField.sendKeys(departmentValue);

        WebElement submitField=driver.findElement(By.id("submit"));
        submitField.click();

    }

}
