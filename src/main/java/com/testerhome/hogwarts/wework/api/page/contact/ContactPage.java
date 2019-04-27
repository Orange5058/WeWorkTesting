package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ContactPage extends BasePage {

    By manage= By.id("e92");
    //
    public ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }
    //查看对应的操作核对
    public String getDepartment(String name){
        By departmentName= MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\""+ name + "\").instance(0));");
        return attribute(departmentName,"text");
    }
    //根据对应的部门进入到该部门列表中
    public DepartmentPage gotoDepartment(String name){
        By departmentName= MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\""+ name + "\").instance(0));");
        click(departmentName);
        return new DepartmentPage();
    }


}
