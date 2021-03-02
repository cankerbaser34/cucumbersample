package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

public class AddCustomerPage {


    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    By lnkCustomer_menu = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
    By lnkCustomer_menuitem = By.xpath("//body/div[3]/div[2]/div[1]/ul[1]/li[4]/ul[1]/li[1]");
    By btnAddnew = By.xpath("//body/div[3]/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]");
    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");

    By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
    By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");

    By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");

    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");

    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");
    By txtDob = By.xpath("//input[@id='DateOfBirth']");
    By txtCompanyName = By.xpath("//input[@id='Company']");
    By txtAdminContent = By.xpath("//*[@id=\"AdminComment\"]");
    By btnSave = By.xpath("//body/div[3]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");


//    Action Methods

    public String getPagetitle() {

        return ldriver.getTitle();
    }

    public void clickOnCustomerMen() {

        ldriver.findElement(lnkCustomer_menu).click();
    }

    public void clickOnCustomersMenuItem() {
        ldriver.findElement(lnkCustomer_menuitem).click();
    }

    public void clickOnAddnew() {

        ldriver.findElement(btnAddnew).click();

    }

    public void setEmail(String email) {

        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        ldriver.findElement(txtPassword).sendKeys(password);
    }


    public void setCustomerRoles(String role) throws InterruptedException {

        if (!role.equals("Vendors")) {

            ldriver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']"));

        }
        ldriver.findElement(txtcustomerRoles).click();

        WebElement listitem;

        if (role.equals("Administrators")) {

            listitem = ldriver.findElement(lstitemAdministrators);
        } else if (role.equals("Guest")) {
            listitem = ldriver.findElement(lstitemGuests);
        } else if (role.equals("Registered")) {
            listitem = ldriver.findElement(lstitemRegistered);
        } else if (role.equals("Vendors")) {
            listitem = ldriver.findElement(lstitemVendors);
        } else {
            listitem = ldriver.findElement(lstitemGuests);

        }

//        listitem.click();
//        JavascriptExecutor js = (JavascriptExecutor) ldriver;
//        js.executeScript("arguments[0].click();", listitem);
    }

    public void setManagerOfVendor(String value) {
        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }


    public void setGender(String gender) {

        if (gender.equals("Male")) {
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {

            ldriver.findElement(rdFemaleGender).click();
        } else {

            ldriver.findElement(rdMaleGender).click();// Default
        }
    }

    public void setFirstName(String fname) {

        ldriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLastName(String lname) {

        ldriver.findElement(txtLastName).sendKeys(lname);

    }

    public void setDob(String dob){
        ldriver.findElement(txtDob).sendKeys(dob);
    }

    public void setCompanyName(String comname) {
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }


    public void setAdminContent(String content) {
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave() {
        ldriver.findElement(btnSave).click();
    }

}
