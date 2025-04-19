package functions;

import core.AppiumBase;
import core.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class FaceMocAuto extends AppiumBase {
    public FaceMocAuto() {
        PageFactory.initElements(driver,this);
    }

    public static void FaceMoc1000Times(){
        try {
            AppiumBase.createDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        int i = 1;
        while (i <= 1000) {
            //Khai báo locator của nút Chụp
            String captureBtnPath = String.format(Locators.getLocator("captureButton"), i);
            WebElement captureBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(captureBtnPath)));

            try {
                //Nhấn Chụp
                captureBtn.click();
                try {
                    wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                    String btnOKPath = String.format(Locators.getLocator("okButton"), i);
                    WebElement btnOK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnOKPath)));

                    try {
                        //Nếu xảy ra lỗi extract template -> Nhấn nút OK để tắt popup
                        if (btnOK.isDisplayed()) {
                            btnOK.click();
                            WebElement captureBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(captureBtnPath)));
                            captureBtn2.click();
                        }
                    } catch (Exception e) {}
                } catch (Exception e) {}
            } catch (Exception e) {}

            try {
                // Khai báo và bấm nút Finish
                String finishBtnPath = String.format(Locators.getLocator("finishButton"), i);
                WebElement finishBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(finishBtnPath)));
                finishBtn.click();

                // In ra số lần chạy
                System.out.println(i);
            } catch (Exception e) {}

            i++;
        }
    }
}
