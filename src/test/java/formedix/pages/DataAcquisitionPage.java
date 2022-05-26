package formedix.pages;
import formedix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataAcquisitionPage  {

    public DataAcquisitionPage (){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-compact fdx-mdb-asset-overview-menu-edit btn-primary']")
    public WebElement editForm;

    @FindBy(xpath = "//*[@id='editPropsAddEntrydescription']/span[2]")
    public  WebElement addIcon;

    @FindBy(xpath = "//div[@id='description-assetLocaleEdit']//textarea")
    public  WebElement descriptionBox;

    @FindBy(xpath = "//div[@class='locale']/span[2]/span")
    public  WebElement propertyPanel;

    @FindBy(id = "saveAsset")
    public WebElement validateUpdateBtn;

    @FindBy(css = "#formDescription>span")
    public  WebElement descriptionCheck;

    @FindBy(xpath = "//button[@class='btn btn-compact fdx-mdb-asset-overview-menu-edit btn-default']")
    public WebElement closeForm;

    @FindBy (id = "localeRemovedescription")
    public WebElement removeDescription;
}
