package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.page.MainPage;
import com.testerhome.hogwarts.wework.api.testcase.AppTestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ContactManagePageTest extends AppTestCase {

    @BeforeAll
    static void beforeAllContactManagePageTest() {
        List<String> cleanData=new ArrayList<String>();
        cleanData.add("demo19");
//        cleanData.add("demo20");
        //todo:加个判断，判断是否存在
        try {
            for (String name:cleanData){
                MainPage.getInstance().gotoContact().gotoDepartment(name).gotoManage().delete();
            }

        }catch (Exception e){
            System.out.println("not found");
            e.printStackTrace();
        }
        finally {

        }
    }

    @Test
    void delete(){
        //todo:滑动不稳定，需要封装
        String departmentName="demo19";
        String subDepartmentName="demo20";
        Boolean result = MainPage.getInstance()
                .gotoContact()
                .gotoManage().add(departmentName).back()
                .gotoDepartment(departmentName)
                .gotoManage().add(subDepartmentName).back()
                .gotoManage().allowDelete();
        assertThat(result,equalTo(false));
    }
    @Test
    void add(){
        String departmentName="demo42";
        String name=MainPage.getInstance()
                .gotoContact()
                .gotoManage().add(departmentName).back()
                .getDepartment(departmentName);
        assertThat(name,equalTo(departmentName));
    }
}