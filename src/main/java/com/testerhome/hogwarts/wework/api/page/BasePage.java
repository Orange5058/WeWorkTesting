package com.testerhome.hogwarts.wework.api.page;

import com.testerhome.hogwarts.wework.api.drive.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public WebElement find(By by){
        return Driver.getInstance().find(by);
    }
    //封装点击操作
    public void click(By by){
        find(by).click();
    }
    //根据文本进行定位
    public  void click(String text){
        find(byText(text)).click();
    }
    public void sendKeys(By by, String content){
        find(by).sendKeys(content);

    }
    public void sendKeys(String content){
        Driver.getInstance().appiumDriver.getKeyboard().sendKeys(content);

    }
    //封装xpath的方法,使用文本
    public By byText(String text){
        //todo:特殊字符处理
        return By.xpath("//*[@text='"+text + "']");

    }
    public String attribute(By by,String name){
        return find(by).getAttribute(name);
    }
    //判断更多里面的数量
    public List<WebElement> findElements(By by){
        return Driver.getInstance().appiumDriver.findElements(by);

    }
}
