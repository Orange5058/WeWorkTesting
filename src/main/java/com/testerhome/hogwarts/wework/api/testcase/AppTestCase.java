package com.testerhome.hogwarts.wework.api.testcase;

import com.testerhome.hogwarts.wework.api.drive.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class AppTestCase {
    @BeforeAll
    public static void beforeAllAppTestCase(){
        Driver.getInstance().start();

    }

    @AfterAll
    public static void afterallAppTestCase(){
        Driver.getInstance().appiumDriver.quit();

    }
}
