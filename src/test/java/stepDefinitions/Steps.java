package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.searchCustomerPage;

import javax.naming.Name;

public class Steps extends BaseClass {


    @Given("^User Launch Chrome browser$")
    public void user_Launch_Chrome_browser() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        lp = new LoginPage(driver);


    }

    @When("^User opens Url \"([^\"]*)\"$")
    public void user_opens_Url(String url) throws Throwable {

        driver.get(url);

        driver.manage().window().maximize();

    }

    @When("^User enters Email as \"([^\"]*)\"  and Password \"([^\"]*)\"$")
    public void user_enters_Email_as_and_Password(String email, String password) throws Throwable {

        lp.setUsername(email);
        lp.setTxtPassword(password);

    }

    @When("^Click on Login$")
    public void click_on_Login() throws Throwable {
        lp.clickLogin();

    }

    @Then("^Page tile should be \"([^\"]*)\"$")
    public void page_tile_should_be(String title) throws Throwable {

        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @When("^User click on Log out link$")
    public void user_click_on_Log_out_link() throws Throwable {

        lp.clickLogout();
        Thread.sleep(3000);

    }

    @Then("^Page Title should be \"([^\"]*)\"$")
    public void page_Title_should_be(String title) throws Throwable {


        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }


    }

    @Then("^close browser$")
    public void close_browser() throws Throwable {

        driver.quit();
    }


    // Customer feature step definitions

    @Then("^User can view Dashboard$")
    public void user_can_view_Dashboard() throws Throwable {

        addCust = new AddCustomerPage(driver);

        Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPagetitle());

    }

    @When("^User click on customers Menu$")
    public void user_click_on_customers_Menu() throws Throwable {
        Thread.sleep(3000);
        addCust.clickOnCustomerMen();

    }

    @When("^Click on  customers Menu Item$")
    public void click_on_customers_Menu_Item() throws Throwable {
        Thread.sleep(2000);
        addCust.clickOnCustomersMenuItem();


    }

    @When("^click on Add new button$")
    public void click_on_Add_new_button() throws Throwable {
        addCust.clickOnAddnew();
    }

    @Then("^User  can view Add new customer page$")
    public void user_can_view_Add_new_customer_page() throws Throwable {

        Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPagetitle());


    }

    @When("^User enter  customer info$")
    public void user_enter_customer_info() throws Throwable {

        String email = randomestring() + "@gmail.com";

        addCust.setEmail(email);
        addCust.setPassword("123435");
        addCust.setCustomerRoles("Guest");
        Thread.sleep(3000);
        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("Cihan");
        addCust.setLastName("Baser");
        addCust.setCompanyName("Canker");
        addCust.setDob("12/02/1987");
        addCust.setAdminContent("This is first cumcumber testing...");

    }

    @When("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {

        addCust.clickOnSave();
        Thread.sleep(2000);

    }

    @Then("^User can view  confirmation message \"([^\"]*)\"$")
    public void user_can_view_confirmation_message(String arg1) throws Throwable {

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));

    }

    // steps for searching a customer using Email ID....
    @When("^Enter customer EMail$")
    public void enter_customer_EMail() throws Throwable {
        searchCust = new searchCustomerPage(driver);
        searchCust.setEmail("victoria_victoria@nopCommerce.com");


    }

    @When("^Click on search button$")
    public void click_on_search_button() throws Throwable {

        searchCust.clickSearch();

        Thread.sleep(3000);

    }

    @Then("^User should found Email in the Search table$")
    public void user_should_found_Email_in_the_Search_table() throws Throwable {

        boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");

        Assert.assertEquals(true, status);

    }

    // Steps for searching a customer by using Firstname and LastName

    @When("^Enter customer FirstName$")
    public void enter_customer_FirstName() throws Throwable {

        searchCust = new searchCustomerPage(driver);
        searchCust.setFirstName("Victoria");

    }

    @When("^Enter customer LastName$")
    public void enter_customer_LastName() throws Throwable {

        searchCust.setLastName("Terces");

    }

    @Then("^User should found Name in the Search table$")
    public void user_should_found_Name_in_the_Search_table() throws Throwable {


      boolean status=  searchCust.searchCustomerByName("Victoria Terces");

      Assert.assertEquals(true,status);
    }


}
