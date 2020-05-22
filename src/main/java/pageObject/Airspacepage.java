package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Airspacepage extends Baseclass{

    //navigator
    @FindBy(xpath = "//div[@class='flex flex-1 pr-8 pl-16']")
    WebElement navigator;

    //notification icon
    @FindBy(xpath = "(//span[@class='MuiIconButton-label-90'])[2]")
    WebElement bellIcon;

    //date
    @FindBy(className = "MuiTypography-root airxos-prod1070 MuiTypography-body1 MuiTypography-colorTextSecondary")
    WebElement date;

    //details
    @FindBy(xpath = "//span[@class='MuiTypography-root-157 normal-case font-600 flex MuiTypography-body1-159']")
    WebElement details;

    //intialise elements
    public Airspacepage(){
        PageFactory.initElements(driver,this);
    }
    // page validation
    public WebElement pageCheck(){
       WebDriverWait wait =  webDriverWait();
       wait.until(ExpectedConditions.elementToBeClickable(navigator));
       return navigator;
    }

    public void notificationTab(){
        if (visbilityCheck(bellIcon)){
            bellIcon.click();
        }
    }

}
