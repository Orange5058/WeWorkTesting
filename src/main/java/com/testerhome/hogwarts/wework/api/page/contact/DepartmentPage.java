package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.page.BasePage;
import org.openqa.selenium.By;

public class DepartmentPage extends BasePage {
    By manage= By.id("e92");
    public  ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }
}
