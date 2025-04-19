package functions;

import core.AppiumBase;
import core.Locators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FaceMOC extends AppiumBase {
    public FaceMOC() {
        PageFactory.initElements(driver,this);
    }

    public static void CaptureButtonClick(){
        WebElement captureButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("captureButton"))));
        try {
            captureButton.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement oKButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("okButton"))));
            try {
                if (oKButton.isDisplayed())
                    oKButton.click();
                    WebElement captureBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("captureButton"))));
                    captureBtn2.click();
                }
            catch (Exception e){}}
        catch (Exception e){}
    }

    public static void FinishButtonClick(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickElementByXpath(Locators.getLocator("nútfinish"));
    }

    public static void VerifyCardDetail(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement imageOnCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("image"))));
        Assert.assertTrue("image error",imageOnCard.isDisplayed());
    }
}
