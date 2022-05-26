package formedix.pages;
import formedix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    public FormPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//div[@class='assetBrowseListItem'])[4]")
    public WebElement medicalHistory;

}
