import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.Iterator;

public class CreateUserPage {

    @FindBy(linkText = "Create User")
    private WebElement createUser;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(xpath = "//input[@name = 'password1'][@type='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name = 'password2'][@type='password']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name = 'fullname'][@type='text']")
    private WebElement fullname;

    @FindBy(xpath = "//input[@name = 'email'][@type='text']")
    private WebElement email;

    @FindBy(id ="yui-gen1-button")
    private WebElement createUserButton;

    @FindBy(xpath = "//div[@class='error']")
    private WebElement errorMessage;

    public String getCreateUserButtonColor() {
        String color = createUserButton.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

    public String getErrorMessage()
    {
        return errorMessage.getText();
    }

    CreateUserPage setUserName(String name)
    {
        username.sendKeys(name);
        return this;
    }

    CreateUserPage setPassword(String password1)
    {
        password.sendKeys(password1);
        return this;
    }

    CreateUserPage setConfirmPassword(String password2)
    {
        confirmPassword.sendKeys(password2);
        return this;
    }
    CreateUserPage setFullName(String fullName)
    {
       fullname.sendKeys(fullName);
       return this;
    }

    CreateUserPage setEmail(String Email)
    {
        email.sendKeys(Email);
        return this;
    }

    CreateUserPage clickCreateUser_Button()
    {
        createUserButton.click();
        return this;
    }

    CreateUserPage pressCreateUser_Reference()
    {
        createUser.click();
        return this;
    }

    public boolean Create_User_Ref()
    {
       if(createUser.getText().equals("Create User"))
           return true;
       else return false;
    }

    public boolean check_Empty_Rows()
    {
        if (username.getText().equals("")&&fullname.getText().equals("")&&password.getText().equals("")
                &&confirmPassword.getText().equals("")&&email.getText().equals(""))
        {
            return true;
        }
        return false;
    }
    public boolean checkForm(WebDriver driver)//Проверяем форму на наличие полей
    {
        Collection<WebElement> elements = driver.findElements(By.tagName("form"));
        Iterator<WebElement> i = elements.iterator();
        WebElement element = null;
        boolean result = false;
        if (i.hasNext())
        {
            element = i.next();
            if (element.findElements(By.xpath("//input[@type='text']")).size()==3
            && element.findElements(By.xpath("//input[@type='password']")).size()==2)
            {
                result = true;
                return result;
            }
        }
        return false;
    }

    WebElement getUserName()
    {
        return username;
    }

    WebElement getFullname()
    {
        return fullname;
    }

    WebElement getPassword()
    {
        return password;
    }

    WebElement getConfirmPassword()
    {
        return confirmPassword;
    }

    WebElement getEmail()
    {
        return email;
    }


}
