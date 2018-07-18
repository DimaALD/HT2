import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
    private WebDriver driver;
    @FindBy(id = "j_username")
    private WebElement login;

    @FindBy(name = "j_password")
    private WebElement password;

    @FindBy (id = "yui-gen1")
    private WebElement loginButton;

    LogInPage setName(String name)
    {
        this.login.clear();
        this.login.sendKeys(name);
        return this;
    }
    LogInPage setPassword(String password)
    {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    LogInPage pressLogInButton()
    {
        this.loginButton.click();
        return this;
    }

}