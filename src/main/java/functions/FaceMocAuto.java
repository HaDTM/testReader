package functions;

import core.AppiumBase;
import core.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
        long startTime = System.currentTimeMillis(); // ⏱️ Thời điểm bắt đầu
        System.out.println("Start time: " + new java.util.Date(startTime));

        int i = 1;
        while (i <= 1000) {
            try {
                System.out.println("Lần chụp: " + i);
                WebElement captureBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("captureButton"))));
                captureBtn.click();
                System.out.println("Đã nhấn nút Chụp");

                try {
                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
                    WebElement btnOK = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("okButton"))));
                    if (btnOK.isDisplayed()) {
                        System.out.println("Popup lỗi xuất hiện → nhấn OK");
                        btnOK.click();
                        captureBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("captureButton"))));
                        captureBtn.click();
                    }
                } catch (TimeoutException e) {
                    System.out.println("Không có popup lỗi xuất hiện.");
                }

                try {

                    WebElement finishBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.getLocator("nútfinish"))));
                    finishBtn.click();
                    System.out.println("Đã nhấn nút Finish");
                } catch (TimeoutException e) {
                    System.out.println("Không tìm thấy nút Finish lần " + i);
                }

            } catch (TimeoutException e) {
                System.out.println("Không tìm thấy nút Chụp lần " + i);
            }
            i++;
        }
        long endTime = System.currentTimeMillis(); // ⏱️ Thời điểm kết thúc
        System.out.println("End time: " + new java.util.Date(endTime));
        System.out.println("Total time: " + (endTime - startTime) + "ms");
    }
}
