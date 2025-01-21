package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //PT SCROLL
         JavascriptExecutor js =  (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,400)");


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

        WebElement genderFieldMale= driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFieldFemale= driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderFieldOther= driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderFieldValue="Male";
//        if (genderFieldValue.equals("Male")){
//            genderFieldMale.click();
//        }
//        else if (genderFieldValue.equals("Female")){
//            genderFieldFemale.click();
//        }
//        else if (genderFieldOther.equals("Other")){
//            genderFieldOther.click();
//        }
        if(genderFieldMale.getText().equals(genderFieldValue)){
            genderFieldMale.click();
        }
        else if(genderFieldFemale.getText().equals(genderFieldValue)){
            genderFieldFemale.click();
        }
        else if(genderFieldOther.getText().equals(genderFieldValue)){
            genderFieldOther.click();
        }

        WebElement subjectField=driver.findElement(By.id("subjectsInput"));
        String subjectValue="Social Studies";
        subjectField.sendKeys(subjectValue);
        subjectField.sendKeys(Keys.ENTER);

        WebElement stateField= driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateField);
        stateField.sendKeys("NCR");
        stateField.sendKeys(Keys.ENTER);


    }
}
