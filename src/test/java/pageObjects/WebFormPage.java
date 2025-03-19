package pageObjects;

import org.openqa.selenium.*;
import static java.lang.Thread.sleep;

public class WebFormPage {
    WebDriver driver;

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterTextInput(String text) {
        driver.findElement(By.xpath("//*[@id=\"my-text-id\"]")).sendKeys(text);
        System.out.println("✅ Entered text input: " + text);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterPassword(String text) {
        driver.findElement(By.xpath("//input[@name=\"my-password\"]")).sendKeys(text);
        System.out.println("✅ Entered password: " + text);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterTextArea(String text) {
        driver.findElement(By.xpath("//textarea[@name=\"my-textarea\"]")).sendKeys(text);
        System.out.println("✅ Entered text in the text area: \n" + text);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDisabledInputText(String locator) {
        WebElement element = driver.findElement(By.xpath("//input[@name=\"my-disabled\"]"));
        // Use JavaScript to get the value of the disabled input field
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String disabledtext = (String) jsExecutor.executeScript("return arguments[0].value;", element);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return disabledtext;
    }

    public String getReadOnlyText(String locator) {
        WebElement element = driver.findElement(By.xpath("//input[@name=\"my-readonly\"]"));
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

    public void selectOption(String value) {
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@name=\"my-select\"]"));
        dropdownElement.sendKeys(value);
        System.out.println("✅ Selected value from dropdown: " + value);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectFromDatalist(String location) {
        WebElement dropdowninputField = driver.findElement(By.xpath("//input[@name='my-datalist']"));
        dropdowninputField.sendKeys(location);
        System.out.println("✅ Selected value from datalist dropdown: " + location);
        try {
            Thread.sleep(1000);  // Wait for 500ms for suggestions to show
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkCheckbox() {
        driver.findElement(By.xpath("//input[@id=\"my-check-2\"]")).click();
        System.out.println("✅ Clicking the checkbox");
        try {
            Thread.sleep(1000);  // Wait for 500ms for suggestions to show
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SelectRadioButton() {
        driver.findElement(By.xpath("//input[@id=\"my-radio-2\"]")).click();
        System.out.println("✅ Clicking the radio button");
        try {
            Thread.sleep(1000);  // Wait for 500ms for suggestions to show
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectColor(String color) {
        WebElement selectedColor = driver.findElement(By.xpath("//input[@name=\"my-colors\"]"));
        selectedColor.sendKeys(color);
        System.out.println("✅ Selected a color from palette: " +color);
        try {
            Thread.sleep(1000);  // Wait for 500ms for suggestions to show
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();
        System.out.println("✅ Form submitted successfully !!!");
        try {
            Thread.sleep(1000);  // Wait for 500ms for suggestions to show
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
