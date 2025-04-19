package core;

import java.util.HashMap;
import java.util.Map;

public class Locators {
    private static final Map<String, String> LOCATORS = new HashMap<>();

    // Khởi tạo các locatorXPath cho tiếng Anh và tiếng Việt
    static {
        LOCATORS.put("captureButton", "//XCUIElementTypeButton[@name=\"Chụp\"]");
        LOCATORS.put("okButton", "//XCUIElementTypeButton[@name=\"ok\"]");
        LOCATORS.put("finishButton", "//XCUIElementTypeButton[@name=\"Finish\"]");

        // Tiếng Việt
        LOCATORS.put("nútChụp", "//XCUIElementTypeButton[@name=\"Chụp\"]");
        LOCATORS.put("nútOK", "//XCUIElementTypeButton[@name=\"ok\"]");
        LOCATORS.put("nútfinish", "//XCUIElementTypeButton[@name=\"finish\"]");

        LOCATORS.put("image","//XCUIElementTypeApplication[@name=\"OTG Adapter Demo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeImage");
    }

    // Phương thức để lấy locatorXPath dựa trên key
    public static String getLocator(String key) {
        return LOCATORS.get(key);
    }
}
