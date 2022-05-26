package formedix.stepDefinitions;

import formedix.pages.*;
import formedix.utilities.ConfigurationReader;
import formedix.utilities.Driver;
import formedix.utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class StepDefinition {

    LoginPage loginPage = new LoginPage();
    StudyPage studyPage = new StudyPage();
    FormPage formPage = new FormPage();
    DataAcquisitionPage dataAcquisitionPage = new DataAcquisitionPage();
    LogoutPage logoutPage = new LogoutPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user login with valid credentials")
    public void the_user_login_with_valid_credentials() {
        loginPage.login();
    }

    @When("the user navigates to Repository->Studies")
    public void the_user_navigates_to_Repository_Studies() {
        Utility.waitForVisibility(studyPage.repository,10);
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue("verify the user is on the login page",currentUrl.contains("dashboard"));

        Utility.hover(studyPage.repository);
        studyPage.studies.click();
        Assert.assertTrue("Verify the toggle icon is exist",studyPage.toggleIcon.isDisplayed());
    }

    @Then("the user enter the Tech Study view")
    public void the_user_enter_the_Tech_Study_view() {
        Utility.waitForVisibility(studyPage.toggleIcon,2);
        studyPage.toggleIcon.click();
        Assert.assertTrue("Verify the view button is exist",studyPage.viewBtn.isEnabled());

        Utility.waitForVisibility(studyPage.viewBtn,2);
        studyPage.viewBtn.click();
        String expectedHeader = "Asset groups";
        String actualHeader = studyPage.assetGroup.getText();
        Assert.assertEquals(expectedHeader,actualHeader);
    }

    @Then("the user enter the Data acquisition asset group")
    public void the_user_enter_the_Data_acquisition_asset_group() {
        Utility.waitForClickablility(studyPage.dataAcquisition,2);
        studyPage.dataAcquisition.click();

        String expectedHeader = "Assets";
        Assert.assertEquals(expectedHeader,studyPage.asset.getText());
    }

    @Then("the user select to view Forms")
    public void the_user_select_to_view_Forms() {
        Utility.waitForClickablility(studyPage.forms,2);
        studyPage.forms.click();
        Assert.assertTrue("Verify Form is displayed",studyPage.assertForm.isDisplayed());
    }

    @When("the user select to view the Medical History")
    public void the_user_select_to_view_the_Medical_History() throws InterruptedException {
        Utility.waitForClickablility(formPage.medicalHistory,2);
        formPage.medicalHistory.click();

        String expectedResult = "Edit form";
        Assert.assertEquals("Verify the user is on the correct page",expectedResult,dataAcquisitionPage.editForm.getText());

        Utility.waitForClickablility(dataAcquisitionPage.editForm,5);
        Utility.clickWithJS(dataAcquisitionPage.editForm);
        Assert.assertTrue(dataAcquisitionPage.addIcon.isDisplayed());
    }

    @When("edit the form with {string} and save")
    public void edit_the_form_with_and_save(String description) throws InterruptedException {
        Utility.waitForClickablility(dataAcquisitionPage.addIcon,5);
        Utility.clickWithJS(dataAcquisitionPage.removeDescription);
        Utility.clickWithJS(dataAcquisitionPage.addIcon);
        dataAcquisitionPage.descriptionBox.sendKeys(ConfigurationReader.get("data"), Keys.ENTER);
        Utility.waitForClickablility(dataAcquisitionPage.validateUpdateBtn,2);
        Utility.clickWithJS(dataAcquisitionPage.validateUpdateBtn);
        Utility.waitForVisibility(dataAcquisitionPage.closeForm,5);
        Utility.clickWithJS(dataAcquisitionPage.closeForm);

        Utility.waitForVisibility(dataAcquisitionPage.descriptionCheck,5);
        String expectedDescription = ConfigurationReader.get("data");
        Assert.assertEquals("Verify the description box's updated",expectedDescription,dataAcquisitionPage.descriptionCheck.getText());

        String propertyCheck = dataAcquisitionPage.propertyPanel.getText();
        Assert.assertEquals("Verify the property panel's updated",propertyCheck,ConfigurationReader.get("data"));
    }

    @Then("Logout of the application")
    public void logout_of_the_application() {
        Utility.waitForVisibility(logoutPage.memberIcon,5);
        Utility.hover(logoutPage.memberIcon);
        logoutPage.signOutBtn.click();
    }

}
