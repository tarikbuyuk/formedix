package formedix.pages;
import formedix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//div[@class='fdx-main-nav-item  has-sub-menu'])[1]")
    public WebElement repository;

    @FindBy(id = "menuMdbStudies")
    public WebElement studies;

}