package formedix.pages;
import formedix.utilities.Driver;
import formedix.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {


    public LogoutPage(){
        PageFactory.initElements(Driver.get(), this);}

        @FindBy(id = "menuUser")
        public WebElement memberIcon;

        @FindBy(id = "menuUserLogout")
        public WebElement signOutBtn;

    }

