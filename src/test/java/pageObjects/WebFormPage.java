package pageObjects;

import org.openqa.selenium.*;
import static java.lang.Thread.sleep;

public class WebFormPage {
    WebDriver driver;

    // Constructor to initialize WebDriver instance
    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter text into the text input field
    public void enterTextInput(String text) {
        driver.findElement(By.name("my-text")).sendKeys(text);
        System.out.println("✅ Entered text input: " + text);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Method to enter password into the password field
    public void enterPassword(String password) {
        driver.findElement(By.name("my-password")).sendKeys(password);
        System.out.println("✅ Entered password: " + password);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to enter text into the text area field
    public void enterTextArea(String text) {
        driver.findElement(By.name("my-textarea")).sendKeys(text);
        System.out.println("✅ Entered text in the text area: \n" + text);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to extract text from a disabled input field
    public String getDisabledInputText(String locator) {
        WebElement element = driver.findElement(By.xpath("//input[@name=\"my-disabled\"]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String disabledtext = (String) jsExecutor.executeScript("return arguments[0].value;", element);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return disabledtext;
    }

    // Method to extract value from a read-only input field
    public String getReadOnlyText(String locator) {
        WebElement element = driver.findElement(By.name("my-readonly"));
        // Use JavaScript to get the value of the readonly input field
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String readonlytext = (String) jsExecutor.executeScript("return arguments[0].value;", element);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return readonlytext;
    }

    // Method to select an option from a dropdown
    public void selectOption(String value) {
        WebElement dropdownElement = driver.findElement(By.name("my-select"));
        dropdownElement.sendKeys(value);
        System.out.println("✅ Selected value from dropdown: " + value);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to select an option from a datalist dropdown
    public void selectFromDatalist(String location) {
        WebElement dropdowninputField = driver.findElement(By.name("my-datalist"));
        dropdowninputField.sendKeys(location);
        System.out.println("✅ Selected value from datalist dropdown: " + location);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to check a checkbox
    public void checkCheckbox() {
        driver.findElement(By.xpath("//input[@id=\"my-check-2\"]")).click();
        System.out.println("✅ Clicking the checkbox");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to select a radio button
    public void SelectRadioButton() {
        driver.findElement(By.xpath("//input[@id=\"my-radio-2\"]")).click();
        System.out.println("✅ Clicking the radio button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to select a color from the color picker
    public void selectColor(String color) {
        WebElement selectedColor = driver.findElement(By.xpath("//input[@name=\"my-colors\"]"));
        selectedColor.sendKeys(color);
        System.out.println("✅ Selected a color from palette: " +color);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to submit the form
    public void submitForm() {
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();
        System.out.println("✅ Form submitted successfully !!!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
