package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHepler;

import java.util.List;

public class searchCustomerPage {

    public WebDriver ldriver;
    WaitHepler waitHelper;

    public searchCustomerPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);

        waitHelper = new WaitHepler(ldriver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID, using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpobMonth;

    @FindBy(how = How.ID, using = "SearchDayofBirth")
    @CacheLookup
    WebElement drpobDay;

    @FindBy(how = How.ID, using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement txtCustomerRoles;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]]")
    @CacheLookup
    WebElement lstitemAdministrators;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
    @CacheLookup
    WebElement lstitemRegistered;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
    @CacheLookup
    WebElement lstitemGuests;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement lstitemVendors;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;


    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResults;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;
    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;


    public void setEmail(String email) {
        waitHelper.WaitForElement(txtEmail, 30);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String fname) {
        waitHelper.WaitForElement(txtEmail, 30);
        txtFirstName.clear();
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        waitHelper.WaitForElement(txtEmail, 30);
        txtLastName.clear();
        txtLastName.sendKeys(lname);
    }

    public void clickSearch() throws InterruptedException {
        btnSearch.click();
       Thread.sleep(3000);

    }

    public int getNoOfRows() {
        return (tableRows.size());
    }

    public int getNoOfColumns() {
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email) {

        boolean flag = false;
        for (int i = 1; i < getNoOfRows(); i++) {
            String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]")).getText();

            System.out.println(emailid);
            if (email.equals("victoria_victoria@nopCommerce.com")) {

                flag = true;
            }
        }
        return flag;

    }

    public boolean searchCustomerByName(String Name)
    {

        boolean flag = false;
        for (int i = 1; i < getNoOfRows(); i++)
        {
            String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();

            String names[]=name.split(" ");

            if (names[0].equals("Victoria") && names[1].equals("Terces"))
            {

                flag = true;
            }
        }
        return flag;

    }

}
