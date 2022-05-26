package formedix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudyPage extends BasePage{

    @FindBy(id = "fdxMdbContainerListItem0MenuToggle")
    public WebElement toggleIcon;

    @FindBy(xpath = "//li[text()='View']")
    public  WebElement viewBtn;

    @FindBy(css = ".fdxicon-regular.fdx-asset-group")
    public  WebElement dataAcquisition;

    @FindBy(xpath = "//span[@id='FORMTypeName']")
    public  WebElement forms;

    @FindBy (id = "fdxMdbAssetGroupListHeader")
    public  WebElement assetGroup;

    @FindBy (id = "fdxMdbAssetTypeListHeader")
    public  WebElement asset;

    @FindBy (id = "dropdown-asset-type-single-selected")
    public WebElement assertForm;
}
