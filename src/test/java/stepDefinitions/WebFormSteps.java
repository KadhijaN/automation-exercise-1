package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.WebFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportManager;

import java.util.Properties;

public class WebFormSteps {

    WebDriver driver;
    WebFormPage webFormPage;
    private ExtentTest test;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I open the Selenium web form page")
    public void open_the_web_form_page() {
        test = ExtentReportManager.createInstance().createTest("📃 Web Form Submission Initiated");
        test.info("User navigated to the Web Form");
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        webFormPage = new WebFormPage(driver);
    }

    @When("I fill out the text input field")
    public void fillTextInput() {
        test.info("User enters data in text input field");
        webFormPage.enterTextInput("Hello Test");
    }

    @And("I fill out the password field")
    public void fillPassword() {
        test.info("User enters ****** in the password field");
        webFormPage.enterPassword("Test@123");
    }

    @And("I fill out the text area field")
    public void fillTextArea() {
        test.info("User enters data in text area field");
        String textareainput="I am testing web automation. \n I would like to test multi-line commenting. \n I am testing the input fields in this web form.";
        webFormPage.enterTextArea(textareainput);
    }

    @And("I extract the text from the disabled text box")
    public void extractTextDisabledTextbox() {
        test.info("User trying to extract data from the disabled text box");
        String locator = "//input[@name=\"my-disabled\"]";
        String disabledText = webFormPage.getDisabledInputText(locator);
        System.out.println("✅ Fetching the text from disabled input field: " +disabledText);
    }

    @And("I read and display value from read-only input field")
    public void readTextReadOnlyInput() {
        test.info("User trying to fetch the value from read-only input field");
        String locator = "//input[@name=\"my-readonly\"]";
        String readOnlyText = webFormPage.getReadOnlyText(locator);
        System.out.println("✅ Fetching the text from read-only input field: " + readOnlyText);
    }

    @And("I select an option from the dropdown")
    public void selectDrodown() {
        test.info("User selects a value from the dropdown");
        webFormPage.selectOption("Two");
    }

    @And("I select an option from the datalist dropdown")
    public void selectLocationDropdown() {
        test.info("User selects the location from the dropdown");
        webFormPage.selectFromDatalist("New York");
    }

    @And("I check the checkbox")
    public void checkCheckBox() {
        test.info("User selects the check box");
        webFormPage.checkCheckbox();
    }

    @And("I select the radio button")
    public void selectRadioButton() {
        test.info("User selects the radio button");
        webFormPage.SelectRadioButton();
    }

    @And("I select a color {string} from the color picker")
    public void selectColorFromTheColorPicker(String color) {
        test.info("User picks a color from color palette");
        webFormPage.selectColor(color);
    }

    @When("I submit the form")
    public void submitForm() {
        test.info("User submits the form successfully !!!");
        webFormPage.submitForm();
        System.out.println("Web Form Successfully Submitted");
        test.pass("✅ Test passed successfully");
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

}
