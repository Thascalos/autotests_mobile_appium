package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static helpers.EnvironmentHelper.*;

public class CustomMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        if (IS_ANDROID) {
            return getAndroidDriver();
        } else {
            return getIosDriver();
        }
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", PROJECT_NAME);
        capabilities.setCapability("build", JOB_BASE_NAME);
        capabilities.setCapability("name", "Tests - " + PLATFORM + " - " + BUILD_NUMBER);
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", ANDROID_DEVICE);
        capabilities.setCapability("os_version", ANDROID_VERSION);
        capabilities.setCapability("app", BROWSERSTACK_APP_ANDROID);

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    public IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", IOS_DEVICE);
        capabilities.setCapability("os_version", IOS_VERSION);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", BROWSERSTACK_APP_IOS);

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }

}
