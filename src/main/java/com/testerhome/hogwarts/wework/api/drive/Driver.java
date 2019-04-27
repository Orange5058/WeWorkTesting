package com.testerhome.hogwarts.wework.api.drive;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Driver {
    public AppiumDriver appiumDriver;
    static Driver driver;

    public static Driver getInstance(){
        if(driver==null){
            driver=new Driver();
        }
        return driver;
    }
    //实例的start
    public void start(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "ddd");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        //所有的数据不重置
        desiredCapabilities.setCapability("noReset", "true");
        //设置设备中的输入法
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true);
//        desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
        try {
            appiumDriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public WebElement find(By by){
        //定位元素封装
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return appiumDriver.findElement(by);
    }

}
