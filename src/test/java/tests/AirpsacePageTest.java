package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.Airspacepage;
import pageObject.Baseclass;
import pageObject.Loginpage;
import utility.Excel_Reader;

public class AirpsacePageTest extends Baseclass {
    public WebDriver driver;
    public Excel_Reader xlib;
    public Loginpage loginpage;
    public Airspacepage airspacepage;


    public  AirpsacePageTest(){
        super();
    }
    @BeforeClass
    public void setUp(){
        driver = getDriver();
        xlib = load_excel();
        airspacepage = new Airspacepage();
        loginpage = new Loginpage();
        loginpage.login((xlib.getCellData("Sheet1","Username",2)),
                (xlib.getCellData("Sheet1","Password",2)));

    }

    @Test
    public void pageValidation (){
        WebElement element = airspacepage.pageCheck();

        Assert.assertTrue(element.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
