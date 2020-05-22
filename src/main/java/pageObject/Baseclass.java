package pageObject;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.Excel_Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Baseclass {
    public static WebDriver driver;



    public WebDriver getDriver(){
                //instantiate webdriver
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver();
                //implicit wait
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                //page load timeout
                driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
                //maximize window
                driver.manage().window().maximize();
                //load URl
                driver.get("https://fr-qa.airxos.co/airspace");

                return driver;
    }


    public  Excel_Reader load_excel(){

        //reference for Excel_Reader
        Excel_Reader xlib = new Excel_Reader("C:\\Users\\zadmin\\IdeaProjects\\Sample_project\\src\\test\\java\\testData\\Test Data.xlsx");
        return xlib;
}

    //element visibility check
    public boolean element_displayed(WebElement y) {

        Boolean displayed = y.isDisplayed();
        if(displayed){
            System.out.println(" Element is displayed");
        }
        else {
            System.out.println("Element is not visible");
        }
        return displayed;
    }
    //element enable check
    public boolean element_enable(WebElement x) {
        Boolean enabled = x.isEnabled();
        if(enabled){
            System.out.print("Element is enabled ");
        }
        else {
            System.out.print("Element is disabled ");
        }

        return enabled;
    }
    //visibility check
    public boolean visbilityCheck(WebElement element){
        boolean value;
        boolean value1 = element_enable(element);
        boolean value2 = element_displayed(element);

        //storing end boolean value
        value = value1 && value2;
        return value;
    }

    public static WebDriverWait webDriverWait(){
        WebDriverWait wait = new WebDriverWait(driver, 60);

        return wait;
    }



}
