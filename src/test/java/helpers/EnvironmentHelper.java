package helpers;

public class EnvironmentHelper {

    //Test env
    public static final String
            KEYWORD = System.getProperty("keyword", "Allure");

    //Browserstack
    public static final String
            BS_LOGIN = System.getProperty("bs_login", ""),
            BS_PASSWORD = System.getProperty("bs_password", "");


    //Platform env
    public static final String
            PROJECT_NAME = System.getProperty("project", "autotests_mobile_appium"),
            PLATFORM = System.getProperty("platform", ""), //ios or android
            ANDROID_DEVICE = System.getProperty("mobile_device", "Google Pixel 3"),
            ANDROID_VERSION = System.getProperty("mobile_version", "9.0"),
            IOS_DEVICE = System.getProperty("mobile_device", "iPhone 11 Pro Max"),
            IOS_VERSION = System.getProperty("mobile_version", "13.2"),
            BROWSERSTACK_APP_ANDROID = System.getProperty("bs_app_android", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c"),
            BROWSERSTACK_APP_IOS = System.getProperty("bs_app_ios", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
    public static final boolean IS_ANDROID = PLATFORM.equals("android");

    //CI
    public static final String
            BUILD_NUMBER = System.getProperty("build_number", "0"),
            JOB_BASE_NAME = System.getProperty("job_base_name", "local");

}
