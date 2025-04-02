package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement afwElement=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        afwElement.click();

        WebElement alertField=driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertField.click();

        //ne mutam cu focusul pe alerta
        WebElement alertOkElement=driver.findElement(By.id("alertButton"));
        alertOkElement.click();
        Alert alertOK=driver.switchTo().alert();
        alertOK.accept();

        WebElement alertDelayElement=driver.findElement(By.id("timerAlertButton"));
        alertDelayElement.click();
        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertDelay=driver.switchTo().alert();
        alertDelay.accept();

        WebElement alertConfirmationElement=driver.findElement(By.id("confirmButton"));
        alertConfirmationElement.click();
        Alert alertConfirm=driver.switchTo().alert();
        alertConfirm.accept();

        WebElement alertPromptElement=driver.findElement(By.id("promtButton"));
        alertPromptElement.click();
        Alert alertPrompt=driver.switchTo().alert();
        alertPrompt.sendKeys("Hello");
        alertPrompt.accept();


    }
}
