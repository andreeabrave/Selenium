package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest {

    public WebDriver driver;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement afwElement=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        afwElement.click();

        WebElement browserElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserElement.click();

        WebElement tabElement = driver.findElement(By.id("tabButton"));
        tabElement.click();

        List<String> tabList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        WebElement sampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este: " + sampleElement.getText());
        driver.close();

        driver.switchTo().window(tabList.get(0));

        WebElement windowElement = driver.findElement(By.id("windowButton"));
        windowElement.click();

        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement sampleWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new window este: " + sampleWindowElement.getText());
        driver.close();

        driver.switchTo().window(tabList.get(0));



    }
}
