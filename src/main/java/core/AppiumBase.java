package core;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {
    public static IOSDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void createDriver() throws MalformedURLException {

        // Sử dụng BaseOptions
        BaseOptions options = new BaseOptions();

        // Thiết lập capability bằng chuỗi thay vì MobileCapabilityType
        options.setCapability("platformName", "iOS");
        options.setCapability("deviceName", "iPhone 12Prm");
        options.setCapability("appium:udid", "00008101-001E6D210C10001E");
        options.setCapability("appium:automationName", "XCUITest");
        options.setCapability("appium:xcodeOrgId", "49LPZHKUL7");
        options.setCapability("appium:xcodeSigningId", "iPhone Developer");
//        options.setCapability("appium:wdaLocalPort", 8100);
        options.setCapability("appium:noReset", true);

        // Khởi tạo driver với appium GUI server
//        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        // Kết nối đến WebDriverAgent đang chạy trên thiết bị thật qua Wi-Fi
        URL wdaUrl = new URL("http://10.30.102.8:8100"); // IP iPhone
//
//        // Khởi tạo driver
        driver = new IOSDriver(wdaUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // In thông báo để kiểm tra
        System.out.println("Khởi tạo driver thành công!");

    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
        driver.quit();}
    }


    public static void clickElementByXpath(String xpath){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            System.out.println("Đã click vào: "+ xpath);
        }catch (Exception e){}
    }

}
