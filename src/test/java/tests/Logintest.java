package tests;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.Baseclass;
import pageObject.Loginpage;
import utility.Excel_Reader;


import java.util.Properties;

public class Logintest extends Baseclass {
    public WebDriver driver;
    public Excel_Reader xlib;
    public Loginpage loginpage;


    public  Logintest(){
        super();
    }
    @BeforeClass
    public void setUp(){
       driver = getDriver();
       xlib = load_excel();
       loginpage = new Loginpage();
    }

    @Test
    public void titleTest(){
        String title = loginpage.Loginpagetitle();
        Assert.assertEquals("AiRXOS Air Mobility Platform",title,"Title check failed");
    }

    @Test(dependsOnMethods = {"titleTest"})
    public void login(){
        String un = xlib.getCellData("Sheet1","Username",2);
        String pw = xlib.getCellData("Sheet1","Password",2);

        loginpage.login(un,pw);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
