package formedix.pages;
import formedix.utilities.ConfigurationReader;
import formedix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
            PageFactory.initElements(Driver.get(), this);
        }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement signInBtn;

    public void login() {
        userName.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        signInBtn.click();

    }
}
