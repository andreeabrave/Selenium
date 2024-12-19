package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //pt scroll
        // JavascriptExecutor js =  (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,400)");


        WebElement formElement=driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement formField=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        formField.click();

        WebElement firstNameField=driver.findElement(By.id("firstName"));
        String firstNameValue="Doe";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField=driver.findElement(By.id("lastName"));
        String lastNameValue="Jane";
        lastNameField.sendKeys(lastNameValue);

        WebElement eMailField=driver.findElement(By.id("userEmail"));
        String eMailValue="jane.doe@email.com";
        eMailField.sendKeys(eMailValue);

        WebElement mobileNumberField=driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue="0740316032";
        mobileNumberField.sendKeys(mobileNumberValue);

        WebElement pictureField=driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/TestPicture.jpg");
        pictureField.sendKeys(file.getAbsolutePath());

    }
}
