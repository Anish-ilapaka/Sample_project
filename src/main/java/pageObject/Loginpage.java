package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends Baseclass {


    @FindBy(xpath = "//li[@tabindex='-1']")
    public WebElement login_panel;

    @FindBy(xpath = "(//div[@class = 'MuiListItemText-root-138 pl-0'])[1]")
    WebElement login;

    @FindBy(id = "1-email")
    WebElement uname;

    @FindBy(xpath = "//input[@name='password']")
    WebElement pwd;

    @FindBy(xpath = "//span[@class='auth0-label-submit']")
    WebElement login_btn;

    //initializing page objects
    public Loginpage(){
        PageFactory.initElements(driver,this);
    }

    //get title
    public String Loginpagetitle(){
        String title = driver.getTitle();
        return title;
    }



    //enter data
    public Airspacepage login(String username, String password){
        login_panel.click();
        login.click();
        WebDriverWait wait =  webDriverWait();
        wait.until(ExpectedConditions.elementToBeClickable(uname));
        Boolean unameVal = visbilityCheck(uname);
        Boolean pwdval =  visbilityCheck(pwd);
        if (unameVal && pwdval == true){
            uname.sendKeys(username);
            pwd.sendKeys(password);
            login_btn.click();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Airspacepage();
    }

}
