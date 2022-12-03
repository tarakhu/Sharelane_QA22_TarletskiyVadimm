import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NegativeSignUp {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void negativeSignUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("123");

        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("thdrr");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("vladimir_holmes@019.36.sharelane.com");

        WebElement password1 = driver.findElement(By.name("password1"));
        password1.sendKeys("1111");

        WebElement password2 = driver.findElement(By.name("password2"));
        password2.sendKeys("1111");

        WebElement registrationButton = driver.findElement(By.cssSelector("[value=Register]"));
        registrationButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class=error_message]"));
        Assert.assertEquals(errorMessage.isDisplayed(), true);
    }
}

