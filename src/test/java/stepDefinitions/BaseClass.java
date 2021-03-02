package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.searchCustomerPage;

public class BaseClass {


    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCust;
    public searchCustomerPage searchCust;

    // Created for generating random string for unique email
    public static String randomestring() {

        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }
}
